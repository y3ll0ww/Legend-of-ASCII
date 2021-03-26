package yellow.game.resources.objects.items;

import java.util.Random;

public abstract class Item {
    public String name;
    public int level;
    public Random rd = new Random();

    public static String material;
    public int matclass;
    public int weight;
    public static double magicmultiplier;
    public static double damagemultiplier;
    public static double defencemultiplier;
    public String type;
    public int typeclass;
    public String magictype;

    boolean weapon;
    boolean shield;
    boolean head;
    boolean armor;
    boolean feet;
    boolean potion;

    public void makeWeapon(boolean set){ this.weapon = set; }
    public void makeShield(boolean set){ this.shield = set; }
    public void makeHead(boolean set){ this.head = set; }
    public void makeArmor(boolean set){ this.armor = set; }
    public void makeFeet(boolean set){ this.feet = set; }
    public void makePotion(boolean set){ this.potion = set; }

    public boolean isWeapon(){ return this.weapon; }
    boolean isShield(){ return this.shield; }
    public boolean isHead(){ return this.head; }
    boolean isArmor(){ return this.armor; }
    boolean isFeet(){ return this.feet; }

    String[] audiofiles = new String[5];
    public void setAudioFile(int ix, String file){
        audiofiles[ix] = file;
    }

    String checkItemType(){
        if(isWeapon()){ return "Weapon"; }
        else if(isShield()){ return "Shield"; }
        else if(isHead()){ return "Head"; }
        else if(isArmor()) { return "Armor"; }
        else if(isFeet()) { return "Feet"; }
        else { return "none"; }
    }
    public void setName(String name){ this.name = name; }
    public void setLevel(int level){ this.level = level; }
    public void setMaterial(int level){
        Material apply = new Material(level);
        material = apply.mat[0];
        weight = Integer.valueOf(apply.mat[1]);
        magicmultiplier = Double.valueOf(apply.mat[2]);
        damagemultiplier = Double.valueOf(apply.mat[3]);
    }
    public int getRandomTypePool() {
        double percent = rd.nextDouble();
        int pool = 0;
        //Select which pool to pick a random weapon from; percentages determined based on material class
        switch (this.matclass) {
            case 0:
                pool = 0;
                break;
            case 1:
                if (percent <= 0.5) {
                    if(!isHead()){ //Lowest headtypes can only have lowest materialtypes
                        pool = 0;
                    } else {
                        pool = 1;
                    }
                } else if (percent <= 0.8) {
                    pool = 1;
                } else if (percent <= 1.0) {
                    pool = 2;
                }
                break;
            case 2:
                if (percent <= 0.05) {
                    if(!isHead()){ //Lowest headtypes can only have lowest materialtypes
                        pool = 0;
                    } else {
                        pool = 1;
                    }
                } else if (percent <= 0.3) {
                    pool = 1;
                } else if (percent <= 0.8) {
                    pool = 2;
                } else if (percent <= 1.0) {
                    pool = 3;
                }
                break;
            case 3:
                if (percent <= 0.3) {
                    pool = 1;
                } else if (percent <= 0.6) {
                    pool = 2;
                } else if (percent <= 0.95) {
                    pool = 3;
                } else if (percent <= 1.0) {
                    pool = 4;
                }
                break;
            case 4:
                if (percent <= 0.5) {
                    pool = 2;
                } else if (percent <= 0.9) {
                    pool = 3;
                } else if (percent <= 1.0) {
                    pool = 4;
                }
        }
        return pool;
    }
    public int getWeight(){ return weight; }


    /////////// GENERIC EQUIPABLES
    public String getName(){ return this.name; };
    public int getLevel(){ return this.level; };
    public int getMatClass(){ return this.matclass; };
    public int getTypeClass(){ return this.typeclass; };
    public abstract int isMagical();
    /////////// WEAPONS
    public abstract int getDamage();
    public abstract int getMagicDamage();
    public abstract String getMagicType();
    public abstract boolean isTwoHanded();
    public abstract boolean isRanged();
    public abstract String getAttackName(int ix, boolean layout);
    public abstract int getAttackNRGY(int attack);
    public abstract Attack getAttacks();
    /////////// OTHERS
    public abstract int getDefence();
    public abstract int getMagicDefence();
}
