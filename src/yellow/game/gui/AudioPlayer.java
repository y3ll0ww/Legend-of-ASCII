package yellow.game.gui;

import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {
    static Clip audio;
    static float adjvol = 0f;

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
        adjvol = 0f;
    }

    public static void adjustVolume(float decibels){
        adjvol = decibels;
        FloatControl gainControl = (FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(decibels);
    }

    public static void attackSounds(String attack){
        String audiofile = "attacks/";
        switch (attack){
            case "SHOOT":
            case "FIRE":
            case "BLAST":
                audiofile += "bow.wav";
                break;
            case "BOMBARD":
                //audiofile += "19_bombard.wav";
                break;
            case "CUT":
                audiofile += "21_cut.wav";
                break;
            case "CHARGE":
                audiofile += "22_charge.wav";
                break;
            case "SLICE":
                audiofile += "23_slice.wav";
                break;
            case "ASSAULT":
                //audiofile += "29_assault.wav";
                break;
            case "POKE":
                audiofile += "31_poke.wav";
                break;
            case "STAB":
                audiofile += "32_stab.wav";
                break;
            case "THRUST":
                audiofile += "33_thrust.wav";
                break;
            case "PIERCE":
                audiofile += "39_pierce.wav";
                break;
            case "PLOW":
                //audiofile += "39_plow.wav";
                break;
            case "STRIKE":
                audiofile += "41_strike.wav";
                break;
            case "BEAT":
                audiofile += "42_beat.wav";
                break;
            case "SMITE":
                audiofile += "43_smite.wav";
                break;
            case "CRUSH":
                audiofile += "49_crush.wav";
                break;
        }
        playSound(audiofile, false);
    }
}
