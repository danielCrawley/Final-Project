package me.dancrawley.project.Game;

import me.dancrawley.project.passwordfail.Main;

import javax.swing.*;

/**
 * Created by 257019 on 5/19/2015.
 */
public class Tester {

    public static SoundUtil soundUtil = new SoundUtil();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Frame());


        new Thread(new SoundThread(Main.class.getResource("/resources/sandstorm.wav").getFile())).start();
    }
}
