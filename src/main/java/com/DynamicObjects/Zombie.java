package com.DynamicObjects;

import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;


import java.util.Random;


public class Zombie {
    private static int[] x;
    private static int[] y;
    private static final Color ZOMBIE_COLOR = new Color(152,252,131);
    private static final int amount = 4;
    private static final int velocity = 750;
    private static final Random random = new Random();
    private static final Timer timer = new Timer(velocity, e -> move());

    public Zombie() {
        x = new int[amount];
        y = new int[amount];
        setPosition();
    }
    public static void move() {
        int[] deltaY = new int[amount];
        int[] deltaX = new int[amount];
        int[] newX = new int[amount];
        int[] newY = new int[amount];

            for (int i = 0; i < amount; i++) {
                do {
                    do {
                        deltaY[i] = random.nextInt(2);
                        deltaX[i] = random.nextInt(2);

                        if (deltaY[i] == 0 && deltaX[i] == 0) {
                            deltaY[i] = -1 + y[i];
                            deltaX[i] = -1 + x[i];
                        } else if (deltaY[i] == 1 && deltaX[i] == 1) {
                            deltaY[i] = 1 + y[i];
                            deltaX[i] = 1 + x[i];
                        } else if (deltaY[i] == 1 && deltaX[i] == 0) {
                            deltaY[i] = 1 + y[i];
                            deltaX[i] = -1 + x[i];
                        } else {
                            deltaY[i] = -1 + y[i];
                            deltaX[i] = 1 + x[i];
                        }

                        if(random.nextBoolean()) {
                            if (random.nextBoolean()) {
                                newX[i] = deltaX[i];
                                newY[i] = y[i];
                            } else {
                                newX[i] = x[i];
                                newY[i] = deltaY[i];
                            }
                        } else {
                            newX[i] = deltaX[i];
                            newY[i] = deltaY[i];
                        }
                    } while (GamePanel.checkOutOfBorder(newX[i], newY[i]));
                } while (GamePanel.checkPosition(newX[i], newY[i]));
                GamePanel.setObject(x[i], y[i], GamePanel.getBoardColor());
                x[i] = newX[i];
                y[i] = newY[i];
                GamePanel.setObject(x[i], y[i], ZOMBIE_COLOR);
            }
    }
    public static void setPosition() {
        for (int i = 0; i < amount; i++) {
            do {
                x[i] = random.nextInt(GamePanel.getBoardSize());
                y[i] = random.nextInt(GamePanel.getBoardSize());
            } while (GamePanel.checkPosition(x[i], y[i]));
            GamePanel.setObject(x[i], y[i], ZOMBIE_COLOR);
        }
    }
    public static void startMove() {
        timer.start();
    }
    public static void stopMove() {
        timer.stop();
    }
}