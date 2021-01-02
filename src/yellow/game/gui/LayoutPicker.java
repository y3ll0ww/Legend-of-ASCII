package yellow.game.gui;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LayoutPicker {
    //Entrypoint
    public static int entry = 0;

    //Method to get layouts from the Layouts class
    public static void browseLayout() {
        if(entry == 0){
            Layouts.titleScreen();
        } else if(entry ==1){
            Layouts.mainMenu();
        } else if(entry >= 10 && entry < 20){
            Layouts.characterCreation();
        } else if(entry >= 50 && entry <= 70) {
            Layouts.introStory();
        } else if(entry >= 9960 && entry < 9970){
            Layouts.battleMode();
        } else if(entry >= 9970 && entry < 9980){
            Layouts.LootBox();
        } else if(entry >= 9980 && entry < 9990){
            Layouts.Inventory();
        } else if(entry == 9990){
            Layouts.walkingOverMap();
        } else if(entry == 9991){
            Layouts.showMap();
        } else if(entry == 999){ //TEST
            Layouts.walkingOverMap();
        }
    }
}
