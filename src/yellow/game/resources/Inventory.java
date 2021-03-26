package yellow.game.resources;

import yellow.game.gui.LayoutPicker;
import yellow.game.resources.objects.items.Head;
import yellow.game.resources.objects.items.Item;
import yellow.game.resources.objects.PlayerCharacter;
import yellow.game.resources.objects.items.Weapon;

public class Inventory {
    public static int thislocation;
    public static int thisslot;
    public static int getThisSlot(){
        return thisslot;
    }
    public static int nextentry;
    public static int entrystartpoint;

    public static String errormessage;

    static int gold = 0;
    static int totalweight = 0;
    String armor;
    String helmet;
    String rArm;
    String lArm;
    String boots;
    String necklace;
    String ring;

    public static int getGold(){ return gold; }
    public static int getTotalWeight(){ return totalweight; }
    public static void setGold(int newgold){ gold = newgold; }
    public static void setTotalWeight(int newweight){ totalweight = newweight; }

    public static Item[] Equipment = new Item[5]; //0 = Lhand; 1 = Rhand; 2 = Head; 3 = Armor; 4 = Feet;
    public static Item[] Supplies = new Item[30];
    public static Item[] Holding = new Item[2]; //0 = Holding; 1 = Working storage (switching slot);

    public static void setNextEntry(int entry){ nextentry = entry; }

    public static void enterInventory(int returnentry, int inventoryentry){
        entrystartpoint = returnentry;
        LayoutPicker.entry = inventoryentry;
    }
    public static void returnToGame(){
        LayoutPicker.entry = entrystartpoint;
    }
    public static int getNextEntry(){ return nextentry; }

    public static String showItemInEquipment(int slot){
        String information = "<font color='GRAY'><none></font>";
        int magicdamordef;
        if(Equipment[slot] != null){
            information = Equipment[slot].getName() + " !level" + Equipment[slot].getLevel();
            if(Equipment[slot].isWeapon()){
                information += " " + Equipment[slot].getDamage() + " ATT ";
                magicdamordef = Equipment[slot].getMagicDamage();
            } else {
                information += " " + Equipment[slot].getDefence() + " DEF ";
                magicdamordef = Equipment[slot].getMagicDefence();
            }
            if(Equipment[slot].isMagical() == 1){
                information += "| " + magicdamordef + " " + Equipment[slot].getMagicType() + " ";
            }
            information += "| " + Equipment[slot].getWeight() + " WGHT ";
            if(Equipment[slot].isTwoHanded() && slot == 1){
                information = "\" TWOHANDED ";
            }
        }
        if(information.length() > 70){
            char[] informationchars = new char[68];
            information.getChars(0, informationchars.length - 1, informationchars, 0);
            String shorten = "";
            for(int i = 0; i < informationchars.length - 1; i++){
                shorten += String.valueOf(informationchars[i]);
            }
            information = shorten += " ...";
        }
        return information;
    }
    public static String showItemInSupplies(int slot){
        String information = "<empty slot>";
        String spaces = " ";
        if(Supplies[slot] != null){
            information = Supplies[slot].getName();
            if(Supplies[slot].isWeapon() || Supplies[slot].isHead()){
                information += " !level" + Supplies[slot].getLevel();
            }
            information += " " + Supplies[slot].getWeight() + " WGHT ";
            if(information.length() > 38){
                String newname = "";
                for(int i = 0; i < 34; i++){
                    newname += String.valueOf(information.charAt(i));
                }
                newname += "...";
                information = newname;
            }
        }
        if(information.length() == 38){
            information += " ";
        } else {
            int iterations;
            if(Supplies[slot] != null){
                iterations = 42; // Because of !level
            } else {
                iterations = 37;
            }
            for(int i = 0; i < iterations - information.length() - 1; i++){
                spaces += " ";
            }
        }
        information += spaces;
        return information;
    }
    public static String convertSlot(){
        String convert = "SLOT ";
        if(thislocation == 1){
            switch(thisslot){
                case 0: convert = "A"; break;
                case 1: convert = "B"; break;
                case 2: convert = "C"; break;
                case 3: convert = "D"; break;
                case 4: convert = "E"; break;
            }
        } else if (thislocation == 2){
            convert = Integer.toString(thisslot + 1);
        } else {
            convert = "LOOT";
        }
        return convert;
    }
    public static String showItemInHand(){
        String information = "";
        if(Holding[0] != null){
            information += "Holding " + convertSlot() + ": " + showItemName();
        } else {
            information += "There is nothing in that slot.";
        }
        return information;
    }
    public static String actionOptions(){
        String options = "";
        switch(LayoutPicker.entry){
            case 9980:
                options += "   [<font color='YELLOW'>EXIT</font>] Exit inventory";
                break;
            case 9981:
                if(Holding[0] != null){
                    options += "   [<font color='YELLOW'>H</font>] Hold item in hand - [<font color='YELLOW'>EXIT</font>] Exit inventory";
                } else {
                    options += "   [<font color='MAGENTA'>*</font>] Any slot - [<font color='YELLOW'>EXIT</font>] Exit inventory";
                } break;
            case 9982: case 9983: case 9984:
                if(Holding[0] != null){
                    options += "   [<font color='MAGENTA'>*</font>] Any slot - [<font color='YELLOW'>DROP</font>] Drop item";
                } break;
        }
        return options;
    }
    public static String showItemName(){
        String information = "";
        if(Holding[0] != null){
            information = Holding[0].getName();
            if(Holding[0].isWeapon() || Holding[0].isHead()){
                information += " !level<font color='WHITE'>" + Holding[0].getLevel() + "</font>";
            }
        } else {
            return "There is nothing in slot " + convertSlot() + ".";
        }
        return information;
    }
    public static String showItemDetails(){
        String information = "";
        if(Holding[0] != null){
            if(Holding[0].isWeapon()){
                information += Holding[0].getDamage() + " ATT";
                if(Holding[0].isMagical() == 1){
                    information += " | " + Holding[0].getMagicDamage() + " " + Holding[0].getMagicType();
                }
                if(Holding[0].isTwoHanded()){
                    information += " | TWOHANDED";
                }
                if(Holding[0].isRanged()){
                    information += " | RANGED";
                }
            } else if(Holding[0].isHead()){
                information += Holding[0].getDefence() + " DEF";
                if(Holding[0].isMagical() == 1){
                    information += " | " + Holding[0].getMagicDefence() + " MGC";
                }
            }
            information += " | " + Holding[0].getWeight() + " WGHT ";
        } else {
            return "";
        }
        return information;
    }
    /////////INVENTORY ACTION
    public static void selectItem(int location, int slot) {
        thislocation = location;
        thisslot = slot;
        if(location == 1){
            if(Equipment[slot] != null) {
                Holding[0] = Equipment[slot];
            } else {
                Holding[0] = null;
            }
        } else if(location == 2){
            if(Supplies[slot] != null) {
                Holding[0] = Supplies[slot];
            } else {
                Holding[0] = null;
            }
        }
    }
    public static void addItem(int location, int slot) {
        boolean ispossible;
        if(location == 1){
            ispossible = canCarryWeight(1, slot);
            ///////WEAPON ITEM
                if(Holding[0].isWeapon() && (slot == 0 || slot == 1)) { //WEAPONS in EQUIPMENT slot 0 or 1
                    if(Holding[0].isTwoHanded()) {
                        equipTwoHandedWeapon(); /////////////////////////////////////////////  RESEARCH WEIGHT WITH TWOHANDED WEAPONS ////////////////////////////////////////////////////// //Place TWOHANDED
                    } else if(Equipment[slot] != null && Equipment[slot].isTwoHanded()){ //Switch ONEHANDED with TWOHANDED in stock
                        if(ispossible){
                            setTotalWeight(getTotalWeight() - Equipment[slot].getWeight());
                            Holding[1] = Equipment[slot];
                            Equipment[0] = null;
                            Equipment[1] = null;
                            Equipment[slot] = Holding[0];
                            Holding[0] = Holding[1];
                            dropItem(3, 1);
                            setNextEntry(9982);
                        } else { tooHeavy(); }
                    } else { //if NOT TWOHANDED
                        if(Equipment[0] == null && Equipment[1] == null){ //Place ONEHANDED
                            if(ispossible){ switchOrPlaceItem(slot, 1, true);
                            } else { tooHeavy(); }
                        } else if(Equipment[slot] != null) { //Switch ONEHANDED
                            if(ispossible){ switchOrPlaceItem(slot, 1, false);
                            } else { tooHeavy(); }
                        } else if(Equipment[slot] == null) {
                            if(slot == 0){
                                switchOrPlaceItem(1, 1, false);
                                Equipment[slot] = Equipment[1];
                                Equipment[1] = null;
                            }
                            else if(slot == 1){
                                switchOrPlaceItem(0,1, false);
                                Equipment[slot] = Equipment[0];
                                Equipment[0] = null;
                            }
                        }
                    }
                    completeSwitchOrPlace(slot, location, ispossible);
                } else if(Holding[0].isWeapon() && (slot != 0 && slot != 1)) { //Trying a non-weapon slot
                    errormessage = "Weapons can only be equipped to left- or right hand.";
                    setNextEntry(9983);
            ///////HEAD ITEM
                } else if(Holding[0].isHead() && slot == 2) {
                    if(Equipment[slot] == null){
                        if(ispossible){ switchOrPlaceItem(slot, 1, true);
                        } else { tooHeavy(); }
                    } else {
                        if(ispossible){ switchOrPlaceItem(slot, 1, false);
                        } else { tooHeavy(); }
                    }
                    completeSwitchOrPlace(slot, location, ispossible);
                } else if(Holding[0].isHead() && slot != 2){
                    errormessage = "Headgear can only be equipped on your head.";
                    setNextEntry(9983);
                }
        } else if(location == 2) {
            ispossible = canCarryWeight(2, slot);
            if (Supplies[slot] == null) { //Place
                if(ispossible){
                    Supplies[slot] = Holding[0];
                    dropItem(3, 0);
                    setNextEntry(9980);
                } else { tooHeavy(); }
            } else { //Switch
                if (ispossible) {
                    switchOrPlaceItem(slot, 2, false);
                } else {
                    tooHeavy();
                }
            }
            completeSwitchOrPlace(slot, location, ispossible);
        }
    }
    public static void completeSwitchOrPlace(int slot, int location, boolean yn){
        if(yn){
            if(location == 1){
                System.out.println("SLOT = " + slot + "\nLOCATION =" + location);
                totalweight += Equipment[slot].getWeight();
                thislocation = location;
                thisslot = slot;
            } else if(location == 2){
                System.out.println("SLOT = " + slot + "\nLOCATION =" + location);
                totalweight += Supplies[slot].getWeight();
                thislocation = location;
                thisslot = slot;
            }

        }
    }
    public static void switchOrPlaceItem(int slot, int location, boolean place){
        if(place){
            Equipment[slot] = Holding[0];
            dropItem(3, 0);
            setNextEntry(9980);
        } else {
            if(location == 1){
                setTotalWeight(getTotalWeight() - Equipment[slot].getWeight());
                Holding[1] = Equipment[slot];  //Set inventory item to working storage
                Equipment[slot] = Holding[0];  //Set inventory item to item in hand
                Holding[0] = Holding[1];      //Pass working storage item to item in hand
                dropItem(3, 1); //Delete item in working storage
                setNextEntry(9982);
            } else if(location == 2){
                setTotalWeight(getTotalWeight() - Supplies[slot].getWeight());
                Holding[1] = Supplies[slot];  //Set inventory item to working storage
                Supplies[slot] = Holding[0];  //Set inventory item to item in hand
                Holding[0] = Holding[1];      //Pass working storage item to item in hand
                dropItem(3, 1); //Delete item in working storage
                setNextEntry(9982);
            }
        }
    }
    public static void tooHeavy(){
        errormessage = "Unable to place item. You cannot carry that much weight! (WEIGHT: " + Holding[0].getWeight() + ")";
        setNextEntry(9983);
        returnToGame();
    }
    public static boolean canCarryWeight(int location, int slot){
        if(location == 1){
            if(Equipment[slot] != null){ //If chosen slot is occupied
                if(PlayerCharacter.getStrength() < (totalweight - Equipment[slot].getWeight() + Holding[0].getWeight())){
                    return false;
                } else { return true; }
            } else { //If chosen slot is free
                if(PlayerCharacter.getStrength() < Holding[0].getWeight() + totalweight){
                    return false;
                } else { return true; }
            }
        } else if(location == 2) {
            if(Supplies[slot] != null) { //if chosen slot is occupied
                if (PlayerCharacter.getStrength() < (totalweight - Supplies[slot].getWeight() + Holding[0].getWeight())) {
                    return false;
                } else { return true; }
            } else { //If chosen slot is free
                if(PlayerCharacter.getStrength() < Holding[0].getWeight() + totalweight){
                    return false;
                } else { return true; }
            }
        } else { return false; }
    }
    public static void equipTwoHandedWeapon(){
        if(Equipment[0] == null && Equipment[1] == null) {
            Equipment[0] = Holding[0];
            Equipment[1] = Holding[0];
            dropItem(3, 0);
            setNextEntry(9980);
        } else if(Equipment[0] == null && Equipment[1] != null){
            Holding[1] = Equipment[1];
            Equipment[0] = Holding[0];
            Equipment[1] = Holding[0];
            Holding[0] = Holding[1];
            dropItem(3, 1);
            setNextEntry(9982);
        } else if(Equipment[0] != null && Equipment[1] == null){
            Holding[1] = Equipment[0];
            Equipment[0] = Holding[0];
            Equipment[1] = Holding[0];
            Holding[0] = Holding[1];
            dropItem(3, 1);
            setNextEntry(9982);
        } else if(Equipment[0] != null && Equipment[1] != null){//////////////////Switch equipment to holding in hand
            if(Equipment[0].isWeapon() && Equipment[0].isTwoHanded()){
                Equipment[0] = Holding[0];
                Holding[0] = Equipment[1];
                Equipment[1] = Equipment[0];
                setNextEntry(9982);
            } else {
                errormessage = "Cannot switch one for two items.";
                setNextEntry(9983);
            }
        }
    }
    public static void dropItem(int location, int slot){
        if(location == 1){
            totalweight -= Equipment[slot].getWeight();
            if(Equipment[slot].isWeapon() && Equipment[slot].isTwoHanded()){
                if(Equipment[slot] == Equipment[slot + 1]){
                    Equipment[slot + 1] = null;
                } else if(Equipment[slot] == Equipment[slot - 1]){
                    Equipment[slot - 1] = null;
                }
            }
            Equipment[slot] = null;
        } else if(location == 2){
            totalweight -= Supplies[slot].getWeight();
            Supplies[slot] = null;
        } else if(location == 3){
            Holding[slot] = null;
        }
    }

    ///////////WEAPONS
    public static void addWeaponToEmptySlot(Weapon x, int returnentry){ //What to do if there is no room in inventory  ???
        if(totalweight + x.getWeight() > PlayerCharacter.getStrength()){
            Holding[0] = x;
            errormessage = "This item is to heavy. Switch it with a different item or drop it. (WEIGHT: " + x.getWeight() + ")";
            enterInventory(returnentry,9983); //Equip item failure
        } else {
            if(x.isTwoHanded()){
                //Twohanded weapon goes to equipment
                if (Equipment[0] == null && Equipment[1] == null) {
                    Equipment[0] = x; Equipment[1] = x;
                } else {
                    //Twohanded weapon goes to supplies
                    for(int i = 0; i < Supplies.length; i++){
                        if(Supplies[i] == null){
                            Supplies[i] = x;
                            break;
                        }
                    }
                }
            } else if(Equipment[0] == null && Equipment[1] == null) {
                //Weapon goes to equipment, left hand
                Equipment[0] = x;
            } else {
                //Weapon goes to supplies
                for(int i = 0; i < Supplies.length; i++){
                    if(Supplies[i] == null){
                        Supplies[i] = x;
                        break;
                    }
                }
            }
            setTotalWeight(totalweight += x.getWeight());
        }
    }

    ///////////HEAD GEAR
    public static void addHeadToEmptySlot(Head x, int returnentry) { //What to do if there is no room in inventory  ???
        if (totalweight + x.getWeight() > PlayerCharacter.getStrength()) {
            Holding[0] = x;
            errormessage = "This item is to heavy. Switch it with a different item or drop it. (WEIGHT: " + x.getWeight() + ")";
            enterInventory(returnentry, 9983); //Equip item failure
        } else {
            if (Equipment[2] == null) {
                Equipment[2] = x;
            } else {
                for (int i = 0; i < Supplies.length; i++) {
                    if (Supplies[i] == null) {
                        Supplies[i] = x;
                        break;
                    }
                }
            }
            setTotalWeight(totalweight += x.getWeight());
        }
    }


    int getWeaponDamage(){
        int index = Equipment.length;
        for(int i = 0; i < Equipment.length; i++){
            if(Equipment[i].isWeapon()){
                index = i;
                break;
            }  }
        if (index < Equipment.length){
            return Equipment[index].getDamage();
        } else { return 0; }
    }

}
