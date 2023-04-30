package com.StaticObjects;

import com.GUI.GamePanel;

import java.awt.*;
import java.util.Random;

public class Obstacle {

    private int x;
    private int y;

    public void setPosition() {
        Random random = new Random();
        x = random.nextInt(GamePanel.getBoardSize());
        y = random.nextInt(GamePanel.getBoardSize());
    }
}
