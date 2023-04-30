package com.Functional;

import com.DynamicObjects.*;
import com.DynamicObjects.enemies.*;
import com.GUI.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameController implements ActionListener {

    private int zombieAmount = 5;
    private int humanAmount = 1;
    private ArrayList<Human> human = new ArrayList<>(humanAmount);
    private ArrayList<Entity> entities = new ArrayList<>(zombieAmount);
    private final Timer timer = new Timer(0, this);
    private static GameController instance = null;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        start();
    }


    public void restart() {
        stopMove();
        GamePanel.resetBoard();
        start();
    }

    public void start() {
        for (int i = 0; i < humanAmount; i++) {
            human.add(new Human(10, 100));
            human.get(i).setPosition();
        }
        zombieAmount = 5;
        for (int i = 0; i < zombieAmount; i++) {
            entities.add(new Zombie(0, 0));
            entities.get(i).setPosition();
        }
    }

    public void startMove() {
        for (int i = 0; i < humanAmount; i++) {
            human.get(i).start();
        }
        for (int i = 0; i < zombieAmount; i++) {
            entities.get(i).start();
        }
        timer.start();
    }

    public void stopMove() {
        for (int i = 0; i < humanAmount; i++) {
            human.get(i).stop();
        }
        for (int i = 0; i < zombieAmount; i++) {
            entities.get(i).stop();
        }
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
