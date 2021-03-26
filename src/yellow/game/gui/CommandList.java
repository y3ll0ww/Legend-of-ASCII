package yellow.game.gui;

import yellow.game.resources.Inventory;
import yellow.game.resources.LootBox;
import yellow.game.resources.NPC.Enemy;
import yellow.game.resources.objects.PlayerCharacter;
import yellow.game.resources.objects.Map;
import yellow.game.resources.BattleMode;
import yellow.game.resources.objects.items.Weapon;

public class CommandList {
    public static void TestEnvironment(String input){
        Weapon A = new Weapon(Integer.valueOf(input), "no");
        System.out.println(A.getName());
        Layouts.Inventory();
        System.out.println("Level: " + A.getLevel());
        System.out.println("Weight: " + A.getWeight());
        System.out.println("Damage: " + A.getDamage());
        System.out.println("Magic Damage: " + A.getMagicDamage());
     //   System.out.println("Damagemultiplier: " + A.getDamageMultiplier() + "*");
     //   System.out.println("Magicmultiplier: " + A.getMagicDamageMultiplier() + "*");
        System.out.println("Matclass: " + A.getMatClass() + "\nTypeclass: " + A.getTypeClass());
        System.out.println("TwoHanded: " + A.isTwoHanded() + "\nRanged: " + A.isRanged());
    }

    public static void pressEnter(String input){
        switch (input){
            case "TEST":
                LayoutPicker.entry = 9999999; break;
            default:
                LayoutPicker.entry++;
                if(LayoutPicker.entry == 1) { //Main menu
                    AudioPlayer.playSound("One8bit.wav", true);
                    //AudioPlayer.adjustVolume(-10.0f);
                }
                LayoutPicker.browseLayout();
        }
    }

    public static void commandFired(String input){
        switch(input){
            case "1":
                if(LayoutPicker.entry == 1){ //Main menu
                    LayoutPicker.entry = 10;
                } LayoutPicker.browseLayout();
                break;
            //tests
            case "123":
                LayoutPicker.entry = 123;
                LayoutPicker.browseLayout();
                break;
            case "TEXTYEAH":
                LayoutPicker.entry = 45;
                LayoutPicker.browseLayout();
                break;
            case "MAP":
                Map.initiateMap();
                LayoutPicker.entry = 999;
                LayoutPicker.browseLayout();
        }
    }
    public static void inventoryActions(String input){
        int next = 9980;

        switch(input){
            case "A":
                if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                    Inventory.selectItem(1, 0);
                    next = 9981;
                } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                    Inventory.addItem(1, 0);
                    next = Inventory.getNextEntry();
                } break;
            case "B":
                if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                    Inventory.selectItem(1, 1);
                    next = 9981;
                } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                    Inventory.addItem(1, 1);
                    next = Inventory.getNextEntry();
                } break;
            case "C":
                if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                    Inventory.selectItem(1, 2);
                    next = 9981;
                } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                    Inventory.addItem(1, 2);
                    next = Inventory.getNextEntry();
                } break;
            case "D":
                if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                    Inventory.selectItem(1, 3);
                    next = 9981;
                } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                    Inventory.addItem(1, 3);
                    next = Inventory.getNextEntry();
                } break;
            case "E":
                if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                    Inventory.selectItem(1, 4);
                    next = 9981;
                } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                    Inventory.addItem(1, 4);
                    next = Inventory.getNextEntry();
                } break;
            case "H": // Hold item in hand
                if(LayoutPicker.entry == 9981){ // Show item details
                    Inventory.dropItem(Inventory.thislocation, Inventory.thisslot);
                    next = 9982;
                } else if(LayoutPicker.entry == 9982){
                    next = 9982;
                } break;
            case "DROP":
                if(LayoutPicker.entry == 9982 || LayoutPicker.entry == 9983){ //Holding item in hand
                    Inventory.dropItem(3, 0);
                    next = 9980;
                } break;
            case "EXIT":
                if(LayoutPicker.entry != 9982 && LayoutPicker.entry != 9983){
                    Inventory.returnToGame();
                    LayoutPicker.browseLayout();
                    return;
                } else {
                    Inventory.errormessage = "You cannot exit while holding an item. Place it in your inventory or drop it first.";
                    next = 9983;
                    System.out.println(Inventory.errormessage);
                    System.out.println(LayoutPicker.entry);
                } break;
            default: //Supply slots
                try {
                    if(Integer.valueOf(input) <= 30){
                        if(LayoutPicker.entry == 9980 || LayoutPicker.entry == 9981){ // Start inventory
                            Inventory.selectItem(2, Integer.valueOf(input) - 1);
                            next = 9981;
                        } else if(LayoutPicker.entry >= 9982 && LayoutPicker.entry <= 9984) { //Holding item in hand
                            Inventory.addItem(2, Integer.valueOf(input) - 1);
                            next = Inventory.getNextEntry();
                        }
                    }
                } catch (NumberFormatException nfe){
                    if(LayoutPicker.entry == 9982){
                        next = 9982;
                    }
                }
                break;
        }
        LayoutPicker.entry = next;
        LayoutPicker.browseLayout();
    }

    public static void createCharacter(String input){
        int next = 10;

        if(LayoutPicker.entry == 10){ //INTRODUCTION
            switch(input){
                case "EXIT":
                    next = 1;
                    break;
                case "GO":
                    next = 11;
            }
        } else if(LayoutPicker.entry == 11){ // Choose GENDER
            switch(input){
                case "1":
                    PlayerCharacter.setGender("male");
                    next = 12;
                    break;
                case "2":
                    PlayerCharacter.setGender("female");
                    next = 12;
                    break;
                case "BACK":
                    goBack(10);
                    next = LayoutPicker.entry;
                    break;
                default:
                    next = 11;
            }
        } else if(LayoutPicker.entry ==12){ //Choose RACE
            switch(input){
                case "1":
                    PlayerCharacter.setRace("human");
                    next = 13;
                    break;
                case "2":
                    PlayerCharacter.setRace("elf");
                    next = 13;
                    break;
                case "3":
                    PlayerCharacter.setRace("orc");
                    next = 13;
                    break;
                case "4":
                    PlayerCharacter.setRace("dwarf");
                    next = 13;
                    break;
                case "BACK":
                    goBack(10);
                    next = LayoutPicker.entry;
                    break;
                default:
                    next = 12;
            }
        } else if(LayoutPicker.entry == 13){ //Choose CLASS
            switch(input){
                case "1":
                    PlayerCharacter.setClassmode("warrior");
                    next = 14;
                    break;
                case "2":
                    PlayerCharacter.setClassmode("ranger");
                    next = 14;
                    break;
                case "3":
                    PlayerCharacter.setClassmode("rogue");
                    next = 14;
                    break;
                case "4":
                    PlayerCharacter.setClassmode("mage");
                    next = 14;
                    break;
                case "BACK":
                    goBack(10);
                    next = LayoutPicker.entry;
                    break;
                default:
                    next = 13;
            }
        } else if(LayoutPicker.entry == 14){ //Choose REGION
            switch(input){
                case "1":
                    if (PlayerCharacter.getRace(0) == "human" || PlayerCharacter.getRace(0) == "elf" || PlayerCharacter.getRace(0) == "dwarf") {
                        PlayerCharacter.setRegion("Ugoris");
                    } else if(PlayerCharacter.getRace(0) == "orc") {
                        PlayerCharacter.setRegion("Ageon");
                    }
                    next = 15;
                    break;
                case "2":
                    if(PlayerCharacter.getRace(0) == "human" || PlayerCharacter.getRace(0) == "dwarf"){
                        PlayerCharacter.setRegion("Ageon");
                    } else if(PlayerCharacter.getRace(0) == "orc"){
                        PlayerCharacter.setRegion("Klaekun");
                    } else if(PlayerCharacter.getRace(0) == "elf"){
                        PlayerCharacter.setRegion("Shiyux");
                    }
                    next = 15;
                    break;
                case "3":
                    if(PlayerCharacter.getRace(0) == "human" || PlayerCharacter.getRace(0) == "dwarf"){
                        PlayerCharacter.setRegion("Yepalos");
                        next = 15;
                    } else {
                        next = 14;
                    }
                    break;
                case "BACK":
                    goBack(10);
                    next = LayoutPicker.entry;
                    break;
                default:
                    next = 14;
            }
        } else if(LayoutPicker.entry == 15 || LayoutPicker.entry == 16){ //Choose NAME
            switch(input){
                case "BACK":
                    if(LayoutPicker.entry == 16){
                        LayoutPicker.entry = 15;
                    }
                    goBack(10);
                    next = LayoutPicker.entry;
                    break;
                default:
                    if(input.length() > 25){
                        next = 16;
                    } else {
                        PlayerCharacter.setName(input);
                        next = 19;
                    }
            }
        } else if(LayoutPicker.entry == 19){ //CONFIRM choices
            switch(input){
                case "GO":
                    PlayerCharacter.initializeCharacterStats();
                    PlayerCharacter.setFather(PlayerCharacter.getRace(0), PlayerCharacter.getRegion(0));
                    System.out.println(PlayerCharacter.getGender(0) + PlayerCharacter.getRace(0) + PlayerCharacter.getClassmode() + PlayerCharacter.getRegion(0));
                    System.out.println("HP: " + PlayerCharacter.getHP() + "\nMP: " + PlayerCharacter.getMP() + "\nEnergy: " + PlayerCharacter.getEnergy() + "\nStrength: " + PlayerCharacter.getStrength() + "\nDefence: " + PlayerCharacter.getDefence() + "\nDexterity: " + PlayerCharacter.getDexterity() + "\nEndurance: " + PlayerCharacter.getEndurance() + "\nMagic: " + PlayerCharacter.getMagic());
                    next = 50; //Going to story introduction
                    AudioPlayer.stopSound();
                    AudioPlayer.playSound("startgame.wav", false);
                    break;
                case "BACK":
                    for (int i = 10; i <= 15; i++) {
                        LayoutPicker.entry = i;
                        LayoutPicker.browseLayout();
                    }
                    next = LayoutPicker.entry;
                    break;
                default:
                    next = 19;
                    break;
            }
        }
        LayoutPicker.entry = next;
        LayoutPicker.browseLayout();
    }

    public static void introScene(String input){
        switch (input) {
            case "1":
                if(LayoutPicker.entry == 65 || LayoutPicker.entry == 66){
                    LayoutPicker.entry = 67;
                } else if(LayoutPicker.entry == 69){
                    AudioPlayer.playSound("battlemode.wav", false);
                    Map.initiateMap();
                    Map.movePossibilities();
                    Map.setDisplayInformation('X');
                    Enemy guard = new Enemy(0, "ODDBJØRG GUARD", 1, 17, 10, 10, 0, 0, 0.3, 1);
                    new BattleMode(0, 9990, Enemy.getName() + " has spotted you and is attacking!", "");
                }
                LayoutPicker.browseLayout();
                break;
            case "2":
                if(LayoutPicker.entry == 65){
                    LayoutPicker.entry = 66;
                    boolean biglog = false;
                    int extraDMG = 0;
                    int extraWGT = 0;
                    if(PlayerCharacter.getRace(0) == "orc"){
                        biglog = true;
                        extraDMG += 10;
                        extraWGT += 5; }
                    if(PlayerCharacter.getClassmode() == "warrior"){
                        extraDMG += 10; }
                    Weapon WoodenStick = new Weapon("no", 1, "WOODEN", "STICK", 5 + extraWGT, 10 + extraDMG, 0, "NONE", biglog, false, false, 0, "STRIKE", null, null);
                    if(PlayerCharacter.getRace(1) == "Orc"){
                        WoodenStick.setName("WOODEN LOG");
                    }
                    AudioPlayer.playSound("cloth1.wav", false);
                    Inventory.addWeaponToEmptySlot(WoodenStick, 65);
                } else if(LayoutPicker.entry == 69){
                    Map.initiateMap();
                    Map.movePossibilities();
                    Map.setDisplayInformation('X');
                    LayoutPicker.entry = 9990;
                }
                LayoutPicker.browseLayout();
        }
    }

    public static void freeRoaming(String input) {
        switch (input) {
            case "1":
                Map.decideEvent(false);
                Map.moveOnMap(Map.possibleoptions[0]);
                break;
            case "2":
                Map.decideEvent(false);
                Map.moveOnMap(Map.possibleoptions[1]);
                break;
            case "3":
                if (Map.numberofoptions > 2) {
                    Map.decideEvent(false);
                    Map.moveOnMap(Map.possibleoptions[2]);
                } break;
            case "4":
                if (Map.numberofoptions > 3) {
                    Map.decideEvent(false);
                    Map.moveOnMap(Map.possibleoptions[3]);
                } break;
            case "M":
                LayoutPicker.entry = 9991;
                break;
            case "I":
                if(LayoutPicker.entry != 9991){
                    Inventory.enterInventory(9990, 9980);
                } break;
            case "R":
                if(LayoutPicker.entry != 9991){
                    Map.restOnMap();
                    Map.decideEvent(true); ///Deze verplaatsen naar de Map (de method)
                } break;
            case "EXIT":
                if(LayoutPicker.entry == 9991){
                    LayoutPicker.entry = 9990;
                } else if(LayoutPicker.entry != 9990) { // Prevention of crash: @ freeraoming going to entry 0 when "EXIT"
                    Inventory.returnToGame();
                }
        }
        LayoutPicker.browseLayout();
    }

    public static void foundLoot(String input){
        switch(input){
            case "O":
                if(LayoutPicker.entry == 9970){
                    LayoutPicker.entry = 9971;
                } break;
            case "T":
                if(LayoutPicker.entry == 9971){
                    LootBox.takeLoot();
                    if(LootBox.isGold()){
                        AudioPlayer.playSound("clothBelt2.wav", false);
                    } else {
                        AudioPlayer.playSound("cloth1.wav", false);
                    }
                } break;
            case "D":
                LootBox.returnToGame();
        }
        LayoutPicker.browseLayout();
    }

    public static void goBack(int firstentry){
        int previous = LayoutPicker.entry - 1;
        for(int i = firstentry; i <= previous; i++){
            LayoutPicker.entry = i;
            LayoutPicker.browseLayout();
        }
    }

    public static void battleMode(String input){
        switch(input){
            case "OK":
                if(LayoutPicker.entry == 9960){
                    if(BattleMode.getPlayerGoesFirst()){
                        LayoutPicker.entry = 9961;
                    } else {
                        LayoutPicker.entry = 9965;
                    }
                }
                break;
            case "1":
            case "2":
            case "3":
            case "4":
                if(LayoutPicker.entry == 9961){
                    if(BattleMode.displayAttack(Integer.parseInt(input) - 1).contains("<...>")){
                        LayoutPicker.entry = 9961;
                    } else {
                        //System.out.println(Integer.parseInt(input) - 1);
                        BattleMode.doDamage(Integer.parseInt(input) - 1);
                        LayoutPicker.entry = 9962;
                    }
                }
                break;
            case "I":
                if(LayoutPicker.entry == 9961) {
                    if(PlayerCharacter.getClassmode() == "rogue"){
                        Inventory.enterInventory(9961, 9980);
                    } else {
                        BattleMode.setDisplayInfo("   You've lost your turn to inventory management.");
                        Inventory.enterInventory(9962, 9980);
                    }
                }
                break;
            case "R":
                if(LayoutPicker.entry == 9961){
                    PlayerCharacter.setEnergy(PlayerCharacter.getEnergy() + 5);
                    BattleMode.setDisplayInfo("   You gathered yourself and regenerated 5 energy points.");
                    LayoutPicker.entry = 9962;
                }
                break;
            case "E":
                if(LayoutPicker.entry == 9960 || LayoutPicker.entry == 9961){
                    if(BattleMode.tryEscape()){
                        Map.setDisplayInformation("You've succesfully escaped the fight.");
                        LayoutPicker.entry = BattleMode.getEnterEntry();
                    } else {
                        BattleMode.setDisplayInfo("   Your attempt to escape failed...");
                        LayoutPicker.entry = 9962;
                    }
                }
                break;
            case "T":
                if(LayoutPicker.entry == 9964){
                    LootBox.takeLoot();
                    if(LootBox.isGold()){
                        AudioPlayer.playSound("clothBelt2.wav", false);
                    } else {
                        AudioPlayer.playSound("cloth1.wav", false);
                    }
                }
            case "DROP":
                if(LayoutPicker.entry == 9964){
                    LayoutPicker.entry = BattleMode.getEnterEntry();
                }
            default:
                if(LayoutPicker.entry == 9962) { // Player has attacked
                    if (BattleMode.enemyDied()) {
                        BattleMode.setDisplayInfo("   + " + BattleMode.addEnemyXP() + " XP");
                        LayoutPicker.entry = 9963;
                    } else {
                        LayoutPicker.entry = 9965;
                    }
                } else if(LayoutPicker.entry == 9963){ // Player killed the enemy
                    BattleMode.generateLoot();
                    if(BattleMode.hasLoot()){
                        LayoutPicker.entry = 9964;
                    } else {
                        LayoutPicker.entry = BattleMode.getEnterEntry(); // -- Going back to Map
                    }
                } else if(LayoutPicker.entry == 9965){ // Enemy is going to attack
                    BattleMode.takeDamage();
                    LayoutPicker.entry = 9966;
                } else if(LayoutPicker.entry == 9966){ // Enemy has attacked
                    // CHECK PLAYERS HEALTH
                    LayoutPicker.entry = 9961;
                }
        }
    }

}
