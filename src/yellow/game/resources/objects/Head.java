package yellow.game.resources.objects;

public class Head extends Item {
    @Override public int getDamage() { return 0; }
    @Override public int getMagicDamage() { return 0; }
    @Override public String getMagicType() { return "MGC"; }
    @Override public boolean isTwoHanded() { return false; }
    @Override public boolean isRanged() { return false; }
    @Override public String getAttackName(int ix, boolean layout) { return null; }
    @Override public int getAttackNRGY(int attack) { return 0; }

    @Override public int isMagical() { return this.ismagical; }
    @Override public int getDefence() { return this.defence; }
    @Override public int getMagicDefence() { return this.magicdefence; }
    int defence;
    int magicdefence;
    int ismagical = 0;


    public Head(String name, int level, String material, String type, int weight, int defence, int magicdefence, boolean ismagical) {
        makeHead(true);
        this.level = level;
        this.material = material;
        this.type = type;
        this.weight = weight;
        this.defence = defence;
        this.magicdefence = magicdefence;
        if(ismagical == true){
            this.ismagical = 1;
        }
        setHeadName(name);
    }

    public Head(int level, String name){
        makeHead(true);
        setLevel(level);
        setMaterial(level);
        //MATERIAAL OMZETTEN VOOR "HOODs"
        generateHeadType();
        if(this.ismagical == 2){ //ismagical = undecided
            int decideifmagical = rd.nextInt(100);
            if(decideifmagical <= 70){
                this.ismagical = 0;
            } else {
                this.ismagical = 1;
                setMagicDefence();
            }
        }
        if(getMatClass() == 0){
            convertLowestHeadMaterials();
        }
        setHeadName(name);
        setDefence();
    }

    public void setHeadName(String name){
        if (name == "no" || name == "false" || name == "none" || name == " " || name == ""){
            if(isMagical() == 1){
                this.name = "ENCHANTED " + this.material + " " + this.type;
            } else {
                this.name = this.material + " " + this.type;
            }
        } else {
            setName(name);
        }
    }
    void setDefence(){
        double defence = 0.0;
        switch(this.typeclass){
            case 0:
                defence = this.level * (2.5 + damagemultiplier);
                break;
            case 1:
                defence = this.level * (3.75 + damagemultiplier);
                break;
            case 2:
                defence = this.level * (4.9 + damagemultiplier);
                break;
            case 3:
                defence = this.level * (5.5 + damagemultiplier);
                break;
            case 4:
                defence = this.level * (8 + damagemultiplier);
        }
        this.defencemultiplier = defencemultiplier;
        this.defence = (int)Math.round(defence);
    }
    void setMagicDefence(){
        double magicmultiplier = 5.0;
        if(PlayerCharacter.getClassmode() == "mage" && this.ismagical == 1){
            magicmultiplier += 2.3;
        }
        double magicdefence = 0.0;
        switch(this.typeclass){
            case 0:
                magicdefence = this.level * (2.5 + magicmultiplier);
                break;
            case 1:
                magicdefence = this.level * (3.75 + magicmultiplier);
                break;
            case 2:
                magicdefence = this.level * (4.9 + magicmultiplier);
                break;
            case 3:
                magicdefence = this.level * (5.5 + magicmultiplier);
                break;
            case 4:
                magicdefence = this.level * (8 + magicmultiplier);
        }
        this.magicmultiplier = magicmultiplier;
        this.magicdefence = (int)Math.round(magicdefence);
    }

    public void convertLowestHeadMaterials(){
        if(this.material == "WOODEN"){
            this.material = "WOVEN";
        } else if(this.material == "BONE"){
            this.material = "RAGGED";
        } else if(this.material == "STONE"){
            this.material = "LEATHER";
            this.weight -= 12;
            ///////CHANGE WEIGHT OF MATERIAL!!!
        }
    }

    int getLowestTypeLength(){ return 3; }
    int getLowTypeLength(){ return 3; }
    int getMidTypeLength(){ return 2; }
    int getHighTypeLength(){ return 3; }
    int getHighestTypeLength(){ return 3; }

    void generateHeadType(){
        int numberofattributes = 5;
        //[0] = String name; [1] = magic(true,false,undecided); [2] = int weight; [3] = double magicmultiplier; [4] = double defencemultiplier;

        String[][] lowesttype = new String[getLowestTypeLength()][numberofattributes];
        for(int i = 0; i < getLowestTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                lowesttype[i][j] = "False";
            }
        }
        lowesttype[0][0] = "HOOD";
        lowesttype[0][1] = "Undecided"; //MAYBE magic
        lowesttype[0][2] = "2"; //weight
        lowesttype[0][3] = "1.0"; //magicmultiplier
        lowesttype[1][0] = "HAT";
        lowesttype[1][2] = "1"; //weight
        lowesttype[2][0] = "HEADBAND";
        lowesttype[2][2] = "1"; //weight

        String[][] lowtype = new String[getLowTypeLength()][numberofattributes];
        for(int i = 0; i < getLowTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                if(j == 1){ lowtype[i][j] = "Undecided"; }
                else { lowtype[i][j] = "False"; }
            }
        }
        lowtype[0][0] = "CHAINMAIL HOOD";
        lowtype[0][2] = "4"; //weight
        lowtype[0][3] = "3.0"; //magicmultiplier
        lowtype[1][0] = "CAP";
        lowtype[1][2] = "5"; //weight
        lowtype[1][4] = "1.0"; //defencemultiplier
        lowtype[2][0] = "SKULLCAP";
        lowtype[2][2] = "3"; //weight

        String[][] midtype = new String[getMidTypeLength()][numberofattributes];
        for(int i = 0; i < getMidTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                if(j == 1){ midtype[i][j] = "Undecided"; }
                else { midtype[i][j] = "False"; }
            }
        }
        midtype[0][0] = "HELM";
        midtype[0][2] = "5"; //weight
        midtype[0][4] = "1.0"; //defencemultiplier
        midtype[1][0] = "BASINET";
        midtype[1][2] = "6"; //weight
        midtype[1][4] = "2.0"; //defencemultiplier

        String[][] hightype = new String[getHighTypeLength()][numberofattributes];
        for(int i = 0; i < getHighTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                if(j == 1){ hightype[i][j] = "Undecided"; }
                else { hightype[i][j] = "False"; }
            }
        }
        hightype[0][0] = "SPANGENHELM";
        hightype[0][2] = "8"; //weight
        hightype[0][4] = "5.0"; //defencemultiplier
        hightype[1][0] = "SALLET";
        hightype[1][2] = "7"; //weight
        hightype[1][4] = "3.0"; //defencemultiplier
        hightype[2][0] = "GREAT HELM";
        hightype[2][2] = "7"; //weight
        hightype[2][4] = "3.0"; //defencemultiplier

        String[][] highesttype = new String[getHighestTypeLength()][numberofattributes];
        for(int i = 0; i < getHighestTypeLength(); i++){
            for(int j = 1; j < numberofattributes; j++){
                if(j == 1){ highesttype[i][j] = "Undecided"; }
                else { highesttype[i][j] = "False"; }
            }
        }
        highesttype[0][0] = "BARBUTE";
        highesttype[0][2] = "8"; //weight
        highesttype[0][3] = "2.0"; //magicmultiplier
        highesttype[0][4] = "6.0"; //defencemultiplier
        highesttype[1][0] = "NASAL HELMET";
        highesttype[1][2] = "8"; //weight
        highesttype[1][3] = "3.0"; //magicmultiplier
        highesttype[1][4] = "5.0"; //defencemultiplier
        highesttype[2][0] = "CROWN";
        highesttype[2][1] = "True"; //IS magic
        highesttype[2][2] = "4"; //weight
        highesttype[2][3] = "10.0"; //magicmultiplier

        int position;
        switch(getRandomTypePool()){
            case 0:
                this.typeclass = 0;
                position = rd.nextInt(getLowestTypeLength() - 1);
                assignTypeValues(lowesttype, position);
                break;
            case 1:
                this.typeclass = 1;
                position = rd.nextInt(getLowTypeLength() - 1);
                assignTypeValues(lowtype, position);
                break;
            case 2:
                this.typeclass = 2;
                position = rd.nextInt(getMidTypeLength() - 1);
                assignTypeValues(midtype, position);
                break;
            case 3:
                this.typeclass = 3;
                position = rd.nextInt(getHighTypeLength() - 1);
                assignTypeValues(hightype, position);
                break;
            case 4:
                this.typeclass = 4;
                position = rd.nextInt(getHighestTypeLength() - 1);
                assignTypeValues(highesttype, position);
        }
    }
    void assignTypeValues(String[][] type, int position){
        //[0] = String name; [1] = magic(true,false,undecided); [2] = int weight; [3] = double magicmultiplier; [4] = double defencemultiplier;
        this.type = type[position][0]; //type
        this.weight += Integer.parseInt(type[position][2]); //weight
        if(type[position][1] == "True"){ //magic
            this.ismagical = 1;
        } else if(type[position][3] == "False"){
            this.ismagical = 0;
        } else {
            this.ismagical = 2;
        }
        if(type[position][3] == "False"){ //magicmultiplier
            this.magicmultiplier += 0.0;
        } else {
            this.magicmultiplier += Double.parseDouble(type[position][3]);
        }
        if(type[position][4] == "False"){ //defencemultiplier
            this.defencemultiplier += 0.0;
        } else {
            this.defencemultiplier += Double.parseDouble(type[position][4]);
        }
    }
}
