package yellow.game.gui;

import static yellow.game.gui.ScreenDrawer.*;
import static yellow.game.resources.objects.Map.*;

import yellow.game.resources.BattleMode;
import yellow.game.resources.Inventory;
import yellow.game.resources.LootBox;
import yellow.game.resources.NPC.Avatar;
import yellow.game.resources.NPC.Enemy;
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

        drawString(line, "   " + PlayerCharacter.getName() + addspaces + statspaces + "<font color='RED'>HP:</font> " + PlayerCharacter.getHP() +
                "/" + PlayerCharacter.getMaxHP() + "   <font color='DODGERBLUE'>MP:</font> " + PlayerCharacter.getMP() + "/" + PlayerCharacter.getMaxMP() +
                "   <font color='LIME'>Energy:</font> " + PlayerCharacter.getEnergy() + "/" + PlayerCharacter.getMaxEnergy());
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
        drawString(6, "<font color='YELLOW'>                  _____                                        __              ___");
        drawString(7, "                 |_   _|                                      |  ]           .' ..]");
        drawString(8, "                   | |      .---.  .--./) .---.  _ .--.   .--.| |    .--.   _| |_");
        drawString(9, "                   | |   _ / /__\\\\/ /'`\\;/ /__\\\\[ `.-. |/ /'`\\' |  / .'`\\ \\'-| |-'");
        drawString(10, "                  _| |__/ || \\__.,\\ \\._//| \\__., | | | || \\__/  |  | \\__. |  | |");
        drawString(11, "                 |________| '.__.'.',__`  '.__.'[___||__]'.__.;__] </font>=\\\\\\\\<font color='YELLOW'>.'  [___]</font>. .");
        drawString(12, "        ///~`     |\\\\_<font color='YELLOW'>       _   ( ( __))__     ______  _____  ____</font>,_)  \\      _/_/|");
        drawString(13, "       ,  |='  ,))\\_| ~-_<font color='YELLOW'>   / \\    .' ____ \\  .' ___  ||_   _||_   _</font>~~~\\-~-_ /~ (_/\\");
        drawString(14, "      / ,' ,;((((((    ~ \\<font color='YELLOW'> / _ \\   | (___ \\_|/ .'   \\_|  | |    | |</font>     \\_  /'  D   |");
        drawString(15, "    /' -~/~)))))))'\\_   _/'<font color='YELLOW'> ___ \\   _.____`. | |         | |    | |</font>       ~-;  /    \\--_");
        drawString(16, "   (       (((((( ~-/ ~-<font color='YELLOW'> / /   \\ \\_| \\____) |\\ `.___.'\\ _| |_  _| |_</font>        `~~\\_    \\   )");
        drawString(17, "    ~~--|   ))''    ')<font color='YELLOW'> |____| |____|\\______.' `.____ .'|_____||_____|</font>         /~~-     ./");
        drawString(18, "        :        (_  ~\\           ,                                          |    )    )|");
        drawString(19, "         \\        \\_   )--__  /(_/)                             /,_;,   __--(   _/      |");
        drawString(20, "         |_     \\__/~-__    ~~   ,'       CREATED BY            \\-  ((~~    __-~        |");
        drawString(21, "        /' ~~~----|     ~~~~~~~~'       Jelle van Geel           ``~~ ~~~~~~   \\_      /");
        drawString(22, "       (      _-~~-\\                                                           )       )");
        drawString(23, "       \\     /      \\                                                        _-    ,;;(");
        drawString(24, "       ;`~--'        :                <font color='GRAY'>github.com/y3ll0ww</font>                   _-~    ,;;;;)");
        drawString(25, "       |    `\\       |     <font color='GRAY'>linkedin.com/in/jelle-van-geel-437656120</font>     _-~          _/");
        drawString(26, "       |    /'`\\     ;                                                 /;;;''  ,;;:-~");
        drawString(27, "      /~   /    |    )                                                |;;'   ,''");
        drawString(28, "     |    /     / | /                                                 |   ,;(");
        drawString(29, "     /   /     |  \\\\|                                            .---__\\_    \\,--._______");
        drawString(30, "   _/  /'       \\  \\_)                                          (;;'  ;;;~~~/' `;;|  `;;;\\");
        drawString(31, "  ( )|'         (~-_|                        ;--__               ~~~----__/'    /'_______/");
        drawString(32, "   ) `\\_         |-_;                        ~--_ ~~~;;------------~~~~~ ;;;'_/'");
        drawString(33, "   `----'       (   `~--_                        '~~~-----....___;;;____---~~");
        drawString(34, "                `~~~~~~~~'");
        drawString(38, "                                  Press [<font color='MAGENTA'>ENTER</font>] to continue...");
    }

    public static void mainMenu() {
        wipeScreen();
        drawString(2, "<font color='YELLOW'> Legend of ASCII</font>                                                                     <font color='CYAN'>BUILD v1.0</font>");
        drawString(3, "<font color='#00008B'>  .--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--.");
        drawString(4, " / .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\");
        drawString(5, " \\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/");
        drawString(6, "  \\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /");
        drawString(7, "  / /\\/ /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /`' /\\/ /\\");
        drawString(8, " / /\\ \\/`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\ \\/\\ \\");
        drawString(9, " \\ \\/\\ \\                                                                                /\\ \\/ /");
        drawString(10, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(11, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(12, " / /\\ \\/<font color='YELLOW'>           .                  </font><font color='WHITE'>.-.    <font color='YELLOW'>.  _   *</font>     _   <font color='YELLOW'>.</font></font>                         \\ \\/\\ \\");
        drawString(13, " \\ \\/\\ \\<font color='YELLOW'>                  *          </font><font color='WHITE'>/   \\<font color='YELLOW'>     ((       </font>_/ \\<font color='YELLOW'>       *    .</font></font>               /\\ \\/ /");
        drawString(14, "  \\/ /\\ \\               <font color='WHITE'>_    .   .--'\\/\\_ \\     <font color='YELLOW'>`</font>      /    \\  <font color='YELLOW'>*</font>    ___</font>                / /\\/ /");
        drawString(15, "  / /\\/ /<font color='YELLOW'>           *</font>  <font color='WHITE'>/ \\_    _/ ^      \\/\\'__        /\\/\\  /\\  __/   \\ <font color='YELLOW'>*</font></font>             \\ \\/ /\\");
        drawString(16, " / /\\ \\/              <font color='WHITE'>/    \\  /    .'   _/  /  \\  <font color='YELLOW'>*'</font> /    \\/  \\/ .`'\\_/\\   <font color='YELLOW'>.</font></font>            \\ \\/\\ \\");
        drawString(17, " \\ \\/\\ \\<font color='YELLOW'>         .</font>   <font color='LIGHTGRAY'>/\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-.\\ _    _:\\ _</font>             /\\ \\/ /");
        drawString(18, "  \\/ /\\ \\           <font color='LIGHTGRAY'>/    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\</font>           / /\\/ /");
        drawString(19, "  / /\\/ /         <font color='LIGHTGRAY'>/\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\</font>          \\ \\/ /\\");
        drawString(20, " / /\\ \\/         <font color='GRAY'>/  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.</font>         \\ \\/\\ \\");
        drawString(21, " \\ \\/\\ \\       <font color='GRAY'>/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%</font>        /\\ \\/ /");
        drawString(22, "  \\/ /\\ \\      <font color='GREEN'>@&8jgs@@%% @)&@&(88&@<font color='BLUE'>.-_=_-=_-=_-=_-=_.</font>8@% &@&&8(8%@%8)(8@%8 8%@)%</font>      / /\\/ /");
        drawString(23, "  / /\\/ /      <font color='KHAKI'><font color='GREEN'>@88</font>:::<font color='GREEN'>&(&8&&8</font>:::::<font color='GREEN'>%&</font><font color='BLUE'>`.~-_~~-~~_~-~_~-~~=.'</font><font color='GREEN'>@(&%</font>::::<font color='GREEN'>%@8&8)</font>::<font color='GREEN'>&#@8</font>::::</font>      \\ \\/ /\\");
        drawString(24, " / /\\ \\/       <font color='KHAKI'>`::::::<font color='GREEN'>8%@@%</font>:::::<font color='GREEN'>@%&8</font><font color='BLUE'>:`.=~~-.~~-.~~=..~'</font><font color='GREEN'>8</font>::::::::<font color='GREEN'>&@8</font>:::::<font color='GREEN'>&8</font>:::::'</font>        \\ \\/\\ \\");
        drawString(25, " \\ \\/\\ \\        <font color='KHAKI'>`::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::.'</font>         /\\ \\/ /");
        drawString(26, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(27, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(28, " / /\\ \\/                                  <font color='WHITE'>[<font color='YELLOW'>1</font>] New Game</font>                                  \\ \\/\\ \\");
        drawString(29, " \\ \\/\\ \\                                                                                /\\ \\/ /");
        drawString(30, "  \\/ /\\ \\                                                                              / /\\/ /");
        drawString(31, "  / /\\/ /                                                                              \\ \\/ /\\");
        drawString(32, " / /\\ \\/                                                                                \\ \\/\\ \\");
        drawString(33, " \\ \\/\\ \\.--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--./\\ \\/ / ");
        drawString(34, "  \\/ /\\/ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ ../ /\\/ /");
        drawString(35, "  / /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\/ /\\");
        drawString(36, " / /\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\");
        drawString(37, " \\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /");
        drawString(38, "  `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'</font>");
        drawString(39, "Cast your command below:");
    }

    public static void characterCreation() {
        String article = "";
        String adjective = "";

        switch(LayoutPicker.entry) {
            case 10:
                wipeScreen();
                drawACoupleStrings(1, 3, 32, 39, "<font color='GRAY'>-8|==========================================================================================|8-</font>");
                drawString(2, "   CHARACTER CREATION");
                drawString(10, "               Welcome, new hero!");
                drawString(12, "               You're about to step into a new world...");
                drawString(13, "               But first, let us create a hero for the story.");
                drawString(15, "               --");
                drawString(17, "               [<font color='YELLOW'>GO</font>]    Go to character creation.");
                drawString(18, "               [<font color='YELLOW'>EXIT</font>]  Exit to main menu.");
                drawString(34, "   HINT");
                drawString(35, "   Possible commands are always captured in square brackets. To execute an action, type the");
                drawString(36, "   command and press enter.");
                break;
            case 11:
                drawString(10, "               GENDER");
                drawString(12, "               Let's create your hero.");
                drawString(13, "               First things first, is your hero male or female?");
                drawString(17, "               [<font color='YELLOW'>1</font>] Male");
                drawString(18, "               [<font color='YELLOW'>2</font>] Female");
                break;
            case 12:
                drawString(10, "               RACE");
                drawString(12, "               You chose " + PlayerCharacter.getGender(0) + ". Let's pick " + PlayerCharacter.getGender(2) + " a race.");
                drawString(13, "               What race is your character?");
                drawString(17, "               [<font color='YELLOW'>1</font>] Human");
                drawString(18, "               [<font color='YELLOW'>2</font>] Elf");
                drawString(19, "               [<font color='YELLOW'>3</font>] Orc");
                drawString(20, "               [<font color='YELLOW'>4</font>] Dwarf");
                drawString(35, "   You can always go [back] if you're not happy with your choice.");
                wipeString(36);
                break;
            case 13:
                wipeString(15); wipeString(18);
                drawString(10, "               CLASS");
                drawString(12, "               You've chosen your hero to be " + PlayerCharacter.getRace(4) + " " + PlayerCharacter.getRace(0) + ".");
                drawString(17, "               --");
                drawString(15, "               Now, choose a class.");
                drawString(19, "               [<font color='YELLOW'>1</font>] Warrior");
                drawString(20, "               [<font color='YELLOW'>2</font>] Ranger");
                drawString(21, "               [<font color='YELLOW'>3</font>] Rogue");
                drawString(22, "               [<font color='YELLOW'>4</font>] Mage");
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
                    drawString(19, "               [<font color='YELLOW'>1</font>] Ugoris (Northern)");
                    drawString(20, "               [<font color='YELLOW'>2</font>] Ageon (Western)");
                    drawString(21, "               [<font color='YELLOW'>3</font>] Yepalos (Central)");
                    wipeString(22);
                } else if(PlayerCharacter.getRace(0) == "elf"){
                    drawString(19, "               [<font color='YELLOW'>1</font>] Ugoris (Northern)");
                    drawString(20, "               [<font color='YELLOW'>2</font>] Shiyux (Eastern)");
                    wipeMultipleStrings(21, 22, 0);
                } else if(PlayerCharacter.getRace(0) == "orc"){
                    drawString(19, "               [<font color='YELLOW'>1</font>] Ageon (Western)");
                    drawString(20, "               [<font color='YELLOW'>2</font>] Klaekun (Southern)");
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
                drawString(20, "               [<font color='YELLOW'>GO</font>]    Continue with this character");
                drawString(21, "               [<font color='YELLOW'>BACK</font>]  Go back");
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
                drawString(37, "   Press [<font color='MAGENTA'>ENTER</font>] to continue");
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
                drawString(35, "   You are <font color='ORANGE'>" + PlayerCharacter.getName() + "</font>, " + PlayerCharacter.getGender(4) + " of " + PlayerCharacter.getFather() + ".");
                break;
            case 59:
                drawString(36, "   And one day you will avenge your father...");
                break;
            case 60:
                wipeScreenWithExceptions(1, 2, 3, 32, 39, 0);
                break;
            case 61:
                drawString(35, "   \"<font color='ORANGE'>" + PlayerCharacter.getName() + "</font>! WAKE UP!\"");
                break;
            case 62:
                drawString(16, "<font color='ORANGE'>                                                        (  .      )");
                drawString(17, "                                                    )           (              )");
                drawString(18, "                                                          .  '   .   '  .  '  .");
                drawString(19, "    ,.   (   .      )        .      \"            (    , )       (.   )  (   ',    )");
                drawString(20, "   (\"     )  )'     ,'        )  . (`     '`      .' ) ( . )    ,  ( ,     )   ( .");
                drawString(21, " .; )  ' (( (\" )    ;(,     ((  (  ;)  \"  )\"   ). , ( .   (  ) ( , ')  .' (  ,    )    .; )  ' (");
                drawString(22, " _\"., ,._'_.,)_(..,( . )_  _' )_') (. _..( '..(_,) . ), ) _) _,')  (, ) '. )  ,. (' ) _\"., ,._'_");
                drawString(23, ".   (  ) ( , ')  .' (  ,    )    .; )  ' ( .; )  ' (( (\" )    ;(,     ((  (  ;)  \"  )\"   ). , (");
                drawString(24, "_\"., ,._'_ _\"., ,._'_.,)_(..,( . )_  _' )_') (. _..( '..(_,) . ), ) _) _,')  (, ) '. )  ,. (' )</font>");
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
                drawString(36, "   [<font color='YELLOW'>1</font>] Escape");
                drawString(37, "   [<font color='YELLOW'>2</font>] Take debris");
                break;
            case 66:
                wipeMultipleStrings(34, 37, 0);
                drawString(35, "   You equipped yourself with a WOODEN STICK.");
                drawString(36, "   [<font color='YELLOW'>1</font>] Try to escape again");
                break;
            case 67:
                wipeMultipleStrings(35, 36, 37);
                drawString(34, "   You crawl through the window successfully and start running for the forest.");
                break;
            case 68:
                drawString(35, "   Someone sees you. \"<font style='i'>HEY YOU! STOP RIGHT THERE!</font>\"");
                break;
            case 69:
                drawString(36, "   [<font color='YELLOW'>1</font>] Fight");
                drawString(37, "   [<font color='YELLOW'>2</font>] Flight");
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
                drawString(4, "<font color='GREEN'>                                                            *j");
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
                drawString(29, "     `rv</font>|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|<font color='GREEN'>QMIKOm:");
                drawString(30, "      '!</font>|   " + Map.getDisplayInformation() + "   |<font color='GREEN'>!-;3yVyz</font>");
                drawString(31, "        |                                                                              |<font color='GREEN'>        -,\"*!</font>");
                break;
            case "Mountains":
                drawString(6, "<font color='LIGHTGRAY'>                                            `)]M`");
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
                drawString(28, "`         `     '_-   '*~_  '     `'`}_` `'`*- .^ `!:`        .` `_,\"`'!r-    `_, ^_     ~L-``-\"</font>");
                drawString(29, "        |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|<font color='LIGHTGRAY'>     _</font>");
                drawString(30, "        |   " + Map.getDisplayInformation() + "   |");
                drawString(31, "        |                                                                              |");
                break;
            case "Swamp":
                drawString(4, "<font color='GRAY'>                           `\\`         *`*. : .    *.\\     -_.=            L):");
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
                drawString(29, " -:(m*Y\\</font>|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|<font color='GRAY'>c* -r==!!~`");
                drawString(30, "  -::VH:</font>|   " + Map.getDisplayInformation() + "   |<font color='GRAY'>sy\\!,::;^</font>");
                drawString(31, "        |                                                                              |<font color='GRAY'>_^^~` `'..--_-</font>");
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
        drawString(34, "        " + Map.option1 + "             [<font color='YELLOW'>R</font>] Rest");
        drawString(35, "        " + Map.option2 + "             [<font color='YELLOW'>M</font>] Map");
        drawString(36, "                                 [<font color='YELLOW'>S</font>] Stats");
        drawString(37, "                                 [<font color='YELLOW'>I</font>] Inventory");
        if(Map.numberofoptions == 3){
            drawString(36, "        " + Map.option3 + "             [<font color='YELLOW'>S</font>] Stats");
        } else if(Map.numberofoptions == 4){
            drawString(36, "        " + Map.option3 + "             [<font color='YELLOW'>S</font>] Stats");
            drawString(37, "        " + Map.option4 + "             [<font color='YELLOW'>I</font>] Inventory");
        }
    }

    public static void showMap(){
        wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
        nameHPMPEnergy(2);
        drawString(4, "     N");
        drawString(5, "   W + E                                     MAP OF");
        drawString(6, "     S                                  THE GREAT UGORIS");
        drawString(8, "<font color='GRAY'>" + printMapRow(0));
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
        drawString(27, "" + printMapRow(19) + "</font>");
        drawString(29, "      Ϙ = Player           <font color='KHAKI'>-</font> = Heath      <font color='LIGHTGRAY'>Ѧ</font> = Mountains   <font color='GOLD'>₮</font> = Town                        N");
        drawString(30, "      <font color='YELLOW'>֎</font> = Quest            <font color='LIME'>\"</font> = Forest     <font color='BLUE'>~</font> = Swamp                                     W + E");
        drawString(31, "                                                                                          S");
        drawString(34, "      Currently in:");
        drawString(35, "      " + Map.getNameofTile());
        drawString(37, "      [<font color='YELLOW'>EXIT</font>] Exit MAP");
    }

    public static void Inventory(){
                wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
                nameHPMPEnergy(2);
                drawString(5, "   EQUIPMENT                                                                     " + defineSpacesForInteger(Inventory.getGold()) + "GOLD: " + Inventory.getGold());
                drawString(6, "   ---------                                                            " + defineSpacesForInteger(Inventory.getTotalWeight()) + defineSpacesForInteger(PlayerCharacter.getStrength()) + "WEIGHT: " + Inventory.getTotalWeight() + "/" + PlayerCharacter.getStrength());
                drawString(7, "                                                                               Go to [<font color='YELLOW'>SPELLS</font>]");
                drawString(8, "   [<font color='YELLOW'>A</font>] Left hand:     " + Inventory.showItemInEquipment(0));
                drawString(9, "   [<font color='YELLOW'>B</font>] Right Hand:    " + Inventory.showItemInEquipment(1));
                drawString(10, "   [<font color='YELLOW'>C</font>] Head:          " + Inventory.showItemInEquipment(2));
                drawString(11, "   [<font color='YELLOW'>D</font>] Armor:         " + Inventory.showItemInEquipment(3));
                drawString(12, "   [<font color='YELLOW'>E</font>] Feet:          " + Inventory.showItemInEquipment(4));
                drawString(14, "   -----------------------------------------SUPPLIES-----------------------------------------");
                drawString(16, "    [<font color='YELLOW'>1</font>] " + Inventory.showItemInSupplies(0) + " || [<font color='YELLOW'>16</font>] " + Inventory.showItemInSupplies(15));
                drawString(17, "    [<font color='YELLOW'>2</font>] " + Inventory.showItemInSupplies(1) + " || [<font color='YELLOW'>17</font>] " + Inventory.showItemInSupplies(16));
                drawString(18, "    [<font color='YELLOW'>3</font>] " + Inventory.showItemInSupplies(2) + " || [<font color='YELLOW'>18</font>] " + Inventory.showItemInSupplies(17));
                drawString(19, "    [<font color='YELLOW'>4</font>] " + Inventory.showItemInSupplies(3) + " || [<font color='YELLOW'>19</font>] " + Inventory.showItemInSupplies(18));
                drawString(20, "    [<font color='YELLOW'>5</font>] " + Inventory.showItemInSupplies(4) + " || [<font color='YELLOW'>20</font>] " + Inventory.showItemInSupplies(19));
                drawString(21, "    [<font color='YELLOW'>6</font>] " + Inventory.showItemInSupplies(5) + " || [<font color='YELLOW'>21</font>] " + Inventory.showItemInSupplies(20));
                drawString(22, "    [<font color='YELLOW'>7</font>] " + Inventory.showItemInSupplies(6) + " || [<font color='YELLOW'>22</font>] " + Inventory.showItemInSupplies(21));
                drawString(23, "    [<font color='YELLOW'>8</font>] " + Inventory.showItemInSupplies(7) + " || [<font color='YELLOW'>23</font>] " + Inventory.showItemInSupplies(22));
                drawString(24, "    [<font color='YELLOW'>9</font>] " + Inventory.showItemInSupplies(8) + " || [<font color='YELLOW'>24</font>] " + Inventory.showItemInSupplies(23));
                drawString(25, "   [<font color='YELLOW'>10</font>] " + Inventory.showItemInSupplies(9) + " || [<font color='YELLOW'>25</font>] " + Inventory.showItemInSupplies(24));
                drawString(26, "   [<font color='YELLOW'>11</font>] " + Inventory.showItemInSupplies(10) + " || [<font color='YELLOW'>26</font>] " + Inventory.showItemInSupplies(25));
                drawString(27, "   [<font color='YELLOW'>12</font>] " + Inventory.showItemInSupplies(11) + " || [<font color='YELLOW'>27</font>] " + Inventory.showItemInSupplies(26));
                drawString(28, "   [<font color='YELLOW'>13</font>] " + Inventory.showItemInSupplies(12) + " || [<font color='YELLOW'>28</font>] " + Inventory.showItemInSupplies(27));
                drawString(29, "   [<font color='YELLOW'>14</font>] " + Inventory.showItemInSupplies(13) + " || [<font color='YELLOW'>29</font>] " + Inventory.showItemInSupplies(28));
                drawString(30, "   [<font color='YELLOW'>15</font>] " + Inventory.showItemInSupplies(14) + " || [<font color='YELLOW'>30</font>] " + Inventory.showItemInSupplies(29));
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
                drawString(35, "            " + Inventory.showItemDetails());
                drawString(37, Inventory.actionOptions());
                break;
            case 9982: //Hold item in hand
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   " + Inventory.showItemInHand());
                if(Inventory.getThisSlot() + 1 > 9){
                    drawString(35, "               " + Inventory.showItemDetails());
                } else {
                    drawString(35, "              " + Inventory.showItemDetails());
                }
                drawString(37, Inventory.actionOptions());
                break;
            case 9983: //Equip item failure
                wipeMultipleStrings(34, 35, 36); wipeString(37);
                drawString(34, "   " + Inventory.showItemInHand());
                drawString(35, "              " + Inventory.showItemDetails());
                drawString(36, "              <font color='RED'>" + Inventory.errormessage + "</font>");
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
                drawString(36, "   [<font color='YELLOW'>O</font>] Open loot");
                drawString(37, "   [<font color='YELLOW'>D</font>] Discard");
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
                drawString(34, "   The loot contained... <font color='MAGENTA'>" + LootBox.getLootName() + "</font>.");
                drawString(36, "   [<font color='YELLOW'>T</font>] Take");
                drawString(37, "   [<font color='YELLOW'>D</font>] Drop");
                break;
        }
    }

    public static void battleMode(){
        if(LayoutPicker.entry == 9960){
            wipeScreenWithExceptions(1, 3, 32, 39, 0, 0);
        }
        nameHPMPEnergy(2);
        drawString(7, BattleMode.displayHealthBar());
        drawString(8, BattleMode.displayHealthNumeric());
        drawString(5, "   .-=====================================================================================-.");
        drawString(6, BattleMode.displayName());
        drawString(9, "   '-=====================================================================================-'");
        drawString(10, Avatar.getAvatar(0));
        drawString(11, Avatar.getAvatar(1));
        drawString(12, Avatar.getAvatar(2));
        drawString(13, Avatar.getAvatar(3));
        drawString(14, Avatar.getAvatar(4));
        drawString(15, Avatar.getAvatar(5));
        drawString(16, Avatar.getAvatar(6));
        drawString(17, Avatar.getAvatar(7));
        drawString(18, Avatar.getAvatar(8));
        drawString(19, Avatar.getAvatar(9));
        drawString(20, Avatar.getAvatar(10));
        drawString(21, Avatar.getAvatar(11));
        drawString(22, Avatar.getAvatar(12));
        drawString(23, Avatar.getAvatar(13));
        drawString(24, Avatar.getAvatar(14));
        drawString(25, Avatar.getAvatar(15));
        drawString(26, Avatar.getAvatar(16));
        drawString(27, Avatar.getAvatar(17));
        drawString(28, Avatar.getAvatar(18));
        drawString(29, Avatar.getAvatar(19));
        drawString(30, Avatar.getAvatar(20));
        drawString(31, Avatar.getAvatar(21));
        switch(LayoutPicker.entry){
            case 9960:
                drawString(34, BattleMode.getDisplayInfo());
                if(BattleMode.getPlayerGoesFirst()){
                    drawString(35, "   You have initiative and go first.");
                } else {
                    drawString(35, "   The <font color='RED'>" + Enemy.getName() + "</font> has initiative and goes first.");
                }
                drawString(37, "   [<font color='YELLOW'>OK</font>] Start the fight - [<font color='YELLOW'>E</font>] Try to escape");
                break;
            case 9961: // Players turn
                drawString(34, BattleMode.displayAttack(0) + "[<font color='YELLOW'>I</font>] Inventory");
                drawString(35, BattleMode.displayAttack(1) + "[<font color='YELLOW'>R</font>] Rest (+5 NRGY)");
                drawString(36, BattleMode.displayAttack(2) + "[<font color='YELLOW'>T</font>] Toggle Spells");
                drawString(37, BattleMode.displayAttack(3) + "[<font color='YELLOW'>E</font>] Escape");
                break;
            case 9962: // Player turn results
                wipeMultipleStrings(34, 36, 37);
                drawString(35, BattleMode.getDisplayInfo());
                break;
            case 9963: // Player killed enemy
                drawString(35, "   You conquered the <font color='RED'>" + Enemy.getName() + "</font>!");
                drawString(36, BattleMode.getDisplayInfo());
                break;
            case 9964: // Looting conquered enemy
                wipeString(36);
                drawString(35, BattleMode.getDisplayInfo());
                if(BattleMode.hasLoot()){
                    drawString(37, "   [<font color='YELLOW'>T</font>] Take  - [<font color='YELLOW'>DROP</font>] Drop loot");
                }
                break;
            case 9965: // Enemies turn
                wipeMultipleStrings(34, 36, 37);
                drawString(35, "   The enemy is preparing to attack!");
                break;
            case 9966: // Enemies attack results
                drawString(36, BattleMode.getDisplayInfo());
                break;
            case 9968:
                drawString(36, BattleMode.getDisplayInfo());

        }
    }

    //TESTS
    public static void test123(){
        drawString(20, "FUCKEEHYOUUUUUUUUUUUUUUUUUUUUU!!!!");
    }
    public static void testwipe() {wipeScreenWithExceptions(4, 26, 34,12, 24, 0);}
}
