package me.dancrawley.project.passwordfail;

import javax.swing.*;

/**
 * Created by 257019 on 5/13/2015.
 */
public class Mainframe implements Runnable {
    JFrame b;

    Panelz a;

    public Mainframe() {
        this.b = new JFrame("Password Fail");
        this.b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add panel
        this.a = new Panelz();
        this.b.add(this.a);


        this.b.pack();
        this.b.setVisible(true);
    }

    @Override
    public void run() {

    }
}
