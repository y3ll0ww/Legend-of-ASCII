package yellow.game.resources.objects.items.weapons;

import yellow.game.resources.objects.PlayerCharacter;
import yellow.game.resources.objects.items.Attack;
import yellow.game.resources.objects.items.Item;

import java.util.Arrays;

public class Weapon extends Item {
    Weapon nullweapon = null;
    Attack attacks = null;
    boolean twohanded;
    boolean ranged;
    int ismagical; // 0 = false; 1 = true; 2 = undecided;

    int damage;
    int magicdamage;

    public int getWeight() { return this.weight; }
    public int getDamage() { return this.damage; }
    public int getMagicDamage() { return this.magicdamage; }
    public String getMagicType() { return this.magictype; }
    public boolean isTwoHanded() { return this.twohanded; }
    public boolean isRanged() { return this.ranged; }

    @Override public Attack getAttacks(){ return attacks; };
    @Override public String getAttackName(int ix, boolean layout) {
        return attacks.getAttack(ix, layout);
    }
    public int getAttackNRGY(int attack) { return attacks.getNRGY(attack); }

    public int isMagical() { return this.ismagical; } // 0 = false; 1 = true;

    @Override public int getDefence() { return 0; }
    @Override public int getMagicDefence() { return 0; }
    public Weapon(){}
    public Weapon(String name, int level, String material, String type, int weight, int damage, int magicdamage, String magictype, boolean twohanded, boolean ranged, boolean ismagical, int attstat, String attfirst, String attsecond, String attthird) {
        makeWeapon(true);
        setLevel(level);
        this.material = material;
        this.type = type;
        this.weight = weight;
        this.damage = damage;
        this.magicdamage = magicdamage;
        this.magictype = magictype;
        this.twohanded = twohanded;
        this.ranged = ranged;
        if(ismagical == true){
            this.ismagical = 1; // is magical
        } else {
            this.ismagical = 0; // is not magical
        }
        this.attacks = new Attack(attstat, attfirst, attsecond, attthird);
        setWeaponName(name);
    }
    //Get random weapon based on level
    public Weapon(int level, String name){
        makeWeapon(true);
        setLevel(level);
        setMaterial(level);
        createWeapon();
        //nullweapon = createWeapon();
        //nullweapon = null;
        if(this.ismagical == 2){ //ismagical = undecided
            int decideifmagical = rd.nextInt(100);
            if(decideifmagical <= 70){
                this.ismagical = 0;
            } else { this.ismagical = 1; }
        }
        if(this.ismagical == 1){ //ismagical = true
            setMagicType(rd.nextInt(getMagicTypeLength() - 1));
        }
        //this.attacks = nullweapon.attacks;
        setWeaponName(name);
        setDamage();
        setMagicDamage();
    }

    void createWeapon(){
        String[] pool;
        String choice;
        typeclass = getRandomTypePool();
        if(typeclass == 0){
            pool = new String[] { "1 SHORT SWORD", "3 DAGGER", "5 CLUB", "7 SLING", "4 SPEAR", "6 ROD" }; //, "STICK" };
        } else if(typeclass == 1){
            pool = new String[] { "1 LONG SWORD", "2 KATANA", "3 KNIFE", "5 LIGHT HAMMER", "5 LIGHT MACE", "7 LONG BOW", "7 RECURVED BOW", "5 HAND AXE", "6 WAND" };
        } else if(typeclass == 2){
            pool = new String[] { "1 BROADSWORD", "1 GREATSWORD", "3 RAPIER", "5 GREATAXE", "7 LIGHT CROSSBOW", "5 HEAVY MACE", "6 QUARTERSTAFF" };
        } else if(typeclass == 3){
            pool = new String[] { "2 SCIMITAR", "7 GREAT BOW", "7 WARBOW", "7 HEAVY CROSSBOW", "1 BASTARD SWORD", "2 FALCHION", "5 WARAXE", "5 GREAT MACE", "5 MAUL", "6 STAFF" };
        } else {
            pool = new String[] { "5 GREAT MACE", "5 WARHAMMER", "4 HALBERT", "7 MASTER BOW", "7 ALBALEST", "3 KUKRI", "3 BLACKBLADE", "1 EXCALIBUR", "2 SOULSWORD", "6 GREATSTAFF" };
        }
        choice = pool[rd.nextInt(pool.length - 1)];
        char wtype = choice.charAt(0);

        ismagical = 2; // Undecided
        twohanded = false;
        ranged = false;
        type = "";

        if(Character.isDigit(wtype)){
            for(int i = 2; i < choice.length(); i++){
                type += choice.charAt(i);
            }
            switch(Integer.parseInt(String.valueOf(wtype))){
                case 1:
                    createBigSword(); break;
                case 2:
                    createSword(); break;
                case 3:
                    createStabber(); break;
                case 4:
                    createLargeStabber(); break;
                case 5:
                    createKnocker(); break;
                case 6:
                    createEnchanter(); break;
                case 7:
                    createRanger();
            }
        } else {
            type = choice;
        }
    }

    public void createBigSword(){
        attacks = new Attack(1, "CUT", "CHARGE", "SLICE");
        switch(type){
            case "SHORT SWORD":
                this.weight += 20;
                break;
            case "LONG SWORD":
                this.twohanded = true;
                this.weight += 30;
                break;
            case "BROADSWORD":
            case "BASTARD SWORD":
                this.twohanded = true;
                this.weight += 40;
                break;
            case "GREATSWORD":
                this.twohanded = true;
                this.weight += 50;
                break;
            case "EXCALIBUR":
                this.ismagical = 1;
                this.weight += 70;
                this.magicmultiplier += 0.8;
        }
    }
    public void createSword(){
        attacks = new Attack(2, "CUT", "CHARGE", "SLICE");
        if(PlayerCharacter.getClassmode().toUpperCase() == "ROGUE"){
            attacks.addSpecial("ASSAULT");
        }
        switch(type){
            case "KATANA":
                this.weight += 20;
                break;
            case "SCIMITAR":
            case "FALCHION":
                this.weight += 30;
                break;
            case "SOULSWORD":
                this.ismagical = 1;
                this.weight += 70;
                this.magicmultiplier += 0.8;
        }
    }
    public void createStabber(){
        attacks = new Attack(2, "POKE", "STAB", "THRUST");
        if(PlayerCharacter.getClassmode().toUpperCase() == "ROGUE"){
            attacks.addSpecial("PIERCE");
        }
        switch(type){
            case "DAGGER":
            case "KNIFE":
                this.weight += 10;
                break;
            case "RAPIER":
                this.weight += 30;
                break;
            case "KUKRI":
                this.weight += 40;
                break;
            case "BLACKBLADE":
                this.weight += 50;
                this.magicmultiplier += 0.8;
        }
    }
    public void createLargeStabber(){
        attacks = new Attack(1, "POKE", "STAB", "THRUST");
        if(PlayerCharacter.getClassmode().toUpperCase() == "WARRIOR"){
            attacks.addSpecial("PLOW");
        }
        switch(type){
            case "SPEAR":
                this.twohanded = true;
                this.weight += 20;
                break;
            case "HALBERT":
                this.twohanded = true;
                this.weight += 60;
        }
    }
    public void createKnocker(){
        attacks = new Attack(1, "STRIKE", "BEAT", "SMITE");
        if(PlayerCharacter.getClassmode().toUpperCase() == "WARRIOR"){
            attacks.addSpecial("CRUSH");
        }
        switch(type){
            case "CLUB":
            case "LIGHT HAMMER":
                this.weight += 20;
                break;
            case "LIGHT MACE":
            case "HAND AXE":
                this.weight += 30;
                break;
            case "GREATAXE":
            case "HEAVY MACE":
                this.twohanded = true;
                this.weight += 40;
                break;
            case "WARAXE":
            case "GREAT MACE":
            case "MAUL":
                this.twohanded = true;
                this.weight += 50;
                break;
            case "WARHAMMER":
                this.twohanded = true;
                this.weight += 80;
        }
    }
    public void createEnchanter(){
        attacks = new Attack(3, "xxx", "yyy", "zzz");
        if(PlayerCharacter.getClassmode().toUpperCase() == "MAGE"){
            attacks.addSpecial("www");
        }
        switch(type){
            case "ROD":
            case "WAND":
                this.weight += 10;
                break;
            case "QUARTERSTAFF":
                this.twohanded = true;
            case "STAFF":
                this.weight += 20;
                break;
            case "GREATSTAFF":
                this.twohanded = true;
                this.weight += 50;
                this.magicmultiplier += 2.5;
        }
        ismagical = 1;
    }
    public void createRanger(){
        attacks = new Attack(2, "SHOOT", "FIRE", "BLAST");
        if (PlayerCharacter.getClassmode().toUpperCase() == "RANGER") {
            attacks.addSpecial("BOMBARD");
        }
        switch (type) {
            case "SLING":
                this.twohanded = false;
                this.weight += 10;
                break;
            case "LONG BOW":
                this.weight += 20;
                break;
            case "RECURVED BOW":
            case "GREAT BOW":
                this.weight += 30;
                break;
            case "LIGHT CROSSBOW":
            case "WARBOW":
                this.weight += 40;
                break;
            case "HEAVY CROSSBOW":
                this.weight += 50;
                break;
            case "MASTER BOW":
                this.weight += 60;
        }
        this.twohanded = true;
        this.ranged = true;
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
        this.damagemultiplier += damagemultiplier;
        switch(this.typeclass){
            case 0:
                damage = this.level * (this.damagemultiplier += 2.5);
                break;
            case 1:
                damage = this.level * (this.damagemultiplier += 3.75);
                break;
            case 2:
                damage = this.level * (this.damagemultiplier += 4.9);
                break;
            case 3:
                damage = this.level * (this.damagemultiplier += 5.5);
                break;
            case 4:
                damage = this.level * (this.damagemultiplier += 8);
        }
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
}
