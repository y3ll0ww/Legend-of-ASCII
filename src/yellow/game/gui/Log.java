package yellow.game.gui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    String[] log = new String[20];
    int previous = 0;
    String info;

    public String timeStamp(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date()) + ": ";
    }

    public String readLog(int ix){
        return log[ix];
    }

    public void writeLog(int entry){
        boolean logentry = true;
        if(entry != previous || previous == 9990){
            info = timeStamp();
            switch(entry){
                case 9960:
                    info += "Entered a battle";
                    break;
                case 9961:
                    info += "Players turn";
                    break;
                case 9963:
                    info += "Enemy killed";
                    break;
                case 9964:
                    info += "Enemy left loot";
                    break;
                case 9965:
                    info += "Enemies turn";
                    break;
                case 9970:
                    info += "Found loot";
                    break;
                case 9971:
                    info += "Loot opened";
                    break;
                case 9980:
                    if(previous == 9982){
                        info += "Equipped an item";
                    } else {
                        info += "Entered inventory";
                    }
                    break;
                case 9981:
                    info += "Looking at details of item";
                    break;
                case 9982:
                    info += "Holding item in hand";
                    break;
                case 9983:
                    info += "Failed to equip item";
                    break;
                case 9990:
                    if(previous == 9990){
                        info += "Moved on map";
                    } else {
                        info += "Entered freeroaming";
                    }
                    break;
                case 9991:
                    info += "Looking at the map";
                default:
                    logentry = false;

            }
            if(logentry){
                moveEntries();
                log[0] = info + " (" + entry + ")";
                previous = entry;
            }
        }
    }

    public void writeLog(String inf){
        moveEntries();
        info = timeStamp() + inf;
        log[0] = info;
    }

    public void moveEntries(){
        int position = log.length - 1;
        for(int i = 0; i < log.length; i++){
            if(log[i] == null){
                position = i;
                break;
            }
        }
        for(int j = position; j > 0; j--){
            log[j] = log[j - 1];
        }

    }
}
