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
        int choice;
        do {
            do {
                choice = random.nextInt(8) + 1;
                switch (choice) {
                    case 1 -> {
                        changeX = getX() + 1;
                        changeY = getY() + 1;
                    }
                    case 2 -> {
                        changeX = getX() - 1;
                        changeY = getY() - 1;
                    }
                    case 3 -> {
                        changeX = getX();
                        changeY = getY() + 1;
                    }
                    case 4 -> {
                        changeX = getX() + 1;
                        changeY = getY();
                    }
                    case 5 -> {
                        changeX = getX() - 1;
                        changeY = getY();
                    }
                    case 6 -> {
                        changeX = getX();
                        changeY = getY() - 1;
                    }
                    case 7 -> {
                        changeX = getX() + 1;
                        changeY = getY() - 1;
                    }
                    case 8 -> {
                        changeX = getX() - 1;
                        changeY = getY() + 1;
                    }
                }
            } while (GamePanel.checkOutOfBorder(changeX, changeY));
        } while (GamePanel.checkPosition(changeX, changeY, Human.getHUMAN()));
        GamePanel.setObject(getX(), getY(), GamePanel.getBoardColor());
        setX(changeX);
        setY(changeY);
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

    public static Color getZOMBIE() {
        return ZOMBIE;
    }
}
