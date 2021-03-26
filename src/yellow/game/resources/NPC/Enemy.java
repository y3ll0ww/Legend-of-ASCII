package yellow.game.resources.NPC;

import yellow.game.resources.objects.Map;
import yellow.game.resources.objects.PlayerCharacter;

import java.util.Random;

public class Enemy {
    Random rd = new Random();
    static String name; public static String getName(){ return name; }
    static String article; public static String getArticle(){ return article; }
    static int level; public static int getLevel(){ return level; }
    static int health; public static int getHealth(){ return health; }
    static int life; public static int getLife(){ return life; }
    static int damage; public static int getDamage(){ return damage; }
    static int defence; public static int getDefence(){ return defence; }
    static int magicdamage; public static int getMagicDamage(){ return magicdamage; }
    static int magicdefence; public static int getMagicDefence(){ return magicdefence; }
    static double escapeprevention;
    static double lootchance;
    public static double getEscapePrevention(){ return escapeprevention; }
    public static double getLootChance(){ return lootchance; }

    public static void takesDamage(int damage){
        life -= damage;
        if(life < 0){
            life = 0;
        }
    }

    public Enemy(int avatar, String name, int level, int health, int damage, int defence, int magicdamage, int magicdefence, double escapeprevention, double lootchance){
        Avatar.setAvatar(avatar);
        this.name = name;
        this.level = level;
        this.health = health;
        this.life = health;
        this.damage = damage;
        this.defence = defence;
        this.magicdamage = magicdamage;
        this.magicdefence = magicdefence;
        this.escapeprevention = escapeprevention;
        this.lootchance = lootchance;
    }

    public Enemy(String terrain){
        int pool = decideEnemyPool();
        spawnEnemy(terrain, pool);
    }
    public int decideEnemyPool(){
        double lowpool;
        double midpool;
        double highpool;
        double hardcorepool = 1.0;
        if(PlayerCharacter.getLevel() < 5){
            lowpool = 0.95; midpool = 0.99; highpool = 0.998;
        } else if(PlayerCharacter.getLevel() < 10){
            lowpool = 0.5; midpool = 0.9; highpool = 0.98;
        } else if(PlayerCharacter.getLevel() < 15){
            lowpool = 0.2; midpool = 0.7; highpool = 0.95;
        } else if(PlayerCharacter.getLevel() < 20) {
            lowpool = 0.2; midpool = 0.6; highpool = 0.85;
        } else {
            lowpool = 0.1; midpool = 0.4; highpool = 0.75;
        }
        double dice = rd.nextDouble();
        if(dice <= lowpool){
            return 0;
        } else if(dice <= midpool){
            return 1;
        } else if(dice <= highpool){
            return 2;
        } else {
            return 3;
        }
    }
    public void spawnEnemy(String terrain, int pool){
        int position = rd.nextInt(16);
        enemyList(position);
        //switch(terrain){
        //    case "Heath":
        //        switch(pool){
        //            case 0:
        //                //
        //        }
        //        break;
        //    case "Forest":
        //        break;
        //    case "Mountains":
        //        break;
        //    case "Swamp":
        //        break;
        //}
    }

    public void enemyList(int ix){
        this.level = generateLevel();
        Avatar.setAvatar(ix);
        switch(ix){
            case 0:
                this.name = "IMPERIAL SCOUT";
                this.article = "a";
                this.health = level * 6;
                this.damage = level * 4;
                this.defence = level * 3;
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.5;
                this.lootchance = 0.6;
                break;
            case 1:
                this.name =  "WIZARD";
                this.article = "a";
                this.health = level * 10;
                this.damage = (int)Math.round(level * 1.2);
                this.defence = (int)Math.round(level * 1.2);
                this.magicdamage = (int)Math.round(level * 7.8);
                this.magicdefence = (int)Math.round(level * 8.3);
                this.escapeprevention = 0.3;
                this.lootchance = 0.7;
                break;
            case 2:
                this.name = "IMPERIAL KNIGHT";
                this.article = "an";
                this.health = level * 11;
                this.damage = level * 5;
                this.defence = level * 4;
                this.magicdamage = 0;
                this.magicdefence = level * 2;
                this.escapeprevention = 0.3;
                this.lootchance = 0.9;
                break;
            case 3:
                this.name = "WOOD ELF";
                this.article = "a";
                this.health = level * 10;
                this.damage = (int)Math.round(level * 3.7);
                this.defence = level * 3;
                this.magicdamage = level * 6;
                this.magicdefence = (int)Math.round(level * 4.7);
                this.escapeprevention = 0.4;
                this.lootchance = 0.7;
                break;
            case 4:
                this.name = "ORC WARRIOR";
                this.article = "an";
                this.health = level * 12;
                this.damage = (int)Math.round(level * 6.2);
                this.defence = level * 7;
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.4;
                this.lootchance = 0.8;
                break;
            case 5:
            case 6:
                this.name = "BAT";
                this.article = "a";
                this.health = level * 3;
                this.damage = (int)Math.round(level * 1.2);
                this.defence = (int)Math.round(level * 1.1);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.9;
                this.lootchance = 0.2;
                break;
            case 7:
                this.name = "EAGLE";
                this.article = "an";
                this.health = level * 4;
                this.damage = (int)Math.round(level * 2.2);
                this.defence = (int)Math.round(level * 2.1);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.8;
                this.lootchance = 0.3;
                break;
            case 8:
                this.name = "TIGER";
                this.article = "a";
                this.health = level * 8;
                this.damage = (int)Math.round(level * 4.7);
                this.defence = (int)Math.round(level * 3.6);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.3;
                this.lootchance = 0.4;
                break;
            case 9:
                this.name = "MOUNTAIN LION";
                this.article = "a";
                this.health = level * 7;
                this.damage = level * 5;
                this.defence = level * 4;
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.3;
                this.lootchance = 0.4;
                break;
            case 10:
                this.name = "TAZMANIAN DEVIL";
                this.article = "a";
                this.health = level * 5;
                this.damage = (int)Math.round(level * 2.7);
                this.defence = (int)Math.round(level * 1.9);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.7;
                this.lootchance = 0.3;
                break;
            case 11:
                this.name = "RHINOCEROS";
                this.article = "a";
                this.health = level * 15;
                this.damage = (int)Math.round(level * 8.6);
                this.defence = (int)Math.round(level * 9.8);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.7;
                this.lootchance = 0.3;
                break;
            case 12:
                this.name = "SCORPION";
                this.article = "a";
                this.health = level * 3;
                this.damage = (int)Math.round(level * 1.2);
                this.defence = (int)Math.round(level * 0.8);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.9;
                this.lootchance = 0.2;
                break;
            case 13:
                this.name = "TARANTULA";
                this.article = "a";
                this.health = level * 5;
                this.damage = (int)Math.round(level * 1.4);
                this.defence = (int)Math.round(level * 1.2);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.9;
                this.lootchance = 0.2;
                break;
            case 14:
                this.name = "WOLF";
                this.article = "a";
                this.health = level * 9;
                this.damage = (int)Math.round(level * 3.6);
                this.defence = (int)Math.round(level * 4.3);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.7;
                this.lootchance = 0.4;
                break;
            case 15:
                this.name = "DUSKBEAST";
                this.article = "a";
                this.health = level * 16;
                this.damage = (int)Math.round(level * 12.7);
                this.defence = (int)Math.round(level * 9.6);
                this.magicdamage = 0;
                this.magicdefence = 0;
                this.escapeprevention = 0.4;
                this.lootchance = 0.8;
                break;
        }
        this.life = this.health;
    }
    public int generateLevel(){
        int level;
        if(PlayerCharacter.getLevel() < 5){
            level = rd.nextInt(7) + 1;
        } else if(PlayerCharacter.getLevel() < 10){
            level = rd.nextInt(20) + 1;
        } else if(PlayerCharacter.getLevel() < 15){
            level = rd.nextInt(35) + 1;
        } else if(PlayerCharacter.getLevel() < 20) {
            level = rd.nextInt(50) + 1;
        } else {
            level = rd.nextInt(100) + 1;
        }
        return level;
    }
}
