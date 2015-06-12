package me.dancrawley.project.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * Created by 257019 on 6/9/2015.
 */
public class SoundThread implements Runnable {

    public String fileURL;

    public SoundThread(String file) {

        this.fileURL = file;
    }

    @Override
    public void run() {

        try {
            Tester.soundUtil.playSound(new File(this.fileURL));
        } catch (IOException | UnsupportedAudioFileException | InterruptedException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
