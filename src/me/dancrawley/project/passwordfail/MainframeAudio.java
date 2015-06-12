package me.dancrawley.project.passwordfail;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/**
 * Created by 257019 on 5/19/2015.
 */
public class MainframeAudio implements Runnable {
    Thread bill;
    Timer timer;
    Clip soundClip = null;
    boolean firstTime = true;
    public URL blipUrl;

    public MainframeAudio() {
        bill = new Thread(this);
        this.bill.start();
    }

    @Override
    public void run() {

        if (firstTime) {
            this.playSound();
            firstTime = false;
        }


        this.timer = new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound();
            }
        });


    }

    public void stop() {
        try {
            this.bill.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {

        blipUrl = this.getClass().getResource("/resources/hackerSound.wav");
        System.out.println("File: " + blipUrl.getFile());

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(blipUrl);
            soundClip = AudioSystem.getClip();
            soundClip.open(ais);

            soundClip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
