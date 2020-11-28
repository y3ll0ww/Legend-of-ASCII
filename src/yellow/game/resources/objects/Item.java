package yellow.game.resources.objects;

public abstract class Item {
    String name;
    int level;

    static String material;
    int matclass;
    static int weight;
    static double magicmultiplier;
    static double damagemultiplier;
    String type;
    int typeclass;

    boolean weapon;
    boolean shield;
    boolean head;
    boolean armor;
    boolean feet;
    boolean slotOccupied = true;

    void makeWeapon(boolean set){ this.weapon = set; }
    void makeShield(boolean set){ this.shield = set; }
    void makeHead(boolean set){ this.head = set; }
    void makeArmor(boolean set){ this.armor = set; }
    void makeFeet(boolean set){ this.feet = set; }

    public boolean isWeapon(){ return this.weapon; }
    boolean isShield(){ return this.shield; }
    boolean isHead(){ return this.head; }
    boolean isArmor(){ return this.armor; }
    boolean isFeet(){ return this.feet; }

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
    public static void setMaterial(String mat){ material = mat; }
    public static void setWeight(int weight){ weight = weight; }
    public static void setMagicMultiplier(double percentage){ magicmultiplier = percentage; }
    public static void setDamageMultiplier(double percentage){ damagemultiplier = percentage; }
    public static int getWeight(){ return weight; }
    public static double getMagicMultiplier(){ return magicmultiplier; }
    public static double getDamageMultiplier(){ return damagemultiplier; }

    static void assignMaterialValues(String[][] material, int position){
        //[0] = matname; [1] = weight; [2] = magicmultiplier; [3] = damagemultiplier
        setMaterial(material[position][0]);
        setWeight(getWeight() + Integer.parseInt(material[position][1]));
        setMagicMultiplier(getMagicMultiplier() + Double.parseDouble(material[position][2]));
        setDamageMultiplier(getDamageMultiplier() + Double.parseDouble(material[position][3]));
    }

    /////////// WEAPONS
    public abstract String getName();
    public abstract int getLevel();

    public abstract int getDamage();
    public abstract int getMagicDamage();
    public abstract String getMagicType();
    public abstract int getMatClass();
    public abstract int getTypeClass();
    public abstract boolean isTwoHanded();
    public abstract boolean isRanged();
    public abstract int isMagical();


    /////////// OTHERS
    public abstract int getDefence();
    public abstract int getMagicDefence();
}
