package com.DynamicObjects;

import com.gui.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;

public class Human {
    private static int x;
    private static int y;
    private int HP;
    private int Damage;
    private final ImageIcon playerIcon = new ImageIcon();
    private static final int velocity = 1000;
    private static final Random random = new Random();
    private static final Timer timer = new Timer();
    private static final TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("X = " + x + " Y = " + y);
            move();
        }
    };

    public Human() {
        setPosition();
    }

    public static void move() {

        int deltaY, deltaX;
        int newX,newY;
        do {
            do {
                deltaY = random.nextInt(2);
                deltaX = random.nextInt(2);

                if (deltaY == 0 && deltaX == 0) {
                    deltaY = -1 + y;
                    deltaX = -1 + x;
                } else if (deltaY == 1 && deltaX == 1) {
                    deltaY = 1 + y;
                    deltaX = 1 + x;
                } else if (deltaY == 1 && deltaX == 0) {
                    deltaY = 1 + y;
                    deltaX = -1 + x;
                } else {
                    deltaY = -1 + y;
                    deltaX = 1 + x;
                }

                if (random.nextBoolean()) {
                    newX = deltaX;
                    newY = y;
                } else {
                    newX = x;
                    newY = deltaY;
                }
            } while (!GamePanel.checkOutOfBorder(newX, newY));
        } while (GamePanel.checkPosition(newX, newY));
        GamePanel.setObject(x,y,GamePanel.getBoardColor());
        x = newX;
        y = newY;
        GamePanel.setObject(x,y,Color.cyan);
    }
    public static void setPosition() {
        do {
            x = random.nextInt(GamePanel.getBoardSize());
            y = random.nextInt(GamePanel.getBoardSize());
        } while (GamePanel.checkPosition(x, y));
        GamePanel.setObject(x,y,Color.cyan);
    }
    public static void startMove() {
        timer.scheduleAtFixedRate(task,0,velocity);
    }
    public static void stopMove() {

    }
}
