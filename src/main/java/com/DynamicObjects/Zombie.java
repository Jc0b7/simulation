package com.DynamicObjects;

import com.Functional.GameController;
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
    private static final Color ZOMBIE_COLOR = new Color(152,252,131);
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
                            deltaY[i] = -1 + y.get(i);
                            deltaX[i] = -1 + x.get(i);
                        } else if (deltaY[i] == 1 && deltaX[i] == 1) {
                            deltaY[i] = 1 + y.get(i);
                            deltaX[i] = 1 + x.get(i);
                        } else if (deltaY[i] == 1 && deltaX[i] == 0) {
                            deltaY[i] = 1 + y.get(i);
                            deltaX[i] = -1 + x.get(i);
                        } else {
                            deltaY[i] = -1 + y.get(i);
                            deltaX[i] = 1 + x.get(i);
                        }

                        if(random.nextBoolean()) {
                            if (random.nextBoolean()) {
                                newX[i] = deltaX[i];
                                newY[i] = y.get(i);
                            } else {
                                newX[i] = x.get(i);
                                newY[i] = deltaY[i];
                            }
                        } else {
                            newX[i] = deltaX[i];
                            newY[i] = deltaY[i];
                        }
                    } while (GamePanel.checkOutOfBorder(newX[i], newY[i]));
                } while (GamePanel.checkPosition(newX[i], newY[i], Human.getHumanColor()));
                for (int j = 0; j < amount; j++) {
                    if(x.get(j) == Human.getX() && y.get(j) == Human.getY()) {
                        while (Human.getHp() > 0) {
                            addHP(-Human.getDamage(), j);
                            Human.addHP(-getDamage(j));
                        }
                        if(Human.getHp() < 0) {
                            GameController.stopMove();
                        } else {
                            GamePanel.setObject(x.get(j), y.get(j), GamePanel.getBoardColor());
                            x.remove(j);
                            y.remove(j);
                            hp.remove(j);
                            damage.remove(j);
                        }
                        break;
                    }
                }
                GamePanel.setObject(x.get(i), y.get(i), GamePanel.getBoardColor());
                x.set(i, newX[i]);
                y.set(i, newY[i]);
                GamePanel.setObject(x.get(i), y.get(i), ZOMBIE_COLOR);
            }
    }
    public static void setPosition() {
        for (int i = 0; i < amount; i++) {
            do {
                x.add(random.nextInt(GamePanel.getBoardSize()));
                y.add(random.nextInt(GamePanel.getBoardSize()));
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