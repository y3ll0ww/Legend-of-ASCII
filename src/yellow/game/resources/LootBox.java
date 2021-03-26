package yellow.game.resources;

import yellow.game.gui.LayoutPicker;
import yellow.game.resources.objects.items.Head;
import yellow.game.resources.objects.items.Item;
import yellow.game.resources.objects.PlayerCharacter;
import yellow.game.resources.objects.items.Weapon;

import java.util.Random;

public class LootBox {
    static String lootname;
    static int returnentry;

    static Item itemslot;
    static Weapon weaponslot;
    static Head headslot;
    static int goldslot;

    public static String getLootName(){ return lootname; }
    public static void setLootName(String name){ lootname = name; }
    public static int getReturnEntry(){ return returnentry; }
    public static void setReturnEntry(int entry){ returnentry = entry; }
    public static void setGoldSlot(int amount){ goldslot = 0; goldslot += amount; }

    public LootBox(){
        setReturnEntry(LayoutPicker.entry);
        generateLoot();
        LayoutPicker.entry = 9970;
    }
    public LootBox(boolean battlemode){
        setReturnEntry(9990);
        generateLoot();
    }
    static void generateLoot(){
        Random rd = new Random();
        int loot = rd.nextInt(3); // 0: Gold; 1: Weapon; 2: Head; 3: Shield; 4: Armor; 5: Feet;
        int bound;

        switch(loot){
            case 0: //loot = GOLD
                if(PlayerCharacter.getLevel() < 5){
                    bound = 20;
                } else if(PlayerCharacter.getLevel() < 10){
                    bound = 100;
                } else if(PlayerCharacter.getLevel() < 15){
                    bound = 500;
                } else if(PlayerCharacter.getLevel() < 20) {
                    bound = 1000;
                } else {
                    bound = 5000;
                }
                int amount = rd.nextInt(bound);
                int multiplier = rd.nextInt(3); //0: none; 1: + level; 2: * level tens
                if(multiplier == 1){
                    amount += PlayerCharacter.getLevel();
                } else if(multiplier == 2){
                    amount *= PlayerCharacter.getLevel();
                }
                holdLoot(amount + 1);
                setLootName(getGoldSlot()  + " GOLD");
                break;
            case 1: //loot = WEAPON
                //Dit moet naar assign methode en het wapen in de working storage array
                Weapon weaponFound = new Weapon(equipablesAddition(), "");
                holdLoot(weaponFound);
                setLootName(weaponFound.getName() + " !level<font color='WHITE'>" + weaponFound.getLevel() + "</font>");
                break;
            case 2: //loot = HEAD
                Head headFound = new Head(equipablesAddition(), "");
                holdLoot(headFound);
                setLootName(headFound.getName() + " !level<font color='WHITE'>" + headFound.getLevel() + "</font>");
        }
    }

    static int equipablesAddition(){
        Random rd = new Random();
        int addition;
        if(PlayerCharacter.getLevel() < 5){
            addition = rd.nextInt(5);
        } else if(PlayerCharacter.getLevel() < 10){
            addition = rd.nextInt(10);
        } else if(PlayerCharacter.getLevel() < 20){
            addition = rd.nextInt(20);
        } else {
            addition = rd.nextInt(30);
        }
        return rd.nextInt(PlayerCharacter.getLevel() + addition) + 1;
    }

    static void initializeSlots(){
        setGoldSlot(0);
        setItemSlot(null);
        setWeaponSlot(null);
        setHeadSlot(null);
    }
    static void holdLoot(int gold){ initializeSlots(); setGoldSlot(gold); }
    static void holdLoot(Weapon weapon){ initializeSlots(); setWeaponSlot(weapon); }
    static void holdLoot(Head head) { initializeSlots(); setHeadSlot(head);}
    static void holdLoot(Item item){ initializeSlots(); setItemSlot(item); }

    public static int getGoldSlot(){ return goldslot; }
    public static void setWeaponSlot(Weapon weapon){ weaponslot = weapon; }
    public static Weapon getWeaponSlot(){ return weaponslot; }
    public static void setHeadSlot(Head head){ headslot = head; }
    public static Head getHeadSlot(){ return headslot; }
    public static void setItemSlot(Item item){ itemslot = item; }
    public static Item getItemSlot(){ return itemslot; }

    static public boolean isGold(){ if(getGoldSlot() != 0){ return true; } else {return false;} }
    static public boolean isWeapon(){ if(getWeaponSlot() != null){ return true;} else { return false; } }
    static public boolean isHead(){ if(getHeadSlot() != null ){ return true;} else { return false; } }
    static public boolean isItem(){ if(getItemSlot() != null){ return true;} else { return false; } }

    public static void takeLoot(){
        if(isGold()){
            Inventory.setGold(Inventory.getGold() + getGoldSlot());
            returnToGame();
        } else if(isItem()){
            /////////////////////////////////////
            returnToGame();
        } else if(isWeapon()){
            if(PlayerCharacter.getStrength() < Inventory.getTotalWeight() + getWeaponSlot().getWeight()){
                Inventory.addWeaponToEmptySlot(getWeaponSlot(), returnentry);
            } else {
                Inventory.addWeaponToEmptySlot(getWeaponSlot(), returnentry);
                returnToGame();
            }
        } else if(isHead()){
            if(PlayerCharacter.getStrength() < Inventory.getTotalWeight() + getHeadSlot().getWeight()){
                Inventory.addHeadToEmptySlot(getHeadSlot(), returnentry);
            } else {
                Inventory.addHeadToEmptySlot(getHeadSlot(), returnentry);
                returnToGame();
            }
        }
    }

    public static void returnToGame(){
        LayoutPicker.entry = returnentry; System.out.println("returnToGame: returnentry = " + returnentry);
    }///////////////////////////////
}
