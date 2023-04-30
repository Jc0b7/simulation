package com.DynamicObjects.enemies;

import com.DynamicObjects.Entity;
import com.DynamicObjects.Human;
import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zombie extends Entity implements ActionListener {

    private static final Color ZOMBIE = Color.green;

    public Zombie(int dmg, int hp) {
        setDmg(dmg);
        setHp(hp);
        setVelocity(750);
        setGold(100);
        action = new Timer(velocity,this);
        icon = new ImageIcon("src/main/java/resources/zombie.png");
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
        GamePanel.setObject(getX(), getY(), icon);
    }

    @Override
    public void move() {
        int choice;
        do {
            do {
                choice = random.nextInt(8) + 1;
                switch (choice) {
                    case 1 -> {
                        setChangeX(getX() + 1);
                        setChangeY(getY() + 1);
                    }
                    case 2 -> {
                        setChangeX(getX() - 1);
                        setChangeY(getY() - 1);
                    }
                    case 3 -> {
                        setChangeX(getX());
                        setChangeY(getY() + 1);
                    }
                    case 4 -> {
                        setChangeX(getX() + 1);
                        setChangeY(getY());
                    }
                    case 5 -> {
                        setChangeX(getX() - 1);
                        setChangeY(getY());
                    }
                    case 6 -> {
                        setChangeX(getX());
                        setChangeY(getY() - 1);
                    }
                    case 7 -> {
                        setChangeX(getX() + 1);
                        setChangeY(getY() - 1);
                    }
                    case 8 -> {
                        setChangeX(getX() - 1);
                        setChangeY(getY() + 1);
                    }
                }
            } while (GamePanel.checkOutOfBorder(changeX, changeY));
        } while (GamePanel.checkPosition(changeX, changeY));
        GamePanel.setObject(getX(), getY(), null);
        setX(changeX);
        setY(changeY);
        GamePanel.setObject(getX(), getY(), icon);
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

    public static Color getZOMBIE() {
        return ZOMBIE;
    }
}
