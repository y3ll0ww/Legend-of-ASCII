package yellow.game;

import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {

    static Clip audio;

    public static synchronized void playSound(String url, boolean loop) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    File wav = new File("./src/yellow/assets/" + url);
                    AudioInputStream stream = AudioSystem.getAudioInputStream(wav);
                    AudioFormat format = stream.getFormat();
                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    audio = (Clip)AudioSystem.getLine(info);
                    audio.open(stream);
                    audio.start();
                    if(loop){
                        audio.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                } catch (Exception e) {
                    System.out.println("Exception: ");
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    public static void stopSound() {
        audio.stop();
    }
}
