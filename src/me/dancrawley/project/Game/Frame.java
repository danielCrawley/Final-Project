package me.dancrawley.project.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by 257019 on 5/19/2015.
 */
public class Frame implements Runnable {
    JFrame f;
    final Panel p;


    public Frame() {
        f = new JFrame("MLG Bounce");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new Panel();
        f.add(p);

        f.pack();
        f.setVisible(true);


        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        p.pong.move = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        p.pong.move = 2;
                        break;
                    case KeyEvent.VK_A:
                        if (p.balls[0].out()) {
                            p.balls[0].setY(0 + p.balls[0].getRadius());
                            p.balls[0].move(p.pong);

                        }
                        break;
                    case KeyEvent.VK_S:
                        if (p.balls[1].out()) {
                            p.balls[1].setY(0 + p.balls[1].getRadius());
                            p.balls[1].move(p.pong);
                        }
                        break;
                    case KeyEvent.VK_D:
                        if (p.balls[2].out()) {
                            p.balls[2].setY(0 + p.balls[2].getRadius());
                            p.balls[2].move(p.pong);
                        }
                        break;
                    case KeyEvent.VK_SPACE:

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        p.setFocusable(true);
        p.requestFocusInWindow();
    }

    @Override
    public void run() {


        new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.repaint();
            }
        }).start();

    }
}
