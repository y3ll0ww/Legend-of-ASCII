package yellow.game.gui;

import java.util.concurrent.TimeUnit;

public class ScreenDrawer {
    public static String line01 = "", line02 = "", line03 = "", line04 = "", line05 = "", line06 = "", line07 = "",
            line08 = "", line09 = "", line10 = "", line11 = "", line12 = "", line13 = "", line14 = "",
            line15 = "", line16 = "", line17 = "", line18 = "", line19 = "", line20 = "", line21 = "",
            line22 = "", line23 = "", line24 = "", line25 = "", line26 = "", line27 = "", line28 = "",
            line29 = "", line30 = "", line31 = "", line32 = "", line33 = "", line34 = "", line35 = "",
            line36 = "", line37 = "", line38 = "", line39 = "", line40 = "";

    public static void drawMultipleStrings(int from, int to, String with) {
        for (int i = from; i <= to; i++) {
            drawString(i, with);
        }
    }
    public static void drawACoupleStrings(int w, int x, int y, int z, String fill){
        for (int i = 1; i <= 40; i++) {
            if (i==w||i==x||i==y||i==z){
                drawString(i, fill);
            }
        }
    }
    public static void wipeScreen() {
        for (int i = 1; i <= 40; i++) {
            drawString(i, "");
        }
    }
    public static void wipeScreenWithExceptions(int u, int v, int w, int x, int y, int z){
        for (int i = 1; i <= 40; i++) {
            if (i!=u && i!=v && i!=w && i!=x && i!=y && i!=z){
                drawString(i, "");
            }
        }
    }
    public static void wipeString(int line) {
        drawString(line, "");
    }
    public static void wipeMultipleStrings(int x, int y, int z){
        drawString(x, "");
        drawString(y, "");
        drawString(z, "");
    }
    public static String convertToHTML(String input){
        String output = input;
        // Allow ampersand
        output = output.replaceAll("&", "&amp;");
        // Allow spaces
        output = output.replaceAll(" ", "&#32;");
        // Allow tag symbols
        output = output.replaceAll("<", "&lt;");
        output = output.replaceAll(">", "&gt;");
        // Reverse HTML tags
        output = output.replaceAll( "&lt;font","<font");
        output = output.replaceAll("'&gt;", "'>");
        output = output.replaceAll("&lt;/font&gt;", "</font>");
        output = output.replaceAll("&lt;em&gt;", "<em>");
        output = output.replaceAll("&lt;/em&gt;", "</em>");
        // Color certain variables
        output = output.replaceAll("&#32;DEF&#32;", "<font color='ORANGE'> DEF </font>");
        output = output.replaceAll("&#32;ATT&#32;", "<font color='RED'> ATT </font>");
        output = output.replaceAll("&#32;WGHT&#32;", "<font color='LIGHTGRAY'> WGHT </font>");
        output = output.replaceAll("&#32;TWOHANDED&#32;", "<font color='LIGHTGRAY'> TWOHANDED </font>");
        output = output.replaceAll("&#32;RANGED&#32;", "<font color='LIGHTGRAY'> RANGED </font>");
        output = output.replaceAll("&#32;MGC&#32;", "<font color='DODGERBLUE'> MGC </font>");
        output = output.replaceAll("&lt;empty&#32;slot&gt;", "<font color='GRAY'>&lt;empty slot&gt</font>");
        output = output.replaceAll("!level", "<font color='CYAN'>L</font>");
        // Color magic
        output = output.replaceAll("FIRE", "<font color='#FF4500'>FIRE</font>");
        output = output.replaceAll("WATER", "<font color='DODGERBLUE'>WATER</font>");
        output = output.replaceAll("EARTH", "<font color='#DAA520'>EARTH</font>");
        output = output.replaceAll("AIR", "<font color='#F0FFFF'>AIR</font>");
        output = output.replaceAll("ACID", "<font color='#ADFF2F'>ACID</font>");
        output = output.replaceAll("PSYCHO", "<font color='#F0F8FF'>PSYCHO</font>");
        output = output.replaceAll("THUNDER", "<font color='YELLOW'>THUNDER</font>");
        output = output.replaceAll("FROST", "<font color='#E0FFFF'>FROST</font>");
        output = output.replaceAll("NECRO", "<font color='#708090'>NECRO</font>");
        // Set (non-default) colors
        output = output.replaceAll("'DODGERBLUE'", "'#1E90FF'");
        output = output.replaceAll("'CYAN'", "'#00FFFF'");
        output = output.replaceAll("'MAGENTA'", "'#FF00FF'");
        output = output.replaceAll("'LIGHTGRAY'", "'#A9A9A9'");
        output = output.replaceAll("'GOLD'", "'#FFD700'");
        output = output.replaceAll("'KHAKI'", "'#F0E68C'");
        return output;
    }

    public static void drawString(int line, String input) {
    //    String fill = input.replaceAll("&", "&amp;");
      //  fill.replaceAll(" ", "&#32;");
        String fill = convertToHTML(input);
    //    fill = fill.replaceAll("<", "&lt;");
    //    fill = fill.replaceAll(">", "&gt;");
    //    String fill = input.replaceAll("&", "&amp;");
    //    fill = fill.replaceAll(" ", "&#32;");
        switch (line) {
            case 1:
                line01 = fill;
                break;
            case 2:
                line02 = fill;
                break;
            case 3:
                line03 = fill;
                break;
            case 4:
                line04 = fill;
                break;
            case 5:
                line05 = fill;
                break;
            case 6:
                line06 = fill;
                break;
            case 7:
                line07 = fill;
                break;
            case 8:
                line08 = fill;
                break;
            case 9:
                line09 = fill;
                break;
            case 10:
                line10 = fill;
                break;
            case 11:
                line11 = fill;
                break;
            case 12:
                line12 = fill;
                break;
            case 13:
                line13 = fill;
                break;
            case 14:
                line14 = fill;
                break;
            case 15:
                line15 = fill;
                break;
            case 16:
                line16 = fill;
                break;
            case 17:
                line17 = fill;
                break;
            case 18:
                line18 = fill;
                break;
            case 19:
                line19 = fill;
                break;
            case 20:
                line20 = fill;
                break;
            case 21:
                line21 = fill;
                break;
            case 22:
                line22 = fill;
                break;
            case 23:
                line23 = fill;
                break;
            case 24:
                line24 = fill;
                break;
            case 25:
                line25 = fill;
                break;
            case 26:
                line26 = fill;
                break;
            case 27:
                line27 = fill;
                break;
            case 28:
                line28 = fill;
                break;
            case 29:
                line29 = fill;
                break;
            case 30:
                line30 = fill;
                break;
            case 31:
                line31 = fill;
                break;
            case 32:
                line32 = fill;
                break;
            case 33:
                line33 = fill;
                break;
            case 34:
                line34 = fill;
                break;
            case 35:
                line35 = fill;
                break;
            case 36:
                line36 = fill;
                break;
            case 37:
                line37 = fill;
                break;
            case 38:
                line38 = fill;
                break;
            case 39:
                line39 = fill;
                break;
            case 40:
                line40 = fill;
        }
    }

}