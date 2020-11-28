package yellow.game.resources.objects;

import java.util.Random;

public class Weapon extends Item {
    Random rd = new Random();

    String name;
    //int level;
    boolean twohanded;
    boolean ranged;
    int ismagical; // 0 = false; 1 = true; 2 = undecided;
    int weight;

    String material;
    int matclass;
    String type;
    int typeclass;

    int damage;
    int magicdamage;
    String magictype;

    double magicmultiplier;
    double damagemultiplier;

    public String getName() { return this.name; }
    public int getLevel() { return this.level; }
  //  public int getWeight() { return this.weight; }
    public int getDamage() { return this.damage; }
    public int getMagicDamage() { return this.magicdamage; }
    public String getMagicType() { return this.magictype; }
    public int getMatClass() { return this.matclass; }
    public int getTypeClass() { return this.typeclass; }
    public boolean isTwoHanded() { return this.twohanded; }
    public boolean isRanged() { return this.ranged; }
    public int isMagical() { return this.ismagical; } // 0 = false; 1 = true;

    public int getDefence() { return 0; }
    public int getMagicDefence() { return 0; }

    public Weapon(String name, int level, String material, String type, int weight, int damage, int magicdamage, String magictype, boolean twohanded, boolean ranged, boolean ismagical) {
        this.level = level;
        this.material = material;
        this.type = type;
        this.weight = weight;
        this.damage = damage;
        this.magicdamage = magicdamage;
        this.magictype = magictype;
        this.twohanded = twohanded;
        this.ranged = ranged;
        if(ismagical == true){
            this.ismagical = 1;
        }
        setWeaponName(name);
        makeWeapon(true);
    }
    public void setWeaponName(String name){
        if (name == "no" || name == "false" || name == "none" || name == " " || name == ""){
            if(this.ismagical == 1){
                this.name = this.material + " " + this.magictype + " " + this.type;
            } else {
                this.name = this.material + " " + this.type;
            }
        } else { this.name = name; }
    }
    //Get random weapon based on level
    public Weapon(int level, String name){
        this.level = level;
        Material mat = new Material(level, checkItemType());
        setRandomType();
        if(this.ismagical == 2){ //ismagical = undecided
            int decideifmagical = rd.nextInt(100);
            if(decideifmagical <= 70){
                this.ismagical = 0;
            } else { this.ismagical = 1; }
        }
        if(this.ismagical == 1){ //ismagical = true
            setMagicType(rd.nextInt(getMagicTypeLength() - 1));
        }
        makeWeapon(true);
        setWeaponName(name);
        setDamage();
        setMagicDamage();
    }

    void setDamage(){
        double damagemultiplier = 5.0;
        if(PlayerCharacter.getClassmode() == "warrior" && this.twohanded == true){
            damagemultiplier += 2.3;
        } else if(PlayerCharacter.getClassmode() == "ranger" && this.ranged == true){
            damagemultiplier += 2.3;
        } else if(PlayerCharacter.getClassmode() == "rogue" && this.twohanded == false){
            damagemultiplier += 2.3;
        }
        double damage = 0.0;
        switch(this.typeclass){
            case 0:
                damage = this.level * (2.5 + damagemultiplier);
                break;
            case 1:
                damage = this.level * (3.75 + damagemultiplier);
                break;
            case 2:
                damage = this.level * (4.9 + damagemultiplier);
                break;
            case 3:
                damage = this.level * (5.5 + damagemultiplier);
                break;
            case 4:
                damage = this.level * (8 + damagemultiplier);
        }
        this.damagemultiplier = damagemultiplier;
        this.damage = (int)Math.round(damage);
    }
    void setMagicDamage(){
        double magicmultiplier = 5.0;
        if(PlayerCharacter.getClassmode() == "mage" && this.ismagical == 1){
            magicmultiplier += 2.3;
        }
        double magicdamage = 0.0;
        switch(this.typeclass){
            case 0:
                magicdamage = this.level * (2.5 + magicmultiplier);
                break;
            case 1:
                magicdamage = this.level * (3.75 + magicmultiplier);
                break;
            case 2:
                magicdamage = this.level * (4.9 + magicmultiplier);
                break;
            case 3:
                magicdamage = this.level * (5.5 + magicmultiplier);
                break;
            case 4:
                magicdamage = this.level * (8 + magicmultiplier);
        }
        this.magicmultiplier = magicmultiplier;
        this.magicdamage = (int)Math.round(magicdamage);
    }

    int getMagicTypeLength() { return 9; };
    void setMagicType(int position){
        int numberofattributes = 2;
        //0 = magic name; 1 = magicmultiplier
        String[][] magicpowers = new String[getMagicTypeLength()][numberofattributes];
        magicpowers[0][0] = "FIRE";
                magicpowers[0][1] = "0.6";
        magicpowers[1][0] = "WATER";
                magicpowers[1][1] = "0.6";
        magicpowers[2][0] = "EARTH";
                magicpowers[2][1] = "0.6";
        magicpowers[3][0] = "AIR";
                magicpowers[3][1] = "0.6";
        magicpowers[4][0] = "ACID";
                magicpowers[4][1] = "0.8";
        magicpowers[5][0] = "PSYCHO";
                magicpowers[5][1] = "0.8";
        magicpowers[6][0] = "THUNDER";
                magicpowers[6][1] = "1.5";
        magicpowers[7][0] = "FROST";
                magicpowers[7][1] = "0.8";
        magicpowers[8][0] = "NECRO";
                magicpowers[8][1] = "1.5";

        this.magictype = magicpowers[position][0];
        this.magicmultiplier += Double.parseDouble(magicpowers[position][1]);
    }

    int getLowestTypeLength(){ return 7; }
    int getLowTypeLength(){ return 9; }
    int getMidTypeLength(){ return 7; }
    int getHighTypeLength(){ return 10; }
    int getHighestTypeLength(){ return 10; }

    void setType(int weaponpool, int position){
        int numberofattributes = 7;
        //[0] = String name; [1] = boolean twohanded; [2] = boolean ranged; [3] = magic(true,false,undecided); [4] = int weight; [5] = double magicmultiplier [6] = double damagemultiplier

        String[][] lowesttype = new String[getLowestTypeLength()][numberofattributes];
        for(int i = 0; i < getLowestTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                lowesttype[i][j] = "False";
            } }
        lowesttype[0][0] = "SHORT SWORD";
                lowesttype[0][3] = "False"; //NO magic
                lowesttype[0][4] = "20"; //weight
        lowesttype[1][0] = "DAGGER";
                lowesttype[1][3] = "False"; //NO magic
                lowesttype[1][4] = "10"; //weight
        lowesttype[2][0] = "CLUB";
                lowesttype[2][3] = "False"; //NO magic
                lowesttype[2][4] = "20"; //weight
        lowesttype[3][0] = "SLING";
                lowesttype[3][2] = "True"; //ranged
                lowesttype[3][3] = "False"; //NO magic
                lowesttype[3][4] = "10"; // weight
        lowesttype[4][0] = "SPEAR";
                lowesttype[4][3] = "False"; //NO magic
                lowesttype[4][4] = "20"; //weight
        lowesttype[5][0] = "ROD";
                lowesttype[5][3] = "True"; //magic
                lowesttype[5][4] = "10"; //weight
        lowesttype[6][0] = "STICK";
                lowesttype[6][4] = "10"; //weight
                lowesttype[6][6] = "-0.2"; //damagemultiplier

        String[][] lowtype = new String[getLowTypeLength()][numberofattributes];
        for(int i = 0; i < getLowTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                lowtype[i][j] = "False";
            } }
        lowtype[0][0] = "LONG SWORD";
                lowtype[0][1] = "True"; //twohanded
                lowtype[0][4] = "30"; //weight
        lowtype[1][0] = "KATANA";
                lowtype[1][4] = "20"; //weight
        lowtype[2][0] = "KNIFE";
                lowtype[2][4] = "10"; //weight
        lowtype[3][0] = "LIGHT HAMMER";
                lowtype[3][4] = "20"; //weight
        lowtype[4][0] = "LIGHT MACE";
                lowtype[4][4] = "30"; //weight
        lowtype[5][0] = "LONG BOW";
                lowtype[5][1] = "True"; //twohanded
                lowtype[5][2] = "True"; //ranged
                lowtype[5][4] = "20"; //weight
        lowtype[6][0] = "RECURVED BOW";
                lowtype[6][1] = "True"; //twohanded
                lowtype[6][2] = "True"; //ranged
                lowtype[6][4] = "30"; //weight
        lowtype[7][0] = "HAND AXE";
                lowtype[7][4] = "30"; //weight
        lowtype[8][0] = "WAND";
                lowtype[8][3] = "True"; // magic
                lowtype[8][4] = "10"; //weight

        String[][] midtype = new String[getMidTypeLength()][numberofattributes];
        for(int i = 0; i < getMidTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                midtype[i][j] = "False";
            } midtype[i][3] = "Undecided";
        }
        midtype[0][0] = "BROADSWORD";
                midtype[0][1] = "True"; //twohanded
                midtype[0][4] = "40"; //weight
        midtype[1][0] = "GREATSWORD";
                midtype[1][1] = "True"; //twohanded
                midtype[1][4] = "50"; //weight
        midtype[2][0] = "RAPIER";
                midtype[2][4] = "30"; //weight
        midtype[3][0] = "GREATAXE";
                midtype[3][1] = "True"; //twohanded
                midtype[3][4] = "40"; //weight
        midtype[4][0] = "LIGHT CROSSBOW";
                midtype[4][1] = "True"; //twohanded
                midtype[4][2] = "True"; //ranged
                midtype[4][4] = "40"; //weight
        midtype[5][0] = "HEAVY MACE";
                midtype[5][1] = "True"; //twohanded
                midtype[5][4] = "40"; //weight
        midtype[6][0] = "QUARTERSTAFF";
                midtype[6][1] = "True"; //twohanded
                midtype[6][3] = "True"; //magic
                midtype[6][4] = "20"; //weight

        String[][] hightype = new String[getHighTypeLength()][numberofattributes];
        for(int i = 0; i < getHighTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                hightype[i][j] = "False";
            } hightype[i][3] = "Undecided";
        }
        hightype[0][0] = "SCIMITAR";
                hightype[0][4] = "30"; //weight
        hightype[1][0] = "GREAT BOW";
                hightype[1][1] = "True"; //twohanded
                hightype[1][2] = "True"; //ranged
                hightype[1][4] = "30"; //weight
        hightype[2][0] = "WAR BOW";
                hightype[2][1] = "True"; //twohanded
                hightype[2][2] = "True"; //ranged
                hightype[2][4] = "40"; //weight
        hightype[3][0] = "HEAVY CROSSBOW";
                hightype[3][1] = "True"; //twohanded
                hightype[3][2] = "True"; //ranged
                hightype[3][4] = "50"; //weight
        hightype[4][0] = "BASTARD SWORT";
                hightype[4][1] = "True"; //twohanded
                hightype[4][4] = "40"; //weight
        hightype[5][0] = "FALCHION";
                hightype[5][4] = "30"; //weight
        hightype[6][0] = "WARAXE";
                hightype[6][1] = "True"; //twohanded
                hightype[6][4] = "50"; //weight
        hightype[7][0] = "GREAT MACE";
                hightype[7][1] = "True"; //twohanded
                hightype[7][4] = "50"; //weight
        hightype[8][0] = "MAUL";
                hightype[8][1] = "True"; //twohanded
                hightype[8][4] = "50"; //weight
        hightype[9][0] = "STAFF";
                hightype[9][3] = "True"; //magic
                hightype[9][4] = "20"; //weight

        String[][] highesttype = new String[getHighestTypeLength()][numberofattributes];
        for(int i = 0; i < getHighestTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                highesttype[i][j] = "False";
            } highesttype[i][3] = "Undecided";
        }
        highesttype[0][0] = "GREAT MACE";
                highesttype[0][1] = "True"; //twohanded
                highesttype[0][4] = "80"; //weight
        highesttype[1][0] = "WARHAMMER";
                highesttype[1][1] = "True"; //twohanded
                highesttype[1][4] = "80"; //weight
        highesttype[2][0] = "HALBERT";
                highesttype[2][1] = "True"; //twohanded
                highesttype[2][4] = "60"; //weight
        highesttype[3][0] = "WARBOW";
                highesttype[3][1] = "True"; //twohanded
                highesttype[3][2] = "True"; //ranged
                highesttype[3][4] = "60"; //weight
        highesttype[4][0] = "ALBALEST";
                highesttype[4][1] = "True"; //twohanded
                highesttype[4][2] = "True"; //ranged
                highesttype[4][4] = "60"; //weight
        highesttype[5][0] = "KUKRI";
                highesttype[5][4] = "40"; //weight
        highesttype[6][0] = "BLACKBLADE";
                highesttype[6][4] = "50"; //weight
                highesttype[6][6] = "0.8"; //damagemultiplier
        highesttype[7][0] = "EXCALIBUR";
                highesttype[7][3] = "True"; //magic
                highesttype[7][4] = "70"; //weight
                highesttype[7][5] = "0.8"; //magicmultiplier
        highesttype[8][0] = "SOULSWORD";
                highesttype[8][3] = "True"; //magic
                highesttype[8][4] = "70"; //weight
                highesttype[8][5] = "0.8"; //magicmultiplier
        highesttype[9][0] = "GREATSTAFF";
                highesttype[9][1] = "True"; //twohanded
                highesttype[9][3] = "True"; //magic
                highesttype[9][4] = "50"; //weight
                highesttype[9][5] = "2.5"; //magicmultiplier

        if(weaponpool == 0) {
            this.typeclass = 0;
            assignTypeValues(lowesttype, position);
        } else if(weaponpool == 1){
            this.typeclass = 1;
            assignTypeValues(lowtype, position);
        } else if(weaponpool == 2){
            this.typeclass = 2;
            assignTypeValues(midtype, position);
        } else if(weaponpool == 3){
            this.typeclass = 3;
            assignTypeValues(hightype, position);
        } else if(weaponpool == 4){
            this.typeclass = 4;
            assignTypeValues(highesttype, position);
        }
    }
    void setRandomType(){
        double percent = rd.nextDouble();
        int weaponpool = 0;
        //Select which pool to pick a random weapon from; percentages determined based on material class
        switch(this.matclass){
            case 0:
                weaponpool = 0;
                break;
            case 1:
                if(percent <= 0.5){
                    weaponpool = 0;
                } else if (percent <= 0.8){
                    weaponpool = 1;
                } else if (percent <= 1.0) {
                    weaponpool = 2;
                } break;
            case 2:
                if(percent <= 0.05){
                    weaponpool = 0;
                } else if (percent <= 0.3){
                    weaponpool = 1;
                } else if (percent <= 0.8){
                    weaponpool = 2;
                } else if (percent <= 1.0){
                    weaponpool = 3;
                } break;
            case 3:
                if(percent <= 0.3){
                    weaponpool = 1;
                } else if (percent <= 0.6){
                    weaponpool = 2;
                } else if (percent <= 0.95){
                    weaponpool = 3;
                } else if (percent <= 1.0){
                    weaponpool = 4;
                } break;
            case 4:
                if(percent <= 0.5){
                    weaponpool = 2;
                } else if (percent <= 0.9){
                    weaponpool = 3;
                } else if (percent <= 1.0){
                    weaponpool = 4;
                }
        }

        //Pick a random weapon within weaponpool
        int random;
        switch(weaponpool){
            case 0:
                random = rd.nextInt(getLowestTypeLength() - 1);
                setType(0, random);
                break;
            case 1:
                random = rd.nextInt(getLowTypeLength() - 1);
                setType(1, random);
                break;
            case 2:
                random = rd.nextInt(getMidTypeLength() - 1);
                setType(2, random);
                break;
            case 3:
                random = rd.nextInt(getHighTypeLength() - 1);
                setType(3, random);
                break;
            case 4:
                random = rd.nextInt(getHighestTypeLength() - 1);
                setType(4, random);
        }
    }
    void assignTypeValues(String[][] type, int position){
        //[0] = String name; [1] = boolean twohanded; [2] = boolean ranged; [3] = magic(true,false,undecided); [4] = int weight; [5] = double magicmultiplier [6] = double damagemultiplier
        this.type = type[position][0]; //type
        this.weight += Integer.parseInt(type[position][4]); //weight
        if(type[position][1] == "True"){ //twohanded
            this.twohanded = true;
        } else {
            this.twohanded = false;
        }
        if(type[position][2] == "True"){ //ranged
            this.ranged = true;
        } else {
            this.ranged = false;
        }
        if(type[position][3] == "True"){ //magic
            this.ismagical = 1;
        } else if(type[position][3] == "False"){
            this.ismagical = 0;
        } else {
            this.ismagical = 2;
        }
        if(type[position][5] == "False"){ //magicmultiplier
            this.magicmultiplier += 0.0;
        } else {
            this.magicmultiplier += Double.parseDouble(type[position][5]);
        }
        if(type[position][6] == "False"){ //damagemultiplier
            this.damagemultiplier += 0.0;
        } else {
            this.damagemultiplier += Double.parseDouble(type[position][6]);
        }
    }
}
