package com.DynamicObjects;

import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Human {
    private static int x;
    private static int y;
    private int hp = 100;
    private int damage;
    private final static Color HUMAN_COLOR = new Color(208,184,66);
    private static final int velocity = 375;
    private static final Random random = new Random();
    private static final Timer timer = new Timer(velocity, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            move();
            System.out.println("X = " + x + " Y = " + y);
        }
    });


    public Human() {
        setDamage(10);
        setHp(100);
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
                } else if (deltaY == 0) {
                    deltaY = 1 + y;
                    deltaX = -1 + x;
                } else {
                    deltaY = -1 + y;
                    deltaX = 1 + x;
                }
                if(random.nextBoolean()) {
                    if (random.nextBoolean()) {
                        newX = deltaX;
                        newY = y;
                    } else {
                        newX = x;
                        newY = deltaY;
                    }
                } else {
                    newX = deltaX;
                    newY = deltaY;
                }
            } while (GamePanel.checkOutOfBorder(newX, newY));
        } while (GamePanel.checkPosition(newX, newY, getHumanColor()));
        GamePanel.setObject(x,y,GamePanel.getBoardColor());
        x = newX;
        y = newY;
        GamePanel.setObject(x,y,HUMAN_COLOR);
    }
    public static void setPosition() {
        do {
            x = random.nextInt(GamePanel.getBoardSize());
            y = random.nextInt(GamePanel.getBoardSize());
        } while (GamePanel.checkPosition(x, y, Zombie.getZombieColor()));
        GamePanel.setObject(x,y,HUMAN_COLOR);
    }
    public static void startMove() {
        timer.start();
    }
    public static void stopMove() {
        timer.stop();
    }
    public int getHp() {
        return hp;
    }
    public void addHP(int hp) {
        this.hp += hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public static Color getHumanColor() {
        return HUMAN_COLOR;
    }
}
