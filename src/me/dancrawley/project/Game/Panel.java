package me.dancrawley.project.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by 257019 on 5/19/2015.
 */
public class Panel extends JPanel {
    private int missedCount = 0;
    public boolean missed = false;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 900;
    Ball[] balls = new Ball[3];
    public static int paddleScore;
    public static int ballScore;
    public static final Font defaultFont = new Font("Arial", Font.TRUETYPE_FONT, 25);
    public static final Font rektFont = new Font("Comic Sans", Font.TRUETYPE_FONT, 30);
    Pong pong;
    Random rand;
    public int wordtimer;


    public Panel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        balls[0] = new Ball(40, -15, 15);//left ball
        balls[1] = new Ball((WIDTH - 40) / 2, -15, 15); // middle ball
        balls[2] = new Ball(WIDTH - 40, -15, 15); // right ball
        pong = new Pong(WIDTH / 2, HEIGHT - 40, 400); // de pong!
        paddleScore = 0;
        ballScore = 0;
        rand = new Random();
        wordtimer = 0;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < balls.length; i++) {

            if (!balls[i].out())
                if (balls[i].move(pong)) {
                    missed = true;

                }
            balls[i].drawShape(g);
        }
        pong.moveRight();
        pong.moveLeft();
        if (missed) {

            if (missedCount <= 20) {
                g.setFont(rektFont);
                g.drawString("get rekt", WIDTH / 2, HEIGHT / 2);
                missedCount++;
            } else {
                missedCount = 0;
                missed = false;
            }
        }

        g.setFont(defaultFont);
        pong.drawShape(g);
        g.setColor(Color.WHITE);
        g.drawString("PADDLE SCORE: " + paddleScore, 2, 25);
        g.drawString("BALL SCORE: " + ballScore, 2, 50);
        g.setColor(Color.GREEN);
        wordtimer++;
        g.setFont(rektFont);
        if (wordtimer > 60)
            wordtimer = 0;
        if(wordtimer<20)
            g.drawString("very hit",100, 250 );
        else if(wordtimer<40)
            g.drawString("much ball",WIDTH -200, HEIGHT-50 );
        else if(wordtimer<=60)
            g.drawString("so bounce", 400, 200);
    }
}

