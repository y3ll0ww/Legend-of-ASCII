package yellow.game.resources;

import yellow.game.gui.AudioPlayer;
import yellow.game.gui.LayoutPicker;
import yellow.game.resources.NPC.Enemy;
import yellow.game.resources.objects.PlayerCharacter;

import java.util.Random;

public class BattleMode {
    static Random rd = new Random();
    static boolean playergoesfirst;
    public static boolean getPlayerGoesFirst(){ return playergoesfirst; }
    static boolean spells; public static boolean getSpells(){ return spells; }
    static String displayinfo = "";
    public static String getDisplayInfo(){ return displayinfo; }
    static int enterentry;
    public static int getEnterEntry(){ return enterentry; }

    public BattleMode(double initiative, int entry, String attacking, String attacked){
        displayinfo = "   ";
        enterentry = entry;
        LayoutPicker.entry = 9960;
        if(rd.nextDouble() < initiative){
            displayinfo += attacking;
            playergoesfirst = true;
        } else {
            displayinfo += attacked;
            playergoesfirst = false;
        }
    }
    public BattleMode(double initiative){
        //Nieuw scherm: You encountered <naam>
        //Initiative roll 50/50 (monster afhankelijk?)
        enterentry = LayoutPicker.entry;
        LayoutPicker.entry = 9960;
        double decide = rd.nextDouble();
        if(decide < initiative){
            displayinfo = "   You've encountered " + Enemy.getArticle() + " <font color='RED'>" + Enemy.getName() + "</font>.";
            playergoesfirst = true;
        } else {
            displayinfo = "   You're being attacked by " + Enemy.getArticle() + " <font color='RED'>" + Enemy.getName() + "</font>.";
            playergoesfirst = false;
        }

    }
    public static void setDisplayInfo(String info){
        displayinfo = info;
    }
    public static String displayName(){
        String display = "   !   " + Enemy.getName() + " (LVL " + Enemy.getLevel() + ")";
        String spaces = "";
        if(display.length() < 89){
            for(int i = 0; i < 88 - display.length(); i++){
                spaces += " ";
            }
            display += spaces;
        }
        display += "   !";
        return display;
    }
    public static String displayHealthBar(){
        String[] healthbar = new String[81];
        for(int i = 0; i < healthbar.length; i++){
            healthbar[i] = "#";
        }
        if(Enemy.getLife() == 0){
            for(int j = 0; j < healthbar.length; j++){
                healthbar[j] = "-";
            }
        } else if(Enemy.getLife() < Enemy.getHealth()){
            float lostlife = (float)healthbar.length * ((float)Enemy.getLife() / (float)Enemy.getHealth());
            for(int x = healthbar.length - 1; x >= (int)lostlife; x--){
                healthbar[x] = "-";
            }
        }
        String fcolor = "<font color='";
        if(Enemy.getLife() < Enemy.getHealth() / 5) {
            fcolor += "RED'>";
        } else if(Enemy.getLife() < Enemy.getHealth() / 2) {
            fcolor += "ORANGE'>";
        } else if(Enemy.getLife() < Enemy.getHealth() / 1.5){
            fcolor += "GOLD'>";
        } else {
            fcolor += "LIME'>";
        }
        String display = "   :  {" + fcolor;
        for(int x = 0; x < healthbar.length; x++){
            display += healthbar[x];
        }
        display += "</font>}  :";
        return display;
    }
    public static String displayHealthNumeric(){
        String display = "   !";
        int length = 85 - display.length() - Integer.toString(Enemy.getHealth()).length() - Integer.toString(Enemy.getLife()).length();
        for(int i = 0; i < length; i++){
            display += " ";
        }
        display += Enemy.getLife() + " / " + Enemy.getHealth() + "   !";
        return display;
    }
    public static String displayAttack(int ix){
        String display = "";
        if(!spells){
            int weapon = defineWeapon();
            if(weapon < 2){
                display += Inventory.Equipment[weapon].getAttackName(ix, true);
            } else {
                display = "           [<font color='YELLOW'>" + (ix + 1) + "</font>] ";
                if(ix == 0){
                    display += "PUNCH";
                } else {
                    display += "<...>";
                }
                int spaces = 50 - display.length();
                for (int i = 0; i < spaces; i++) {
                    display += " ";
                }
            }
        } else {
            // spells tonen
        }
        return display;
    }
    public static int defineWeapon(){
        if(Inventory.Equipment[0] != null && Inventory.Equipment[0].isWeapon()){
            return 0;
        } else if(Inventory.Equipment[1] != null && Inventory.Equipment[1].isWeapon()){
            return 1;
        } else {
            return 2; // No weapon
        }
    }

    //// BATTLE FUNCTIONS
    ///////////////////////////////////////////////////////////
    ///What to do when no energy left?
    public static void doDamage(int attack){
        int weapon = defineWeapon();
        int damage;
        int NRGY = 3;
        if(weapon < 2){
            NRGY = Inventory.Equipment[weapon].getAttackNRGY(attack);
        }
        String equipment;
        String with;
        if(!spells){
            double strength = PlayerCharacter.getStrength() / 100.0f;
            double multiplier = rd.nextDouble() + 1.0;
            if(weapon < 2){
                System.out.println("NRGY=" + NRGY);
                damage = (int)Math.round(((Inventory.Equipment[weapon].getDamage() * strength) * (NRGY / 10 + 1.0) * multiplier - Enemy.getDefence()) * (NRGY / 2));
                //NRGY = Inventory.Equipment[weapon].getAttackNRGY(attack);
                equipment = Inventory.Equipment[weapon].getAttackName(attack, false);
                with = equipment;
            } else {
                damage = (int)Math.round(strength * multiplier * 7.5 - Enemy.getDefence());
                NRGY = 3;
                equipment = "PUNCH";
                with = "<font color='WHITE'>your bare hands</font>";
            }
            String butand;
            if(damage <= 0){
                damage = 0;
                butand = "but unfortunately";
            } else {
                butand = "and";
            }
            Enemy.takesDamage(damage);
            AudioPlayer.attackSounds(equipment);
            PlayerCharacter.setEnergy(PlayerCharacter.getEnergy() - NRGY);
            displayinfo = "   You attacked with <font color='MAGENTA'>" + with + "</font> " + butand + " did <font color='YELLOW'>" + damage + "</font> damage.";
            ///////////////
            System.out.println(strength + " * " + multiplier + " = " + damage + " - " + Enemy.getDefence());

        }
    }
    public static void takeDamage(){
        double multiplier = rd.nextDouble() + 1.0;
        int damage = (int)((double)Enemy.getDamage() * multiplier) - (PlayerCharacter.getDefence() / 10);
        String butand;
        if(damage < 0){
            damage = 0;
            butand = ", but it couldn't do any";
        } else {
            butand = " and suffered <font color='YELLOW'>" + damage + "</font>";
        }
        PlayerCharacter.setHP(-damage);
        displayinfo = "   You got attacked by the <font color='RED'>" + Enemy.getName() + "</font>" + butand + " damage.";
    }
    public static boolean enemyDied(){
        if(Enemy.getLife() == 0){
            addEnemyXP();
            return true;
        } else {
            return false;
        }
    }
    public static int addEnemyXP(){
        int high = 0;
        int[] stats = new int[4];
        stats[0] = Enemy.getDamage();
        stats[1] = Enemy.getDefence();
        stats[2] = Enemy.getMagicDamage();
        stats[3] = Enemy.getMagicDefence();
        for(int i = 0; i < stats.length; i++){
            if(stats[i] > high){
                high = stats[i];
            }
        }
        PlayerCharacter.setXP(PlayerCharacter.getXP() + high);
        return high;
    }
    static boolean loot;
    public static boolean hasLoot(){ return loot; }
    public static void generateLoot(){
        double lootchance = rd.nextDouble();
        if(lootchance < Enemy.getLootChance()){
            loot = true;
            LootBox foe = new LootBox(true);
            displayinfo = "   The enemy left <font color='MAGENTA'>" + foe.getLootName() + "</font>!";
        } else {
            loot = false;
        }
    }
    public static boolean tryEscape(){
        double chance = rd.nextDouble();
        if(chance < Enemy.getEscapePrevention()){
            return true;
        } else {
            return false;
        }
    }

}
