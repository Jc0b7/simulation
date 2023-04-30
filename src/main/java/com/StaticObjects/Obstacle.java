package com.StaticObjects;

import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Obstacle {

    private int x;
    private int y;

    private ImageIcon icon1;
    private ImageIcon icon2;

    private final Random random = new Random();

    public Obstacle() {
        icon1 = new ImageIcon("src/main/java/resources/forest.png");
        icon2 = new ImageIcon("src/main/java/resources/mountain.png");
    }

    public void setPosition() {
        int newX, newY;
        do {
            do {
                newX = random.nextInt(GamePanel.getBoardSize());
                newY = random.nextInt(GamePanel.getBoardSize());
            } while (GamePanel.checkOutOfBorder(newX, newY));
        } while (GamePanel.checkPosition(newX, newY));
        setX(newX);
        setY(newY);
        if(random.nextBoolean()) {
            GamePanel.setObject(getX(), getY(), icon1);
        } else {
            GamePanel.setObject(getX(), getY(), icon2);
        }
    }

    private int getY() {
        return y;
    }

    private int getX() {
        return  x;
    }

    private void setY(int newY) {
        y = newY;
    }

    private void setX(int newX) {
        x = newX;
    }
}
