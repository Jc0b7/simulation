package com.player;

import com.gui.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Player {
    private int PlayerX;
    private int PlayerY;
    private int HP;
    private int Damage;
    private final ImageIcon playerIcon = new ImageIcon();

    public Player() {
        setPosition();
    }

    public void move() {

    }
    public void setPosition() {
        Random random = new Random();
        PlayerX = random.nextInt(GamePanel.getBoardSize());
        PlayerY = random.nextInt(GamePanel.getBoardSize());
        while (!GamePanel.freePosition(PlayerX, PlayerY)) {
            PlayerX = random.nextInt(GamePanel.getBoardSize());
            PlayerY = random.nextInt(GamePanel.getBoardSize());
        }
        GamePanel.setObject(PlayerX,PlayerY,Color.cyan);
    }

}
