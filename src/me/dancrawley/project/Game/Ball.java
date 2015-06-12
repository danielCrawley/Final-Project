package me.dancrawley.project.Game;

import me.dancrawley.project.passwordfail.Main;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by 257019 on 5/13/2015.
 */
public class Ball {
    private int xcentre;
    private int ycentre;
    private int radius;
    private int ymove = 1;
    private int acceleration;

    public Ball(int a, int b, int c) {
        this.xcentre = a;
        this.ycentre = b;
        this.radius = c;
        acceleration = 1;
    }

    public void drawShape(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(this.xcentre - this.radius, this.ycentre - this.radius, this.radius * 2, this.radius * 2);
    }

    public int getFarRight() {
        return xcentre + radius;
    }

    public int getFarLeft() {
        return xcentre - radius;
    }

    public int getFarUp() {
        return this.ycentre - this.radius;
    }

    public int getFarDown() {
        return this.ycentre + this.radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setY(int y) {
        ycentre = y;
        acceleration = 1;
        ymove = 1;
    }

    public boolean out() {
        return (this.getFarUp() <= -5 || this.getFarDown() >= Panel.HEIGHT);
    }

    public boolean move(Pong p) {
        if (collided(p)) {
            Panel.paddleScore++;

            if (Panel.paddleScore % 5 == 0) {

                new Thread(new SoundThread(Main.class.getResource("/resources/airhorn.wav").getFile())).start();

            }

            ymove *= -1;
            acceleration *= -1;
        } else if (out()) {
            ymove = 0;
        }
        if (this.getFarDown() >= p.getYTop() && !collided(p)) {
            Panel.ballScore++;

            if (Panel.ballScore % 5 == 0) {

                new Thread(new SoundThread(Main.class.getResource("/resources/airhorn.wav").getFile())).start();

            }

            ymove += acceleration;
            ycentre += ymove;
            return true;

        }
        ymove += acceleration;
        ycentre += ymove;
        return false;


    }


    public boolean collided(Pong pong) {
        return getFarDown() >= pong.getYTop() && pong.inXRange(this.xcentre);
    }

}
