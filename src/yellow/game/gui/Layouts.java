package yellow.game.gui;

import static yellow.game.gui.ScreenDrawer.*;
import static yellow.game.resources.objects.Map.*;

import yellow.game.resources.Inventory;
import yellow.game.resources.LootBox;
import yellow.game.resources.objects.PlayerCharacter;
import yellow.game.resources.objects.Map;

public class Layouts {

    public static void nameHPMPEnergy(int line){
        StringBuilder addspaces = new StringBuilder("");
        String[] spaces = new String[29 - PlayerCharacter.getName().length()];

        for(int i = 0; i < spaces.length; i++){
            spaces[i] = " ";
            addspaces.append(spaces[i]);
        }
        String statspaces = defineSpacesForInteger(PlayerCharacter.getHP()) + defineSpacesForInteger(PlayerCharacter.getMaxHP()) +
                defineSpacesForInteger(PlayerCharacter.getMP()) + defineSpacesForInteger(PlayerCharacter.getMaxMP()) +
                defineSpacesForInteger(PlayerCharacter.getEnergy()) + defineSpacesForInteger(PlayerCharacter.getMaxEnergy());

        drawString(line, "   " + PlayerCharacter.getName() + addspaces + statspaces + "HP: " + PlayerCharacter.getHP() +
                "/" + PlayerCharacter.getMaxHP() + "   MP: " + PlayerCharacter.getMP() + "/" + PlayerCharacter.getMaxMP() +
                "   Energy: " + PlayerCharacter.getEnergy() + "/" + PlayerCharacter.getMaxEnergy());
    }

    public static String defineSpacesForInteger(int value){
        if(value < 10){
            return "     ";
        } else if(value < 100){
            return "    ";
        } else if(value < 1000){
            return "   ";
        } else if(value < 10000){
            return "  ";
        } else if(value < 100000){
            return " ";
        } else {
            return "";
        }
    }

    public static void titleScreen() {
        drawString(6, "                  _____                                        __              ___");
        drawString(7, "                 |_   _|                                      |  ]           .' ..]");
        drawString(8, "                   | |      .---.  .--./) .---.  _ .--.   .--.| |    .--.   _| |_");
        drawString(9, "                   | |   _ / /__\\\\/ /'`\\;/ /__\\\\[ `.-. |/ /'`\\' |  / .'`\\ \\'-| |-'");
        drawString(10, "                  _| |__/ || \\__.,\\ \\._//| \\__., | | | || \\__/  |  | \\__. |  | |");
        drawString(11, "                 |________| '.__.'.',__`  '.__.'[___||__]'.__.;__] =\\\\\\\\.'  [___]. .");
        drawString(12, "        ///~`     |\\\\_       _   ( ( __))__     ______  _____  ____,_)  \\      _/_/|");
        drawString(13, "       ,  |='  ,))\\_| ~-_   / \\    .' ____ \\  .' ___  ||_   _||_   _~~~\\-~-_ /~ (_/\\");
        drawString(14, "      / ,' ,;((((((    ~ \\ / _ \\   | (___ \\_|/ .'   \\_|  | |    | |     \\_  /'  D   |");
        drawString(15, "    /' -~/~)))))))'\\_   _/' ___ \\   _.____`. | |         | |    | |       ~-;  /    \\--_");
        drawString(16, "   (       (((((( ~-/ ~- / /   \\ \\_| \\____) |\\ `.___.'\\ _| |_  _| |_        `~~\\_    \\   )");
        drawString(17, "    ~~--|   ))''    ') |____| |____|\\______.' `.____ .'|_____||_____|         /~~-     ./");
        drawString(18, "        :        (_  ~\\           ,                                          |    )    )|");
        drawString(19, "         \\        \\_   )--__  /(_/)                             /,_;,   __--(   _/      |");
        drawString(20, "         |_     \\__/~-__    ~~   ,'       CREATED BY            \\-  ((~~    __-~        |");
        drawString(21, "        /' ~~~----|     ~~~~~~~~'       Jelle van Geel           ``~~ ~~~~~~   \\_      /");
        drawString(22, "       (      _-~~-\\                                                           )       )");
        drawString(23, "       \\     /      \\                                                        _-    ,;;(");
        drawString(24, "       ;`~--'        :                github.com/y3ll0ww                   _-~    ,;;;;)");
        drawString(25, "       |    `\\       |     linkedin.com/in/jelle-van-geel-437656120     _-~          _/");
        drawString(26, "       |    /'`\\     ;                                                 /;;;''  ,;;:-~");
        drawString(27, "      /~   /    |    )                                                |;;'   ,''");
        drawString(28, "     |    /     / | /                                                 |   ,;(");
        drawString(29, "     /   /     |  \\\\|                                            .---__\\_    \\,--._______");
        drawString(30, "   _/  /'       \\  \\_)                                          (;;'  ;;;~~~/' `;;|  `;;;\\");
        drawString(31, "  ( )|'         (~-_|                        ;--__               ~~~----__/'    /'_______/");
        drawString(32, "   ) `\\_         |-_;                        ~--_ ~~~;;------------~~~~~ ;;;'_/'");
        drawString(33, "   `----'       (   `~--_                        '~~~-----....___;;;____---~~");
        drawString(34, "                `~~~~~~~~'");
        drawString(38, "                                  Press enter to continue...");
    }

    public static void mainMenu() {
        wipeScreen();
        drawString(2, " Legend of ASCII                                                                     BUILD v1.0");
        drawString(3, "  .--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--.");
        drawString(4, " / .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\");
        drawString(5, " \\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/");
        drawString(6, "  \\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /");
        drawString(7, "  / /\\/ /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /\\/ /\\");
        drawString(8, " / /\\ \\/`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\ \\/\\ \\");
        drawString(9, " \\ \\/\\ \\                                                                                /\\ \\/ /");
        drawString(10, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(11, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(12, " / /\\ \\/           .                  .-.    .  _   *     _   .                         \\ \\/\\ \\");
        drawString(13, " \\ \\/\\ \\                  *          /   \\     ((       _/ \\       *    .               /\\ \\/ /");
        drawString(14, "  \\/ /\\ \\               _    .   .--'\\/\\_ \\     `      /    \\  *    ___                / /\\/ /");
        drawString(15, "  / /\\/ /           *  / \\_    _/ ^      \\/\\'__        /\\/\\  /\\  __/   \\ *             \\ \\/ /\\");
        drawString(16, " / /\\ \\/              /    \\  /    .'   _/  /  \\  *' /    \\/  \\/ .`'\\_/\\   .            \\ \\/\\ \\");
        drawString(17, " \\ \\/\\ \\         .   /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _             /\\ \\/ /");
        drawString(18, "  \\/ /\\ \\           /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\           / /\\/ /");
        drawString(19, "  / /\\/ /         /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\          \\ \\/ /\\");
        drawString(20, " / /\\ \\/         /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.         \\ \\/\\ \\");
        drawString(21, " \\ \\/\\ \\       /        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%        /\\ \\/ /");
        drawString(22, "  \\/ /\\ \\      @&8jgs@@%% @)&@&(88&@.-_=_-=_-=_-=_-=_.8@% &@&&8(8%@%8)(8@%8 8%@)%      / /\\/ /");
        drawString(23, "  / /\\/ /      @88:::&(&8&&8:::::%&`.~-_~~-~~_~-~_~-~~=.'@(&%::::%@8&8)::&#@8::::      \\ \\/ /\\");
        drawString(24, " / /\\ \\/       `::::::8%@@%:::::@%&8:`.=~~-.~~-.~~=..~'8::::::::&@8:::::&8:::::'        \\ \\/\\ \\");
        drawString(25, " \\ \\/\\ \\        `::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::.'         /\\ \\/ /");
        drawString(26, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(27, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(28, " / /\\ \\/                                  [1] New Game                                  \\ \\/\\ \\");
        drawString(29, " \\ \\/\\ \\                                                                                /\\ \\/ /");
        drawString(30, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(31, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(32, " / /\\ \\/                                                                                \\ \\/\\ \\");
        drawString(33, " \\ \\/\\ \\.--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--./\\ \\/ / ");
        drawString(34, "  \\/ /\\/ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ /\\/ /");
        drawString(35, "  / /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\");
        drawString(36, " / /\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\");
        drawString(37, " \\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /");
        drawString(38, "  `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'");
        drawString(39, "Cast your command below:");
    }

    public static void characterCreation() {
        String article = "";
        String adjective = "";

        switch(LayoutPicker.entry) {
            case 10:
                wipeScreen();
                drawACoupleStrings(1, 3, 32, 39, "-8|==========================================================================================|8-");
                drawString(2, "   CHARACTER CREATION");
                drawString(10, "               Welcome, new hero!");
                drawString(12, "               You're about to step into a new world...");
                drawString(13, "               But first, let us create a hero for the story.");
                drawString(15, "               --");
                drawString(17, "               [continue] Go to character creation.");
                drawString(18, "               [exit]     Exit to main menu.");
                drawString(34, "   HINT");
                drawString(35, "   Possible commands are always captured in square brackets. To execute an action, type the");
                drawString(36, "   command and press enter.");
                break;
            case 11:
                drawString(10, "               GENDER");
                drawString(12, "               Let's create your hero.");
                drawString(13, "               First things first, is your hero male or female?");
                drawString(17, "               [1] Male");
                drawString(18, "               [2] Female");
                break;
            case 12:
                drawString(10, "               RACE");
                drawString(12, "               You chose " + PlayerCharacter.getGender(0) + ". Let's pick " + PlayerCharacter.getGender(2) + " a race.");
                drawString(13, "               What race is your character?");
                drawString(17, "               [1] Human");
                drawString(18, "               [2] Elf");
                drawString(19, "               [3] Orc");
                drawString(20, "               [4] Dwarf");
                drawString(35, "   You can always go [back] if you're not happy with your choice.");
                wipeString(36);
                break;
            case 13:
                wipeString(15); wipeString(18);
                drawString(10, "               CLASS");
                drawString(12, "               You've chosen your hero to be " + PlayerCharacter.getRace(4) + " " + PlayerCharacter.getRace(0) + ".");
                drawString(17, "               --");
                drawString(15, "               Now, choose a class.");
                drawString(19, "               [1] Warrior");
                drawString(20, "               [2] Ranger");
                drawString(21, "               [3] Rogue");
                drawString(22, "               [4] Mage");
                drawString(35, "   Keep in mind that all classes come with different perks and attributes.");

                if(PlayerCharacter.getRace(0) == "human"){
                    drawString(13, "               Humans are very well balanced. They are capable of becoming anything.");
                } else if(PlayerCharacter.getRace(0) == "elf"){
                drawString(13, "               Elves are majestic creatures. They harness ancient powers and are very agile.");
                } else if(PlayerCharacter.getRace(0) == "orc"){
                drawString(13, "               Orcs are natural fighters. They choose offence no matter what.");
                } else if(PlayerCharacter.getRace(0) == "dwarf"){
                drawString(13, "               Dwarves are very crafty. They also know how to handle gold.");
                }
                break;
            case 14:
                drawString(10, "               REGION");
                drawString(12, "               This story will be about " + PlayerCharacter.getRace(4) + " " + PlayerCharacter.getRace(2) + " " + PlayerCharacter.getClassmode() + ".");
                drawString(15, "               Where does this " + PlayerCharacter.getClassmode() + " come from?");
                drawString(35, "   The world is inhabited by different beings. No single race is represented all over the");
                drawString(36, "   world, they all have their own territories.");
                if(PlayerCharacter.getClassmode() == "warrior"){
                    drawString(13, "               Warriors are brave and gain strength and defence rather quickly.");
                } else if(PlayerCharacter.getClassmode() == "ranger"){
                    drawString(13, "               Rangers are agile and can survive in harsh environments.");
                } else if(PlayerCharacter.getClassmode() == "rogue"){
                    drawString(13, "               Rogues are clever and swifty. They possess unique abilities.");
                } else if(PlayerCharacter.getClassmode() == "mage"){
                    drawString(13, "               Mages are dedicated practitioners of magic.");
                }
                if(PlayerCharacter.getRace(0) == "human" || PlayerCharacter.getRace(0) == "dwarf"){
                    drawString(19, "               [1] Ugoris (Northern)");
                    drawString(20, "               [2] Ageon (Western)");
                    drawString(21, "               [3] Yepalos (Central)");
                    wipeString(22);
                } else if(PlayerCharacter.getRace(0) == "elf"){
                    drawString(19, "               [1] Ugoris (Northern)");
                    drawString(20, "               [2] Shiyux (Eastern)");
                    wipeMultipleStrings(21, 22, 0);
                } else if(PlayerCharacter.getRace(0) == "orc"){
                    drawString(19, "               [1] Ageon (Western)");
                    drawString(20, "               [2] Klaekun (Southern)");
                    wipeMultipleStrings(21, 22, 0);
                }
                break;
            case 15:
                drawString(10, "               NAME");
                drawString(12, "               Last but not least...");
                drawString(13, "               What may we call your " + PlayerCharacter.getRace(2) + " " + PlayerCharacter.getClassmode() + " from " + PlayerCharacter.getRegion(0) + "?");
                drawString(15, "               Type a name for your character.");
                drawMultipleStrings(16, 31, "");
                drawMultipleStrings(34, 36, "");
                break;
            case 16:
                drawString(35, "   The name of your character can only be 25 characters long.");
                break;
            case 19:
                drawString(10, "               CONFIRM CHOICES");
                drawString(12, "               Name:     " + PlayerCharacter.getName());
                drawString(13, "               Sex:      " + PlayerCharacter.getGender(0).substring(0, 1).toUpperCase() + PlayerCharacter.getGender(0).substring(1));
                drawString(14, "               Race:     " + PlayerCharacter.getRace(1));
                drawString(15, "               Class:    " + PlayerCharacter.getClassmode().substring(0, 1).toUpperCase() + PlayerCharacter.getClassmode().substring(1));
                drawString(16, "               Region:   " + PlayerCharacter.getRegion(0) + " (" + PlayerCharacter.getRegion(1) + ")");
                drawString(18, "               --");
                drawString(20, "               [confirm] Continue with this character");
                drawString(21, "               [back]    Go back");
                drawString(34, "   HINT");
                drawString(35, "   When you confirm your choices, you will not be able to change them.");
                break;
        }
    }

    public static void introStory() {
        switch (LayoutPicker.entry) {
            case 50:
                wipeScreenWithExceptions(1, 3, 32, 34, 39, 0);
                nameHPMPEnergy(2);
                //drawString(2, "   " + Character.getName());
                drawString(6, "                                                        /\\");
                drawString(7, "                                                       /%%\\  /\\");
                drawString(8, "                           ,                          /%%%%\\/%%\\");
                drawString(9, "                          ,~,                /\\       /%%%%/%%%%\\    ,   /\\");
                drawString(10, "                         ,~~~,   /\\         /%%\\  /\\ /%%%%%//\\%%\\/\\ ,~, /%%\\");
                drawString(11, "                   /\\   ,~~~~~, /%%\\   /\\   /%%\\ /%%\\%/\\%/\\/%%\\%/%%\\~~~/%%%%\\");
                drawString(12, "                  /%%\\ /\\~~~~~~/%%%%\\ /%%\\ /%%%%\\/%%\\/%%\\%%\\%%%/%(%%\\~~/%%%%\\");
                drawString(13, "                  /%%\\/%%\\~/\\~~/%%%%\\/%%%%/%%%%%%\\%%/%%%%\\%%\\%%/)%%%\\~/%%%%%%\\");
                drawString(14, "             /\\  /%%%%\\%%%/%%\\/%%%%%%\\%%/\\/%%/\\%%\\%%/\\%%%\\%%\\%%(%%%%%/%%%%%%%%\\");
                drawString(15, "            /%%\\/%%%%%%\\/\\/%%\\/%%%%%%\\%/%%\\%/%%\\%%\\/%%\\_______[_]________%%%%%\\");
                drawString(16, "            %%%%/%%%%%%/%%\\%%/%%%%%%%%\\/%%\\%/%%\\%%/%%%%\\ _-       _-  _- \\%%%%%\\");
                drawString(17, "            %%%/%%%%%%%/%%\\%%/%%/\\%%%%/%%%%\\%%%%\\/%%%%%%\\______-__________\\\"\"\",\"");
                drawString(18, "              /%%%%%%%/%%%%\\/%%/%%\\%%%/%%%%\\%%%%\\/%%%%%%\\__===______====_]   ,~,  _-");
                drawString(19, "            \"\"/%%%%%%/%%%%%%,%%/%%\\%%/%%%%%%\\%%%/%%%%%%%%\\_|_|______|  |_]  ,~~~,");
                drawString(20, "             /%%%%%%%/%%%%%,~,/%%%%\\/%%%%%%%%\\%/%%%%%%%%%%\\_________|- |_] ,~~~~~,");
                drawString(21, "             /%%%%%%/%%%%%,~~~,%%%%\\/%%%%%%%%\\%/%%%%%%%%%%\\___#__#__|__|_],~~~~~~~,");
                drawString(22, "            /%%%%%#%/#%%%,~~~~~,%%%/%%%%%%%%%%/%%%%%%%%%%%%\\\"\"\"\\/\"\"\"/  \\\"  ,~~;~~,");
                drawString(23, "            \"\"\"\"\"\"\"\\/\"\"\",~~~~~~~,\"\"/%%%%%%%%%/%%%%%%%%%%%%%%\\   _-            |");
                drawString(24, "             -_          ,~~;~~,   \"\"\"\"\"\"\"\"\"\"/%%%%%%%%%%%%%%\\       ^^      ~\"\"\"~");
                drawString(25, "                  ^^        |   ,    _-     /%%%%%%%%%%%%#%%#\\        _-");
                drawString(26, "                        _-    ,`|`,         \"\"\"\"\"\"\"\"\"\"\"\"\"\"\\/\"\"   _-          _-");
                drawString(27, "              _-               \\ /           _-         _-   ~~");
                drawString(28, "                              ~\"\"\"~");
                drawString(34, "   For as long as you can remember, this has been your home.");
                drawString(37, "   Press [enter] to continue");
                break;
            case 51:
                wipeString(37);
                if(PlayerCharacter.getRegion(0) == "Ugoris"){
                    drawString(35, "   Although you're from a different part of Ugoris...");
                } else {
                    drawString(35, "   Although Ugoris is not your homeland...");
                }
                break;
            case 52:
                drawString(36, "   You're a servant. A slave to Jarl Oddbjørg. Who took you here when you were but a child.");
                break;
            case 53:
                drawString(37, "   Fortunately, you're not alone.");
                break;
            case 54:
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   Along with the other " + PlayerCharacter.getRace(3) + ", you live in servitude in a secluded village in Ugoris.");
                break;
            case 55:
                drawString(35, "   The elders told you everything you know about the life you were supposed to live.");
                break;
            case 56:
                drawString(36, "   You were destined to be a ruler. To follow in your fathers footsteps and lead your people.");
                break;
            case 57:
                drawString(37, "   However, you've always had the feeling that has never been your destiny.");
                break;
            case 58:
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(35, "   You are " + PlayerCharacter.getName() + ", " + PlayerCharacter.getGender(4) + " of " + PlayerCharacter.getFather() + ".");
                break;
            case 59:
                drawString(36, "   And one day you will avenge your father...");
                break;
            case 60:
                wipeScreenWithExceptions(1, 2, 3, 32, 39, 0);
                break;
            case 61:
                drawString(35, "   \"" + PlayerCharacter.getName() + "! WAKE UP!\"");
                break;
            case 62:
                drawString(16, "                                                        (  .      )");
                drawString(17, "                                                    )           (              )");
                drawString(18, "                                                          .  '   .   '  .  '  .");
                drawString(19, "    ,.   (   .      )        .      \"            (    , )       (.   )  (   ',    )");
                drawString(20, "   (\"     )  )'     ,'        )  . (`     '`      .' ) ( . )    ,  ( ,     )   ( .");
                drawString(21, " .; )  ' (( (\" )    ;(,     ((  (  ;)  \"  )\"   ). , ( .   (  ) ( , ')  .' (  ,    )    .; )  ' (");
                drawString(22, " _\"., ,._'_.,)_(..,( . )_  _' )_') (. _..( '..(_,) . ), ) _) _,')  (, ) '. )  ,. (' ) _\"., ,._'_");
                drawString(23, ".   (  ) ( , ')  .' (  ,    )    .; )  ' ( .; )  ' (( (\" )    ;(,     ((  (  ;)  \"  )\"   ). , (");
                drawString(24, "_\"., ,._'_ _\"., ,._'_.,)_(..,( . )_  _' )_') (. _..( '..(_,) . ), ) _) _,')  (, ) '. )  ,. (' )");
                drawString(36, "   \"THE CABIN IS ON FIRE!\"");
                break;
            case 63:
                wipeMultipleStrings(35, 36, 0);
                drawString(34, "   The servant cabin is on fire. You hear " + PlayerCharacter.getRace(3) + " in panic all around you.");
                break;
            case 64:
                drawString(35, "   This might be your chance to escape...");
                break;
            case 65:
                drawString(36, "   [1] Escape");
                drawString(37, "   [2] Take debris");
                break;
            case 66:
                wipeMultipleStrings(34, 37, 0);
                drawString(35, "   You equipped yourself with a WOODEN STICK.");
                drawString(36, "   [1] Try to escape again");
                break;
            case 67:
                wipeMultipleStrings(35, 36, 37);
                drawString(34, "   You crawl through the window successfully and start running for the forest.");
                break;
            case 68:
                drawString(35, "   Someone sees you. \"HEY YOU! STOP RIGHT THERE!\"");
                break;
            case 69:
                drawString(36, "   [1] Fight");
                drawString(37, "   [2] Flight");
                break;
            case 70:
                break;
        }
    }

    public static void walkingOverMap(){
        wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
        nameHPMPEnergy(2);
        switch(Map.map[posX][posY][1]){
            case "Heath":
                drawString(4, "                 `     `!rvv)~'");
                drawString(5, "              -!,-\"!==>(r:-.-:<=!:`");
                drawString(6, "          ,,,,`                  -x)=:`");
                drawString(7, "        -!}>                         _Kv");
                drawString(8, "       .v}?                           `!?-`````````                 `'...`         `--__---");
                drawString(9, "``````'(v,`                             !?.       `-       .--.`'.......-..```` -'`       `.``'`");
                drawString(10, "      _o`                               ^V.      -_``'''.------``             `.`");
                drawString(11, "  =}vz0~                                :5'      -````''..`");
                drawString(12, " 'd=__`                                  *x:");
                drawString(13, " `6)                                     .;<");
                drawString(14, "  ud\"                                `-!=*)`");
                drawString(15, "  ~#Z:`_-           `            !QZZy}x>_");
                drawString(16, "   !sMZQm.        !)\"*`  `       -TT:`                                                `'````````");
                drawString(17, "       \"xsa}^!-`  ~B:v^ \"!xvr!,_-,Gl...'``'......-....--..'````''...`````` '`  ',:,```'``");
                drawString(18, "=>^)vxv|)vusZ8gdhUzRD,:_:!=LDGZ6MVL(iVVlv^<>^^^:!*!!=<!-_,~v(;!!!::__\":,'    !<^^**!:\"..'.=^~!\"-");
                drawString(19, "!!!!!!;^~:::::!!=;*riO^~x_::,_,=**=_.```    ``_*^__-..\">rxv~\",,\"\",\"~*v}x)r<!)x^:-'```.!<^^~~=!!=");
                drawString(20, "                     U^}U                     -..\"xv=!:_-.....`");
                drawString(21, "                     dTVP                 .|*:.  Kh`  .)^!`");
                drawString(22, "-.'----'`.--_-..,;r)vPsKl~=~^*rr)~>TdEu}T^r!     `vL^:` `\"!,.'_=^!_````");
                drawString(23, "                                   _GEOsy~          `!~==!==~_    '''-____,...   `-`");
                drawString(24, "                                 `x#d-  *l                  `!xVx\"       ``` -\":<wI?^=!!:`");
                drawString(25, "                               _*jDI.   ?$x                      :=!=_           -<:_,,*Ti!,,_,,");
                drawString(26, "                         -rYcKd)^v_     )z\"                          -*v<`               `!!-.,r");
                drawString(27, "                       =H#dQEx`        _P:                             `;ix=`");
                drawString(28, "                     ,35g8Dx`         `wu                                 _vKI)_");
                drawString(29, "        |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
                drawString(30, "        |   " + Map.getDisplayInformation() + "   |");
                drawString(31, "        |                                                                              |");
                break;
            case "Forest":
                drawString(4, "                                                            *j");
                drawString(5, "                                                          cIZd -");
                drawString(6, "                                                         `y@@@$B_");
                drawString(7, "                                                      _:.y@@@@@M}.`");
                drawString(8, "                                                      Lg8#@@@@@##dc`");
                drawString(9, "                                                    `V$B#@@@@@@@@#Qv");
                drawString(10, "                                                      =yD#@@@@@@ZOb-");
                drawString(11, "             `    })                                .vd6Q#@@@#@@@@MI-");
                drawString(12, "           ` B~   B@.                               :dRqg@@@@@@@@@#@@M");
                drawString(13, "          `D~@0` `#@]                                 `}B@@@@@#@@@@$Z}='");
                drawString(14, "          ^@@@@~ x@@@:                               `rT}yHO@@@@@QZ3_!IR}");
                drawString(15, "     <.  `8@@@#_ q@@@u                                    u6QB#@@@@QH=  `");
                drawString(16, "    ~#i  ~@@@@#:;P@@@B-                              :TV$ev)YkQ@@Bgz:   _03u):`");
                drawString(17, "    U@B:`V#B##@#5###@B*        _*                    i88Q6R8@@@@##6MO5dBB#b6$5*");
                drawString(18, "    *9@h xuGOd8Bw@@@QB$=`      x@,                    `V0DZ#8Q@@@@@@@@@#@##@#@Be^");
                drawString(19, ",   ^hQQV _vxlX$G$B#BQE_`    `~^@u`,      :) `     -r;!*|*;yH#@@@gPw@$}KI80r:~EG=");
                drawString(20, "@~ -PEUdg= !r<r*Y}xIq0$x     '$x@0?e      cR 6~   .}O@@@#@@@@@@@@@@B#@#Ox`-!   <z");
                drawString(21, "#G'-xqg3v^```\",:::=vv(yK^`^. x#y##6Q`  `,xQ@)gy^:`.ixwu\"^_)kB@@#B@#V-`-`               -`");
                drawString(22, "#@Q):-,,<`K-    ` `IU}x<!x#I`$@B#@B#:`'*(QO##@u-(g@@@@@@#PGPD@@@@@@@Q>_`               v*");
                drawString(23, "B@@#* ` `M@~^`    _QM:)-YPZ#L8##B@@@D6cQVQoqQQ#) xuu*x}T$@@@@@@@@@@@@@@#BO}Vox|?^`     vd`");
                drawString(24, "c6@@@c`^oEZZ@)    ?@@-   :Bb$OM#g08$aOB8R0DXazRy*r^VB#@@#@@@##@@@@@##@@@@@8PB@@dIL*    xB\"");
                drawString(25, "Yum8#d}kdPyB@#=  `B@@$-  _@y.r~\"xTYzdYTXVMBBB##B##@@@@@@@@@#@@@B#@@@#@@#gEZv*ViL:*v  v:Vd=yv");
                drawString(26, "*^iT)l?xiHM#@@@v *#@@@0  )@c (M,  _,`!=<iTwMQBQ8B####BBQBB###@@@@@#@@@@@b,:`xo`|*oB.!#r}EuQB`");
                drawString(27, ":^-_ -=\\(q#@@@@#`e#@@@@K ]@$,8@X   8K    `.hZ90###B#@@##B#B@#@@@@@@@@@@@#@@#0@6$B6@$g@Q'<H@@?");
                drawString(28, "      !^^*eGQ#@#vIjRBB@@}d@@####y`K@@v .-=<YYP98@@@B#@@@###Q#@#@@@@@@@@@@@@@@@@#88OgRQ@k)$Q@#!");
                drawString(29, "     `rv|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|QMIKOm:");
                drawString(30, "      '!|   " + Map.getDisplayInformation() + "   |!-;3yVyz");
                drawString(31, "        |                                                                              |        -,\"*!");
                break;
            case "Mountains":
                drawString(6, "                                            `)]M`");
                drawString(7, "                                           >w^:QDx'");
                drawString(8, "                                         :y\\::3?R#Q<");
                drawString(9, "                                       .Yv_ '!-,z@@Bw~.");
                drawString(10, "                                     .yM*->-``~xurB#QQB8r`");
                drawString(11, "                          ,`       `*}~-~T- _iv:``G##@@@#dv`");
                drawString(12, "                       'x}O$i)'  'wGu!-T}_`,<`' `'!-}@@@@@#$!");
                drawString(13, "                     'iu=.V#@#qxYG\\>_:~! `-`'` ~~ `=u$@@QB@$BG*");
                drawString(14, "                    !X^.*r!OB##MT-`  .  `. .-`**` r5Y*v@@@@#$QBMY!");
                drawString(15, "                  `xv``,:>rr^kBVr`     \", `v.,,``}k- _Q@@@@B#@@@EBk'`<lV,");
                drawString(16, "                `x5r.._~}^<rrVi-`'```-r,``:``` -v<.`,*E#QQ@@@QGgQQ@gqV?##y~_'`");
                drawString(17, "              'uKi,`',~!,<vw*``'_-``~Y:.=-``_?Y^_'`~x3}!!T}r3Q@djwTx:']####8Mu```");
                drawString(18, "             `j=,`_`.` `!^l*r`.,,  )x~-*>`.=)=''`~^*,-':*,-_H#g}^i!-__LTg@@Q6g}*x=`");
                drawString(19, "           !j8i -`_`  :T}_Y._->-'`*L~:,_.`\"~'. `*^'``,._`-}dMY)!=__:*L':P@@8vM0MgOZx`");
                drawString(20, "       '<Tj#O:'-__''_ir-_!.`::`'*]!--!(!.r~_...',-\":_..=xkr.,,-.^:_,-``xQ(x@#QYDBQB@0\"");
                drawString(21, "    `>*xrTK= ._.'_`:I-!*. '``=^x)`  ^Yv#QQx_'!!`-v:  _LY\"`!\"  :?=` `- *5<`YQ@@BuLqBQ#Br`");
                drawString(22, "  -<}!`<wv`  . ~*'.k\\r=   .~ur-```~r=`=Ed8dROE*xI<,^uL- ,]:`'-y^`  .:)=` :*}@@@Bg<^B@@#Xr'");
                drawString(23, "*(x_`>x^.``   .^ \"G}=    '!'``')T}*  -y\" j@@QRQBEQOx.`!*Y='`-x='  'cL` '!.`0gQ@@@@Q$@@@QG#L:");
                drawString(24, "-  _X*` :!   ` -(i^_      ` `xI*_   ,Y. \"w<M##@@Bv-_\\^'(<. -v\"?_ '^`  .y`>z*VQ@@BL=x#@@@MGBPVrr^");
                drawString(25, "  _T- `-_` !!,,,.` '     `*3E=.`  _^!  _x~` x@@gK:-x, xL`  ^`.` -.  ` -'vP:~x<0j-`_u*QB8@#B#@#IR");
                drawString(26, " _?`   `  `:!='       ':=rMxi`  `-:`' .x.   `Q@#r!:  `}\"  -`   ``   ```Vx-:rVI('``_-TVR#dmZ#@#$K");
                drawString(27, "_:        __`     `-_=, *u` =  ` ' ``-x\"  ``^XcH``  ,(_       .<.   .!*-`<rT_  `^`<y<`-Yg#06$ZH}");
                drawString(28, "`         `     '_-   '*~_  '     `'`}_` `'`*- .^ `!:`        .` `_,\"`'!r-    `_, ^_     ~L-``-\"");
                drawString(29, "        |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|     _");
                drawString(30, "        |   " + Map.getDisplayInformation() + "   |");
                drawString(31, "        |                                                                              |");
                break;
            case "Swamp":
                drawString(4, "                           `\\`         *`*. : .    *.\\     -_.=            L):");
                drawString(5, "                      :^  `Y`          ) )_-! *  \"`(`\\      x--^=!        _T i'");
                drawString(6, "                      (! _y-           `r(.:- ^ :*_^`r       <^. :\\        `r~r==~'");
                drawString(7, "             ^'      `u_*~\"             r`\\`- (`:v_=:^         <* :!          _=!~};=;:");
                drawString(8, "         :` :^*      =^(                T r.)-r :)\"\"<L          =* _*_             T, x`");
                drawString(9, "         i! :Lr_    .^x`                Y *\"^*_ ^='\"-3_          _r- -~*-_` `    .):  x");
                drawString(10, "         Y=`')v\\   :! y                 T !`:v\" ^= \" *(            _\\!  '-:!r;.  yT  !<");
                drawString(11, "         .Y`  k(_ ^-!r:                 m * _v! r, _ r\\              :*^~~\"   :^;T   x");
                drawString(12, "          }   *)x::;`                  ,T 3 '\\`^._ : Rv                   .vr    x   v_");
                drawString(13, "          ;^:  `.,=                   `3\",$ `\\`*=. :!dx                     }r -_    _r");
                drawString(14, "           }!:  `5                    Y='5* ;:.ri( :xyL`                     _^}=`    )");
                drawString(15, "           Yv` * d       \\:^`     _v hy,'B  v`-rY( 'xj'Y                       w`!   _x!");
                drawString(16, "           .yc '(:~      .=*r(     y*Zi Zm rv!H*X^M_viTi-^: -                  y`*   ~;x");
                drawString(17, "            Yv: x T         )^}`  )hMuvv89(^5ii @.Gsr^k`}iv!Q                  `y)   ._i");
                drawString(18, "            Yr\" _(v\"     :L<-:(i\\ vZYY}RhVR<ykv`Zw\\D-vx= uh$*`                 \"yr    :Y");
                drawString(19, "            L='_`x u       :YVT\\YTTQ=v($yTwr(ZLxvduyx()v' BXRwKv<              u~r . -^i");
                drawString(20, "            i`}) ;`\\!     .vLdQsOhx=(M;yR-xry\\s):vTLd*_x-u93}^!:-`            T!:` - <*r");
                drawString(21, "            i`TV  , y     v$9rkMXOm^`vx^ju3y*-dxryrsKZGQ3cyu<:<\\^xr-       ;r(:*  `,`*T");
                drawString(22, "            Y._Ry-  <TYTLLxixv^:~)ujVx\\c\\=~^(vuy}*v*_  *Lr=!!;<^~,      *^^` `x  ._`'=*");
                drawString(23, "           <=i`Xv). *)(         ``` `~-_____,:\"_:!-__,__\"*_            ;( :-=;  `.'- c");
                drawString(24, "          r::r=vHc)  T=L                                              `u (:~`   \"(_=rT");
                drawString(25, "        :r.=* L.Kc)\" Yx<x^                                           !i:_~=   \"_:^<!!h");
                drawString(26, "      _r^x}-.\\~~}vTu`!*;x-*r,                                     .^r^-\"=!`    ~_`L`.y");
                drawString(27, "*==::*y^y\" *\\)r`\\rYkM -x=\\) ;Y::!::!:\",-                       r^v*:!-!^ *    ;`, V:`}:");
                drawString(28, "~\": `T^u' v!<vr`* )TTT  sjvY!_v=-....:)*,                    :u` `x``T^=<)   \"! =`sr,:^\\");
                drawString(29, " -:(m*Y\\|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|c* -r==!!~`");
                drawString(30, "  -::VH:|   " + Map.getDisplayInformation() + "   |sy\\!,::;^");
                drawString(31, "        |                                                                              |_^^~` `'..--_-");
                break;
            case "Town":
                drawString(4, "");
                drawString(5, "");
                drawString(6, "");
                drawString(7, "");
                drawString(8, "");
                drawString(9, "");
                drawString(10, "");
                drawString(11, "");
                drawString(12, "");
                drawString(13, "");
                drawString(14, "");
                drawString(15, "");
                drawString(16, "");
                drawString(17, "");
                drawString(18, "");
                drawString(19, "");
                drawString(20, "");
                drawString(21, "");
                drawString(22, "");
                drawString(23, "");
                drawString(24, "");
                drawString(25, "");
                drawString(26, "");
                drawString(27, "");
                drawString(28, "");
                drawString(29, "");
                drawString(30, "");
                drawString(31, "");
                break;
        }
        drawString(34, "        " + Map.option1 + "             [R] Rest");
        drawString(35, "        " + Map.option2 + "             [M] Map");
        drawString(36, "                                 [S] Stats");
        drawString(37, "                                 [I] Inventory");
        if(Map.numberofoptions == 3){
            drawString(36, "        " + Map.option3 + "             [S] Stats");
        } else if(Map.numberofoptions == 4){
            drawString(36, "        " + Map.option3 + "             [S] Stats");
            drawString(37, "        " + Map.option4 + "             [I] Inventory");
        }
    }

    public static void showMap(){
        wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
        nameHPMPEnergy(2);
        drawString(4, "     N");
        drawString(5, "   W + E                                     MAP OF");
        drawString(6, "     S                                  THE GREAT UGORIS");
        drawString(8, "" + printMapRow(0));
        drawString(9, "" + printMapRow(1));
        drawString(10, "" + printMapRow(2));
        drawString(11, "" + printMapRow(3));
        drawString(12, "" + printMapRow(4));
        drawString(13, "" + printMapRow(5));
        drawString(14, "" + printMapRow(6));
        drawString(15, "" + printMapRow(7));
        drawString(16, "" + printMapRow(8));
        drawString(17, "" + printMapRow(9));
        drawString(18, "" + printMapRow(10));
        drawString(19, "" + printMapRow(11));
        drawString(20, "" + printMapRow(12));
        drawString(21, "" + printMapRow(13));
        drawString(22, "" + printMapRow(14));
        drawString(23, "" + printMapRow(15));
        drawString(24, "" + printMapRow(16));
        drawString(25, "" + printMapRow(17));
        drawString(26, "" + printMapRow(18));
        drawString(27, "" + printMapRow(19));
        drawString(29, "      Ϙ = Player           - = Heath      Ѧ = Mountains   ₮ = Town                        N");
        drawString(30, "      ֎ = Quest            \" = Forest     ~ = Swamp         = Undiscoverd               W + E");
        drawString(31, "                                                                                          S");
        drawString(34, "      Currently in:");
        drawString(35, "      " + Map.getNameofTile());
        drawString(37, "      [EXIT] Exit MAP");
    }

    public static void Inventory(){
                wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
                nameHPMPEnergy(2);
                drawString(5, "   EQUIPMENT                                                                     " + defineSpacesForInteger(Inventory.getGold()) + "GOLD: " + Inventory.getGold());
                drawString(6, "   ---------                                                            " + defineSpacesForInteger(Inventory.getTotalWeight()) + defineSpacesForInteger(PlayerCharacter.getStrength()) + "WEIGHT: " + Inventory.getTotalWeight() + "/" + PlayerCharacter.getStrength());
                drawString(7, "                                                                               Go to [spells]");
                drawString(8, "   [a] Left hand:     " + Inventory.showItemInEquipment(0));
                drawString(9, "   [b] Right Hand:    " + Inventory.showItemInEquipment(1));
                drawString(10, "   [c] Head:          " + Inventory.showItemInEquipment(2));
                drawString(11, "   [d] Armor:         " + Inventory.showItemInEquipment(3));
                drawString(12, "   [e] Feet:          " + Inventory.showItemInEquipment(4));
                drawString(14, "   -----------------------------------------SUPPLIES-----------------------------------------");
                drawString(16, "    [1] " + Inventory.showItemInSupplies(0) + " || [16] " + Inventory.showItemInSupplies(15));
                drawString(17, "    [2] " + Inventory.showItemInSupplies(1) + " || [17] " + Inventory.showItemInSupplies(16));
                drawString(18, "    [3] " + Inventory.showItemInSupplies(2) + " || [18] " + Inventory.showItemInSupplies(17));
                drawString(19, "    [4] " + Inventory.showItemInSupplies(3) + " || [19] " + Inventory.showItemInSupplies(18));
                drawString(20, "    [5] " + Inventory.showItemInSupplies(4) + " || [20] " + Inventory.showItemInSupplies(19));
                drawString(21, "    [6] " + Inventory.showItemInSupplies(5) + " || [21] " + Inventory.showItemInSupplies(20));
                drawString(22, "    [7] " + Inventory.showItemInSupplies(6) + " || [22] " + Inventory.showItemInSupplies(21));
                drawString(23, "    [8] " + Inventory.showItemInSupplies(7) + " || [23] " + Inventory.showItemInSupplies(22));
                drawString(24, "    [9] " + Inventory.showItemInSupplies(8) + " || [24] " + Inventory.showItemInSupplies(23));
                drawString(25, "   [10] " + Inventory.showItemInSupplies(9) + " || [25] " + Inventory.showItemInSupplies(24));
                drawString(26, "   [11] " + Inventory.showItemInSupplies(10) + " || [26] " + Inventory.showItemInSupplies(25));
                drawString(27, "   [12] " + Inventory.showItemInSupplies(11) + " || [27] " + Inventory.showItemInSupplies(26));
                drawString(28, "   [13] " + Inventory.showItemInSupplies(12) + " || [28] " + Inventory.showItemInSupplies(27));
                drawString(29, "   [14] " + Inventory.showItemInSupplies(13) + " || [29] " + Inventory.showItemInSupplies(28));
                drawString(30, "   [15] " + Inventory.showItemInSupplies(14) + " || [30] " + Inventory.showItemInSupplies(29));
                drawString(34, "   To select an item, type in the number or letter of the slot.");
        switch(LayoutPicker.entry){
            case 9980: //Start screen
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   To select an item, type in the number or letter of the slot.");
                drawString(37, Inventory.actionOptions());
                break;
            case 9981: //Show details of item
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   Details: " + Inventory.showItemName());
                drawString(35, "   " + Inventory.showItemDetails());
                drawString(37, Inventory.actionOptions());
                break;
            case 9982: //Hold item in hand
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   " + Inventory.showItemInHand());
                drawString(35, "   " + Inventory.showItemDetails());
                drawString(37, Inventory.actionOptions());
                break;
            case 9983: //Equip item failure
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   " + Inventory.showItemInHand());
                drawString(35, "   " + Inventory.showItemDetails());
                drawString(36, "   " + Inventory.errormessage);
                drawString(37, Inventory.actionOptions());
                break;
        }

    }

    public static void LootBox(){
        switch(LayoutPicker.entry) {
            case 9970:
                wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
                nameHPMPEnergy(2);
                drawString(4, "\\_               \\               ..       YOU'VE FOUND           s            /               _/");
                drawString(5, "  \\_              \\        x .d88\"                              :8           /              _/");
                drawString(6, "    \\_             \\        5888R          u.          u.      .88          /             _/");
                drawString(7, "      \\_            \\       '888R    ...ue888b   ...ue888b    :888ooo      /            _/");
                drawString(8, "        \\_           \\       888R    888R Y888r  888R Y888r -*8888888     /           _/");
                drawString(9, "          \\_          \\      888R    888R I888>  888R I888>   8888       /          _/");
                drawString(10, "_           \\_         \\     888R    888R I888>  888R I888>   8888      /         _/           _");
                drawString(11, " \\__          \\_        \\    888R    888R I888>  888R I888>   8888     /        _/          __/");
                drawString(12, "    \\__         \\_       \\   888R   u8888cJ888  u8888cJ888   .8888Lu= /       _/         __/");
                drawString(13, "       \\__        \\_      \\ .888B ,  \"*888*P\"    \"*888*P\"    ^%888*  /      _/        __/");
                drawString(14, "          \\__       \\_     \\^*888%:    'Y\"         'Y\"         'Y\"  /     _/       __/");
                drawString(15, "             \\__      \\_    \\ \"%                                   /    _/      __/");
                drawString(16, "                \\__     \\_         ____...------------...____         _/     __/");
                drawString(17, "                   \\__        _.-\"` /o/__ ____ __ __  __ \\o\\_`\"-._        __/");
                drawString(18, "                      \\__   .'     / /                    \\ \\     '.   __/");
                drawString(19, "                            |=====/o/======================\\o\\=====|");
                drawString(20, "------------------------    |____/_/________..____..________\\_\\____|    ------------------------");
                drawString(21, "                            /   _/ \\_     <_o#\\__/#o_>     _/ \\_   \\");
                drawString(22, "                      __/   \\_________\\####/_________\\####/________/   \\__");
                drawString(23, "                   __/       |===\\!/========================\\!/===|       \\__");
                drawString(24, "                __/      _/  |   |=|          .---.         |=|   |  \\_      \\__");
                drawString(25, "             __/       _/    |===|o|=========/ ( ) \\========|o|===|    \\_       \\__");
                drawString(26, "          __/        _/    / |   | |         \\( = )/        | |   | \\    \\_        \\__");
                drawString(27, "       __/         _/     /  |===|o|======{'-.)| |(.-'}=====|o|===|  \\     \\_         \\__");
                drawString(28, "    __/          _/      /   | __/ \\__     '-.\\ W /.-'    __/ \\__ |   \\      \\_          \\__");
                drawString(29, " __/           _/       /    |==== .'.'^'.'.====|====.'.'^'.'.====|    \\       \\_           \\__");
                drawString(30, "/            _/        /     |  _\\o/   __  {.' __  '.} _   _\\o/  _|     \\        \\_            \\");
                drawString(31, "           _/         /      `\"\"\"\"-\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"-\"\"\"\"`      \\         \\_");
                drawString(34, "   You've encountered a lootbox!");
                drawString(36, "   [O] Open loot");
                drawString(37, "   [D] Discard");
                break;
            case 9971:
                wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
                nameHPMPEnergy(2);
                drawString(5, "                                          .--._");
                drawString(6, "                                         ||'-:_'-._");
                drawString(7, "                                         ||'::::-._'-._");
                drawString(8, "                                         ||  '::::::-._':-._");
                drawString(9, "                                         ||     ':::::::-.-`'.");
                drawString(10, "                                        _||      ':::::::||;`'.\\");
                drawString(11, "                                    _.-'_.;._     '::::::||   ||");
                drawString(12, "                                 .-'_.-!.@ oo!-._  ':::::||   ||");
                drawString(13, "                                 |._'-.@()!@ oo()!-.:::::||  .'/");
                drawString(14, "                                 ||U/'.o'-%$() &.@$&.'-.:|;-'.'");
                drawString(15, "                                 ||'|._ o-._'-%_@'@()%@!.-'<`");
                drawString(16, "                                 ||'|  o-._ '-._'-.@.-'_.-||");
                drawString(17, "                                 ||'| o    '-.\\U/-._.-' ]=||");
                drawString(18, "                                 ||'|  o      |'| ||=[.-' ||");
                drawString(19, "                                 :' |_        |'| ||      ||");
                drawString(20, "                                  '-._'-._    |'| ||      ||");
                drawString(21, "                                      '-._'-._|'| ||   _.-'|");
                drawString(22, "                                         '-._` '| ||.-'_.-'");
                drawString(23, "                                             '-.\\_||.-'");
                drawString(26, "           .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.");
                drawString(27, "         :::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\");
                drawString(28, "         '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      `");
                drawString(34, "   The loot contained... " + LootBox.getLootName() + ".");
                drawString(36, "   [T] Take");
                drawString(37, "   [D] Drop");
                break;
        }
    }

    //TESTS
    public static void test123(){
        drawString(20, "FUCKEEHYOUUUUUUUUUUUUUUUUUUUUU!!!!");
    }
    public static void testwipe() {wipeScreenWithExceptions(4, 26, 34,12, 24, 0);}
}
