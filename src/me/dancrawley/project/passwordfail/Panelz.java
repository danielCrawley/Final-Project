package me.dancrawley.project.passwordfail;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 257019 on 5/13/2015.
 */
public class Panelz extends JPanel {
    public Random rand = new Random();
    public static final int WIDTH = 900;
    public static final int HEIGHT = 500;
    private static final int WAIT = 200;
    int counter1 = 0;
    boolean counter2 = false;
    BufferedImage magicWord;
    BufferedImage ahAhAh;
    ArrayList<BufferedImage> word = new ArrayList<>();

    ArrayList<BufferedImage> newman = new ArrayList<>();

    public Panelz() {

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.WHITE);

        try {
            newman.add(ImageIO.read(this.getClass().getResourceAsStream("/resources/newman frame 1.png")));
            newman.add(ImageIO.read(this.getClass().getResourceAsStream("/resources/newman frame 2.png")));
            newman.add(ImageIO.read(this.getClass().getResourceAsStream("/resources/newman frame 3.png")));
            magicWord = ImageIO.read(this.getClass().getResourceAsStream("/resources/you didnt say the magic word.png"));
            ahAhAh = ImageIO.read(this.getClass().getResourceAsStream("/resources/ah ah ah.png"));
            word.add(ahAhAh);
            word.add(magicWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (counter1 >= newman.size()) {
            counter1 = 0;
            counter2 = !counter2;
        }
        g.drawImage(newman.get(counter1), 0, 0, WIDTH, HEIGHT, null);
        if (counter2)
            g.drawImage(word.get(0), WIDTH - 300, 50, null);
        else
            g.drawImage(word.get(1), WIDTH - 300, 50, null);
        counter1++;

        try {

            Thread.sleep(WAIT);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.repaint();
    }
}
