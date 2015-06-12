package me.dancrawley.project.passwordfail;

import me.dancrawley.project.passwordfail.Mainframe;
import me.dancrawley.project.passwordfail.MainframeAudio;

import javax.swing.*;


/**
 * Created by 257019 on 5/12/2015.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Mainframe());
        MainframeAudio audioHandler = new MainframeAudio();


    }

}
