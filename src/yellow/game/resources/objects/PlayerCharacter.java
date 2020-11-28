package yellow.game.resources.objects;

import java.util.Random;

public class PlayerCharacter {
    //Properties
    static String[] gender = new String[5];
    static String[] race = new String[5];
    static String classmode;
    static String[] region = new String[2];
    static String name;
    static String father;
    public static String getRace(int index) { return PlayerCharacter.race[index]; }
    public static String getClassmode() { return PlayerCharacter.classmode; }
    public static String getRegion(int index) { return PlayerCharacter.region[index]; }
    public static String getGender(int index) { return PlayerCharacter.gender[index]; }
    public static String getName() { return PlayerCharacter.name; }
    public static String getFather() { return PlayerCharacter.father; }

    //Level + Experience
    public static int level = 1;
    public static int XP = 0;
    public static int getLevel(){ return level; }
    public static int getXP(){ return XP; }
    public static void setLevel(){ level++; }
    public static void setXP(int add){ XP += add; }


    public static void setGender(String gender){
        PlayerCharacter.gender[0] = gender;
        if(gender == "male"){
            PlayerCharacter.gender[1] = "he";
            PlayerCharacter.gender[2] = "him";
            PlayerCharacter.gender[3] = "his";
            PlayerCharacter.gender[4] = "son";
        } else if(gender == "female"){
            PlayerCharacter.gender[1] = "she";
            PlayerCharacter.gender[2] = "her";
            PlayerCharacter.gender[3] = "hers";
            PlayerCharacter.gender[4] = "daughter";
        }
    }
    public static void setRace(String race){
        PlayerCharacter.race[0] = race;
        if(race == "human"){
            PlayerCharacter.race[1] = "Human";
            PlayerCharacter.race[2] = "human";
            PlayerCharacter.race[3] = "humans";
            PlayerCharacter.race[4] = "a";
        } else if(race == "elf"){
            PlayerCharacter.race[1] = "Elf";
            PlayerCharacter.race[2] = "elven";
            PlayerCharacter.race[3] = "elves";
            PlayerCharacter.race[4] = "an";
        } else if(race == "orc"){
            PlayerCharacter.race[1] = "Orc";
            PlayerCharacter.race[2] = "orcish";
            PlayerCharacter.race[3] = "orcs";
            PlayerCharacter.race[4] = "an";
        } else if(race == "dwarf"){
            PlayerCharacter.race[1] = "Dwarf";
            PlayerCharacter.race[2] = "dwarven";
            PlayerCharacter.race[3] = "dwarves";
            PlayerCharacter.race[4] = "a";
        }
    }
    public static void setClassmode(String classmode){
        PlayerCharacter.classmode = classmode;
    }

    public static void setRegion(String region){
        PlayerCharacter.region[0] = region;
        if(region == "Ugoris"){
            PlayerCharacter.region[1] = "Northern";
        } else if(region == "Ageon"){
            PlayerCharacter.region[1] = "Western";
        } else if(region == "Yepalos"){
            PlayerCharacter.region[1] = "Central";
        } else if(region == "Shiyux"){
            PlayerCharacter.region[1] = "Eastern";
        } else if(region == "Klaekun"){
            PlayerCharacter.region[1] = "Southern";
        }
    }

    public static void setName(String name){
        PlayerCharacter.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static void setFather(String race, String region){
        Random rd = new Random();
        int picker = rd.nextInt(3);
        String[] fathers = new String[4];

        switch(race){
            case "human":
                if(region == "Ugoris"){ //Northern
                    fathers[0] = "Rakhum Mustem";
                    fathers[1] = "Bhahled Mimir";
                    fathers[2] = "Tursterk Venzuhr";
                    fathers[3] = "Uldidd Ostilbe";
                } else if(region == "Ageon"){ //Western
                    fathers[0] = "Dendun Eagleheart";
                    fathers[1] = "Lor Smartsrider";
                    fathers[2] = "Godrorth Dirgebelly";
                    fathers[3] = "Strom Stoneshard";
                } else if(region == "Yepalos"){ //Central
                    fathers[0] = "Groruerez Riziser";
                    fathers[1] = "Grasces Medrasqu";
                    fathers[2] = "Tirvuentuz Rulduzas";
                    fathers[3] = "Partiz Zurgundir";
                }
                break;
            case "elf":
                if(region == "Ugoris"){ //Northern
                    fathers[0] = "Daegolor";
                    fathers[1] = "Glynmyar";
                    fathers[2] = "Fenpetor";
                    fathers[3] = "Norren";
                } else if(region == "Shiyux"){ //Eastern
                    fathers[0] = "Qinelis";
                    fathers[1] = "Yinpeiros";
                    fathers[2] = "Qinjor";
                    fathers[3] = "Aexidor";
                }
                break;
            case "orc":
                if(region == "Ageon"){ //Western
                    fathers[0] = "Bordud the Prime";
                    fathers[1] = "Ghakral Scal Scalper";
                    fathers[2] = "Lokzan the Dark";
                    fathers[3] = "Brovag Hell Carver";
                } else if(region == "Klaekun"){ //Southern
                    fathers[0] = "Zonzab the Brutal";
                    fathers[1] = "Ghad Fang Mutilator";
                    fathers[2] = "Nubzoll the Cruel";
                    fathers[3] = "Nob the Barbarian";
                }
                break;
            case "dwarf":
                if(region == "Ugoris"){ //Northern
                    fathers[0] = "Hjolgrom";
                    fathers[1] = "Bhaldrak";
                    fathers[2] = "Admar";
                    fathers[3] = "Baerman";
                } else if(region == "Ageon"){ //Western
                    fathers[0] = "Berrom";
                    fathers[1] = "Bundren";
                    fathers[2] = "Gerdus";
                    fathers[3] = "Brandahr";
                } else if(region == "Yepalos"){ //Central
                    fathers[0] = "Addrum";
                    fathers[1] = "Thykom";
                    fathers[2] = "Grythrun";
                    fathers[3] = "Gralmond";
                }
        }
        PlayerCharacter.father = fathers[picker];
    }


    //Stats
    static int HP;
    static int maxHP = 100;
    static int MP;
    static int maxMP = 100;
    static int energy;
    static int maxenergy = 100;
    static int strength = 40;
    static int defence = 40;
    static int dexterity = 40;
    static int endurance = 40;
    static int magic = 40;

    public static int getHP(){ return HP; }
    public static int getMaxHP() { return maxHP; }
    public static int getMP(){ return MP; }
    public static int getMaxMP(){ return maxMP; }
    public static int getEnergy(){ return energy; }
    public static int getMaxEnergy(){ return maxenergy; }
    public static int getStrength(){ return strength; }
    public static int getDefence(){ return defence; }
    public static int getDexterity(){ return dexterity; }
    public static int getEndurance(){ return endurance; }
    public static int getMagic(){ return magic; }

    public static void setEnergy(int change){
        int newenergy;
        if(energy + change > maxenergy){
            newenergy = maxenergy;
        } else if(energy + change < 0) {
            newenergy = 0;
        } else {
            newenergy = energy + change;
        }
        energy = newenergy;
    }
    public static void setEnergy(boolean max){
        energy = getMaxEnergy();
    }

    public static void initializeCharacterStats(){
        switch(gender[0]){
            case "male":
                strength += 10; dexterity -= 10;
                break;
            case "female":
                strength -= 10; dexterity += 10;
        }
        switch(race[0]){
            case "human":
                break;
            case "elf":
                dexterity += 10; magic += 10; endurance += 10;
                strength -= 10; defence -= 10;
                break;
            case "orc":
                strength += 10; defence += 10;
                dexterity -= 10; magic -= 10; endurance -= 10;
                break;
            case "dwarf":
                dexterity += 10; strength += 10;
                defence -= 10; magic -= 10; endurance -= 10;
        }
        switch(classmode){
            case "warrior":
                maxHP += 10; strength += 10; defence += 10;
                maxMP -= 10; magic -= 10; endurance -= 10;
                break;
            case "ranger":
                strength += 10; dexterity += 20; endurance += 10;
                defence -= 20;
                break;
            case "rogue":
                defence += 10; dexterity += 20; endurance += 10;
                strength -= 10; magic -= 10;
                break;
            case "mage":
                maxMP += 10; magic += 20; endurance -= 10;
                maxHP -= 10; strength -= 10;
        }
        switch(region[1]){
            case "Northern":
                defence += 10;
                break;
            case "Western":
                dexterity += 10;
                break;
            case "Central":
                dexterity += 5; magic += 5;
                break;
            case "Eastern":
                magic += 10;
                break;
            case "Southern":
                strength += 10;
        }
        HP = maxHP;
        MP = maxMP;
        maxenergy += endurance;
        energy = maxenergy;
    }

}
