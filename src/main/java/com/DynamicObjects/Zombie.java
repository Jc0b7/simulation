package com.DynamicObjects;


import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;
import java.util.Random;


public class Zombie {
    private static ArrayList<Integer> x;
    private static ArrayList<Integer> y;
    private static ArrayList<Integer> hp;
    private static ArrayList<Integer> damage;
    private static final Color ZOMBIE_COLOR = new Color(152, 252, 131);
    private static final int amount = 4;
    private static final int velocity = 750;
    private static final Random random = new Random();
    private static final Timer timer = new Timer(velocity, e -> move());

    public Zombie() {
        hp = new ArrayList<>(amount);
        damage = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            hp.add(30);
            damage.add(5);
        }
        x = new ArrayList<>(amount);
        y = new ArrayList<>(amount);
        setPosition();
    }

    public static void move() {
        int[] newY = new int[amount];
        int[] newX = new int[amount];
        int rand;

        // generate moves
        for (int i = 0; i < x.size(); i++) {
            do {
                do {
                    // random the moves
                    rand = random.nextInt(8) + 1;
                    switch (rand) {
                        case 1 -> {
                            newY[i] = -1 + y.get(i);
                            newX[i] = -1 + x.get(i);
                        }
                        case 2 -> {
                            newY[i] = 1 + y.get(i);
                            newX[i] = 1 + x.get(i);
                        }
                        case 3 -> {
                            newY[i] = 1 + y.get(i);
                            newX[i] = -1 + x.get(i);
                        }
                        case 4 -> {
                            newY[i] = -1 + y.get(i);
                            newX[i] = 1 + x.get(i);
                        }
                        case 5 -> {
                            newY[i] = -1 + y.get(i);
                            newX[i] = x.get(i);
                        }
                        case 6 -> {
                            newY[i] = 1 + y.get(i);
                            newX[i] = x.get(i);
                        }
                        case 7 -> {
                            newY[i] = y.get(i);
                            newX[i] = -1 + x.get(i);
                        }
                        case 8 -> {
                            newY[i] = y.get(i);
                            newX[i] = 1 + x.get(i);
                        }
                    }
                } while (GamePanel.checkOutOfBorder(newX[i], newY[i]));
            } while (GamePanel.checkPosition(newX[i], newY[i], Human.getHumanColor()));

            // set new [X,Y]
            GamePanel.setObject(x.get(i), y.get(i), GamePanel.getBoardColor());
            x.set(i, newX[i]);
            y.set(i, newY[i]);
            // collision
            if (x.get(i) == Human.getX() && y.get(i) == Human.getY()) {
                x.remove(i);
                y.remove(i);
                System.out.println(x.size());
            } else {
                // move graphical object to new [X,Y]
                GamePanel.setObject(x.get(i), y.get(i), ZOMBIE_COLOR);
            }
        }
    }
    public static void setPosition() {
        x.clear();
        y.clear();
        for (int i = 0; i < amount; i++) {
            x.add(0);
            y.add(0);
        }
        for (int i = 0; i < amount; i++) {
            do {
                x.set(i, random.nextInt(GamePanel.getBoardSize()));
                y.set(i, random.nextInt(GamePanel.getBoardSize()));
            } while (GamePanel.checkPosition(x.get(i), y.get(i)));
            GamePanel.setObject(x.get(i), y.get(i), ZOMBIE_COLOR);
        }
    }
    public static void startMove() {
        timer.start();
    }
    public static void stopMove() {
        timer.stop();
    }
    public static void addHP(int hp, int i) {
        Zombie.hp.set(i, getHP(i) + hp);
    }
    public static int getHP(int i) {
        return Zombie.hp.get(i);
    }
    public void setHp(int hp, int i) {
        this.hp.set(i, hp);
    }
    public void setDamage(int damage, int i) {
        this.damage.set(i, damage);
    }
    public static int getDamage(int i) {
        return Zombie.damage.get(i);
    }
    public static Color getZombieColor() {
        return ZOMBIE_COLOR;
    }

}