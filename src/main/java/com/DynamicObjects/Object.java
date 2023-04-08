package com.DynamicObjects;

import javax.swing.*;
import java.util.Random;

public abstract class Object {
    protected int x;
    protected int y;
    protected int dmg;
    protected int hp;
    protected int gold;
    protected int velocity;
    protected final Random random = new Random();
    protected static ImageIcon icon;
    protected Timer action;

    abstract public void setPosition();

    abstract public void move();

    abstract public void start();

    abstract public void stop();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public int getDmg() {
        return dmg;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
