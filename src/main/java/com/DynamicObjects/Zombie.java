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
    private ArrayList<Integer> hp;
    private ArrayList<Integer> damage;
    private static final Color ZOMBIE_COLOR = new Color(152,252,131);
    private static final int amount = 4;
    private static final int velocity = 750;
    private static final Random random = new Random();
    private static final Timer timer = new Timer(velocity, e -> move());

    public Zombie() {
        hp = new ArrayList<>(amount);
        damage = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            setHp(30, i);
            setDamage(5, i);
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
                GamePanel.setObject(x.get(i), y.get(i), GamePanel.getBoardColor());
                x.set(i, newX[i]);
                y.set(i, newY[i]);
                GamePanel.setObject(x.get(i), y.get(i), ZOMBIE_COLOR);
            }
    }
    public static void setPosition() {
        for (int i = 0; i < amount; i++) {
            do {
                x.set(i, random.nextInt(GamePanel.getBoardSize()));
                y.set(i, random.nextInt(GamePanel.getBoardSize()));
            } while (GamePanel.checkPosition(x.get(i), y.get(i), Human.getHumanColor()));
            GamePanel.setObject(x.get(i), y.get(i), ZOMBIE_COLOR);
        }
    }
    public static void startMove() {
        timer.start();
    }
    public static void stopMove() {
        timer.stop();
    }
    public void addHP(int hp, int i) {
        this.hp.set(i, getHP(i) + hp);
    }
    public int getHP(int i) {
        return this.hp.get(i);
    }
    public void setHp(int hp, int i) {
        this.hp.set(i, hp);
    }
    public void setDamage(int damage, int i) {
        this.damage.set(i, damage);
    }
    public int getDamage(int i) {
        return this.damage.get(i);
    }

    public static Color getZombieColor() {
        return ZOMBIE_COLOR;
    }

    public void attack(Human human) {
        for (int i = 0; i < amount; i++) {
            if(x.get(i) == human.getX() && y.get(i) == human.getY()) {
                while (human.getHp() > 0) {
                    addHP(-human.getDamage(),i);
                    human.addHP(-getDamage(i));
                }
                if(human.getHp() < 0) {
                    GameController.stopMove();
                } else {
                    x.remove(i);
                    y.remove(i);
                    hp.remove(i);
                    damage.remove(i);
                }
                break;
            }
        }
    }
}