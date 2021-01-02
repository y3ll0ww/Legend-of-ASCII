package yellow.game.resources;

import yellow.game.gui.AudioPlayer;
import yellow.game.gui.LayoutPicker;
import yellow.game.resources.NPC.Enemy;
import yellow.game.resources.objects.PlayerCharacter;

import java.util.Random;

public class BattleMode {
    static Random rd = new Random();
    static boolean playergoesfirst; public static boolean getPlayerGoesFirst(){ return playergoesfirst; }
    static boolean spells; public static boolean getSpells(){ return spells; }
    static String displayinfo = ""; public static String getDisplayInfo(){ return displayinfo; }
    static int enterentry; public static int getEnterEntry(){ return enterentry; }
    public BattleMode(double initiative){
        //Nieuw scherm: You encountered <naam>
        //Initiative roll 50/50 (monster afhankelijk?)
        enterentry = LayoutPicker.entry;
        LayoutPicker.entry = 9960;
        double decide = rd.nextDouble();
        if(decide < initiative){
            displayinfo = "   You've encountered " + Enemy.getArticle() + " " + Enemy.getName() + ". You have initiative and go first.";
            playergoesfirst = true;
        } else {
            displayinfo = "   You're being attacked by " + Enemy.getArticle() + " " + Enemy.getName() + ". The " + Enemy.getName() + " has initiative and goes first.";
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
        String display = "   :  {";
        for(int x = 0; x < healthbar.length; x++){
            display += healthbar[x];
        }
        display += "}  :";
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
                // geen wapen
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
            return 2;
        }
    }

    //// BATTLE FUNCTIONS
    public static void doDamage(int attack){
        int weapon = defineWeapon();
        if(!spells && weapon < 2){
            double strength = PlayerCharacter.getStrength() / 100.0f;
            double multiplier = rd.nextDouble() + 1.0;
            int damage = (int)Math.round((Inventory.Equipment[weapon].getDamage() * strength) * (Inventory.Equipment[weapon].getAttackNRGY(attack) / 10 + 1.0) * multiplier - Enemy.getDefence());
            String butand;
            if(damage <= 0){
                damage = 0;
                butand = "but unfortunately";
            } else {
                butand = "and";
            }
            Enemy.takesDamage(damage);
            AudioPlayer.attackSounds(Inventory.Equipment[weapon].getAttackName(attack, false));
            PlayerCharacter.setEnergy(-Inventory.Equipment[weapon].getAttackNRGY(attack));
            displayinfo = "   You attacked with " + Inventory.Equipment[weapon].getAttackName(attack, false) + " " + butand + " did " + damage + " damage.";
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
            butand = " and suffered " + damage;
        }
        PlayerCharacter.setHP(-damage);
        displayinfo = "   You got attacked by the " + Enemy.getName() + butand + " damage.";
    }
    public static boolean enemyDied(){
        if(Enemy.getLife() == 0){
            return true;
        } else {
            return false;
        }
    }
    static boolean loot; public static boolean hasLoot(){ return loot; }
    public static void generateLoot(){
        double lootchance = rd.nextDouble();
        if(lootchance < 1.0){ ///////////////////////////////////////////BASED ON ENEMY POOL
            displayinfo = "   wtf met HOOFDLETTERS : WTFFFF";
            loot = true;
            LootBox foe = new LootBox(true);
            displayinfo = "   The enemy left " + foe.getLootName() + "!";
        } else {
            loot = false;
            displayinfo = "   The enemy is not carrying anything interesting...";
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
