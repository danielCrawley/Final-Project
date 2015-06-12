package me.dancrawley.project.Game;

import java.awt.*;

/**
 * Created by 257019 on 5/20/2015.
 */
public class Pong {
    private int xcentre;
    private int ycentre;
    private int length;
    private int width;
    public int move;
    public final int MOVE = 20;

    public Pong(int x, int y, int l) {
        xcentre = x;
        ycentre = y;
        length = l;
        width = 12;
        move = 1;

    }

    public int getX() {
        return xcentre;
    }

    public int getY() {
        return ycentre;
    }

    public int getYTop() {
        return ycentre - this.width / 2;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getLeft() {
        return this.xcentre - (this.length / 2);
    }

    public int getRight() {
        return this.xcentre + (this.length / 2);
    }


    public void moveRight() {
        if (xcentre + length / 2 <= Panel.WIDTH && move == 2)
            xcentre += MOVE;
    }

    public void moveLeft() {
        if (xcentre - length / 2 >= 0 && move == 0)
            xcentre -= MOVE;
    }

    public boolean inXRange(int position) {
        return position >= this.getLeft() && position <= getRight();
    }

    public void drawShape(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(xcentre - (length / 2), ycentre - (width / 2), length, width);
    }
}
