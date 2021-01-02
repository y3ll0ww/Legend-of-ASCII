package yellow.game.resources.objects;

import yellow.game.gui.AudioPlayer;
import yellow.game.gui.LayoutPicker;
import yellow.game.resources.BattleMode;
import yellow.game.resources.LootBox;
import yellow.game.resources.NPC.Enemy;

import java.util.Random;

public class Map {
    public static String[][][] map = new String[30][20][6];//xyz
    public static int posX = 5; //5
    public static int posY = 11; //16
    //x length = 30; y length = 20
    //0 = True/False discovered; 1 = Name; 2 = Tile 3 = Category (Terrain/Town); 4 = Top/Bottom 5 = OuterL/OuterR
    public static String option1;
    public static String option2;
    public static String option3;
    public static String option4;

    public static int numberofoptions = 0;
    public static char[] possibleoptions = new char[4];

    public static void initiateMap(){
        for(int x = 0; x < 30; x++){ //Give all tiles 'False' property (undiscovered)
            for(int y = 0; y < 20; y++){
                map[x][y][0] = "False";
                map[x][y][2] = "[ ]"; }
        }
        for(int x = 0; x < 30; x++){ //Give upper row 'Top' property
            map[x][0][4] = "Top"; }
        for(int x = 0; x < 30; x++){ //Give lower row 'Bottom' property
            map[x][19][4] = "Bottom"; }
        for(int y = 0; y < 20; y++){ //Give left column 'OuterL' property
            map[0][y][5] = "OuterL"; }
        for (int y = 0; y < 20; y++){ //Give right column 'OuterR' property
            map[29][y][5] = "OuterR"; }

        spawnPlayerOnMap();
        map[posX][posY][1] = "Forest";
        map[posX][posY][3] = "Terrain";
    }

    public static void spawnPlayerOnMap(){
        map[posX][posY][2] = "[Ϙ]";
    }

    public static StringBuilder printMapRow(int y){
        StringBuilder line = new StringBuilder("   ");
        String[] row = new String[30];
        for(int i = 0; i < row.length; i++){
            row[i] = map[i][y][2];
            line.append(row[i]);
        }
        return line;
    }

    public static void movePossibilities(){
        String north = "Go NORTH";
        String south = "Go SOUTH";
        String east = "Go EAST ";
        String west = "Go WEST ";

        if(map[posX][posY][4] == "Top"){
            option1 = "[1] " + south;
            possibleoptions[0] = 'S';
            if(map[posX][posY][5] == "OuterL"){
                option2 = "[2] " + east;
                numberofoptions = 2;                    //SE
                possibleoptions[1] = 'E';
            } else if(map[posX][posY][5] == "OuterR"){
                option2 = "[2] " + west;
                numberofoptions = 2;                    //SW
                possibleoptions[1] = 'W';
            } else{
                option2 = "[2] " + east;
                option3 = "[3] " + west;
                numberofoptions = 3;                    //SEW
                possibleoptions[1] = 'E';
                possibleoptions[2] = 'W';
            }
        } else if(map[posX][posY][4] == "Bottom"){
            option1 = "[1] " + north;
            possibleoptions[0] = 'N';
            if(map[posX][posY][5] == "OuterL"){
                option2 = "[2] " + east;
                numberofoptions = 2;                    //NE
                possibleoptions[1] = 'E';
            } else if(map[posX][posY][5] == "OuterR"){
                option2 = "[2] " + west;
                numberofoptions = 2;                    //NW
                possibleoptions[1] = 'W';
            } else{
                option2 = "[2] " + east;
                option3 = "[3] " + west;
                numberofoptions = 3;                    //NEW
                possibleoptions[1] = 'E';
                possibleoptions[2] = 'W';
            }
        } else {
            option1 = "[1] " + north;
            option2 = "[2] " + south;
            possibleoptions[0] = 'N';
            possibleoptions[1] = 'S';
            if(map[posX][posY][5] == "OuterR"){
                option3 = "[3] " + west;
                numberofoptions = 3;                    //NSW
                possibleoptions[2] = 'W';
            } else if(map[posX][posY][5] == "OuterL"){
                option3 = "[3] " + east;                //NSE
                numberofoptions = 3;
                possibleoptions[2] = 'E';
            } else{
                option3 = "[3] " + east;
                option4 = "[4] " + west;
                numberofoptions = 4;                    //NSEW
                possibleoptions[2] = 'E';
                possibleoptions[3] = 'W';
            }
        }
    }

    public static void moveOnMap(char direction){
        if(PlayerCharacter.getEnergy() < 30){
            displayinformation = "You don't have enough energy to move. You should [R] rest.              ";
        } else {
            //Replace tile on map with terrain
            switch(map[posX][posY][1]){
                case "Heath":
                    map[posX][posY][2] = "[-]";
                    break;
                case "Forest":
                    map[posX][posY][2] = "[\"]";
                    break;
                case "Mountains":
                    map[posX][posY][2] = "[Ѧ]";
                    break;
                case "Swamp":
                    map[posX][posY][2] = "[~]";
                    break;
                case "Town":
                    map[posX][posY][2] = "[ʭ]";
            }
            //Move in a direction
            if(direction == 'N'){
                posY -= 1;
            } else if(direction == 'S'){
                posY += 1;
            } else if(direction == 'E'){
                posX += 1;
            } else if(direction == 'W'){
                posX -= 1;
            }
            //Check of next tile is already discovered
            if(map[posX][posY][0] == "False" && map[posX][posY][3] != "Town"){
                generateTerrain(posX, posY);
            }
            PlayerCharacter.setEnergy(-30);
            setDisplayInformation(direction);
            spawnPlayerOnMap();
            movePossibilities();
        }
    }
    public static void restOnMap(){
        int infopick = 0;
        if(PlayerCharacter.getEnergy() == PlayerCharacter.getMaxEnergy()){
            infopick = 2;
        } else if(PlayerCharacter.getEnergy() + 20 > PlayerCharacter.getMaxEnergy()){
            PlayerCharacter.setEnergy(true);
            infopick = 1;
        } else if(PlayerCharacter.getEnergy() + 20 <= PlayerCharacter.getMaxEnergy()){
            PlayerCharacter.setEnergy(20);
            infopick = 1;
        }
        switch(infopick){
            case 1: setDisplayInformation("You took a rest and generated energy."); break;
            case 2: setDisplayInformation("You're full of energy. Resting is futile."); break;
        }
    }
    public static void decideEvent(boolean resting){
        Random rd = new Random();
        int enemy = 0; //chance of encountering enemy
        int loot = 0; //chance of encountering loot

        if(map[posX][posY][1] == "Heath"){
            enemy = 10; loot = 40; //10-30
        } else if(map[posX][posY][1] == "Forest"){
            enemy = 15; loot = 45; //15-30
        } else if(map[posX][posY][1] == "Mountains"){
            enemy = 25; loot = 55; //25-30
        } else if(map[posX][posY][1] == "Swamp"){
            enemy = 40; loot = 60; //40-20
        }
        if(resting){
            enemy += 10; loot = 0;
        }

        int percentage = rd.nextInt(100) + 1;
        if(PlayerCharacter.getEnergy() >= 30 && !resting //Not resting; enough energy to move
        || PlayerCharacter.getEnergy() != PlayerCharacter.getMaxEnergy() && resting){ //Resting; not max energy
            if(percentage <= enemy){
                Enemy foe = new Enemy(Map.map[posX][posY][1]);
                AudioPlayer.playSound("battlemode.wav", false);
                setDisplayInformation("You've fought of an enemy foe.");
                new BattleMode(PlayerCharacter.getInitiative());
            } else if(percentage <= loot){
                AudioPlayer.playSound("lootbox.wav", false);
                setDisplayInformation("You've found loot.");
                new LootBox();
            }
        }
        if(PlayerCharacter.getEnergy() >= 30 || PlayerCharacter.getEnergy() != PlayerCharacter.getMaxEnergy()){

        }
    }

    public static void generateTerrain(int x, int y){
        Random rd = new Random();
        int get = rd.nextInt(100);
        if(get <= 30){ //30% chance for heath
            map[x][y][1] = "Heath";
        }else if(get <= 70){ //40% chance for forest
            map[x][y][1] = "Forest";
        }else if(get <= 90){ //20% chance for mountains
            map[x][y][1] = "Mountains";
        }else if(get <= 100){ //10% chance for swamp
            map[x][y][1] = "Swamp";
        }
        map[x][y][0] = "True";
        map[x][y][3] = "Terrain";
    }

    public static String getNameofTile(){
        if(map[posX][posY][3] == "Terrain"){
            return "The " + map[posX][posY][1].toUpperCase();
        } else {
            return map[posX][posY][1];
        }
    }

    static String displayinformation;
    public static String getDisplayInformation(){
        return displayinformation;
    }
    public static void setDisplayInformation(String info){
        if(info.length() < 73) {
            int spaces = 72 - info.length();
            for (int i = 0; i < spaces; i++) {
                info += " ";
            }
        }
        displayinformation = info;
    }
    public static void setDisplayInformation(char direction){
        String information = "You've traveled ";
        if (direction == 'X'){
            switch(LayoutPicker.entry){
                case 69: //Escaped from Jarl Oddbjorg (intro scene)
                    information = "You've succesfully escaped by going EAST"; /////////////////////////////////////////
                    break;
                case 9990:
                    information = "You rested. ";
                default:
                    information = "";
            }
        }
        if(map[posX][posY][4] == "Top"){
            information += "to the far NORTH";
            if(map[posX][posY][5] == "OuterL"){
                information += "-WEST";
            } else if(map[posX][posY][5] == "OuterR"){
                information += "-EAST";
            }
        } else if(map[posX][posY][4] == "Bottom"){
            information += "to the far SOUTH";
            if(map[posX][posY][5] == "OuterL"){
                information += "-WEST";
            } else if(map[posX][posY][5] == "OuterR"){
                information += "-EAST";
            }
        } else if(map[posX][posY][5] == "OuterL"){
            information += "to the far WEST";
        } else if(map[posX][posY][5] == "OuterR"){
            information += "to the far EAST";
        } else {
            if(direction == 'N'){
                information += "NORTH";
            } else if(direction == 'S'){
                information += "SOUTH";
            } else if(direction == 'E'){
                information += "EAST";
            } else if(direction == 'W'){
                information += "WEST";
            }
        }
        information += ".";


        if(map[posX][posY][3] == "Terrain"){
            information += " You're in the " + map[posX][posY][1].toUpperCase() + ".";
        }

        if(information.length() < 73) {
            int spaces = 72 - information.length();
            for (int i = 0; i < spaces; i++) {
                information += " ";
            }
        }
        displayinformation = information;
    }
}
