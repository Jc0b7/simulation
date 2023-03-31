package com.StaticObjects;

import com.GUI.GamePanel;

import java.awt.*;
import java.util.Random;

public class Obstacle {
    
    private static int[] x;
    private static int[] y;
    static Random random = new Random();
    private static final Color OBSTACLE_COLOR = Color.GRAY;
    private static int amount;
    
    public Obstacle() {
        amount = random.nextInt(4) + GamePanel.getBoardSize()/2;
        x = new int[amount];
        y = new int[amount];
        setPosition();
    }
    public static void setPosition() {
        for (int i = 0; i < amount; i++) {
            do {
                x[i] = random.nextInt(GamePanel.getBoardSize());
                y[i] = random.nextInt(GamePanel.getBoardSize());
            } while (GamePanel.checkPosition(x[i], y[i]));
        }
        for (int i = 0; i < amount; i++) {
            GamePanel.setObject(x[i],y[i],OBSTACLE_COLOR);
        }
    }
}
