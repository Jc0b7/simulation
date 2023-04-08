package com.DynamicObjects.enemies;

import com.DynamicObjects.Entity;
import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zombie extends Entity implements ActionListener {

    private final Color ZOMBIE = Color.green;

    public Zombie(int dmg, int hp) {
        setDmg(dmg);
        setHp(hp);
        setVelocity(750);
        setGold(100);
        action = new Timer(velocity,this);
    }


    @Override
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
        GamePanel.setObject(getX(), getY(), ZOMBIE);
    }

    @Override
    public void move() {
        int newX = 0, newY = 0;
        int choice;
        do {
            do {
                choice = random.nextInt(8) + 1;
                switch (choice) {
                    case 1 -> {
                        newX = getX() + 1;
                        newY = getY() + 1;
                    }
                    case 2 -> {
                        newX = getX() - 1;
                        newY = getY() - 1;
                    }
                    case 3 -> {
                        newX = getX();
                        newY = getY() + 1;
                    }
                    case 4 -> {
                        newX = getX() + 1;
                        newY = getY();
                    }
                    case 5 -> {
                        newX = getX() - 1;
                        newY = getY();
                    }
                    case 6 -> {
                        newX = getX();
                        newY = getY() - 1;
                    }
                    case 7 -> {
                        newX = getX() + 1;
                        newY = getY() - 1;
                    }
                    case 8 -> {
                        newX = getX() - 1;
                        newY = getY() + 1;
                    }
                }
            } while (GamePanel.checkOutOfBorder(newX, newY));
        } while (GamePanel.checkPosition(newX, newY));
        GamePanel.setObject(getX(), getY(), GamePanel.getBoardColor());
        setX(newX);
        setY(newY);
        GamePanel.setObject(getX(), getY(), ZOMBIE);
    }

    @Override
    public void start() {
        action.start();
    }

    @Override
    public void stop() {
        action.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }
}
