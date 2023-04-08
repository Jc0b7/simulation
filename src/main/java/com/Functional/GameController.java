package com.Functional;

import com.DynamicObjects.*;
import com.DynamicObjects.enemies.*;
import com.GUI.GamePanel;

public class GameController {

    private final Human[] human = new Human[3];
    private final Entity[] entities = new Entity[6];
    private static GameController instance = null;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        for (int i = 0; i < 3; i++) {
            human[i] = new Human(0, 100);
            human[i].setPosition();
        }
        for (int i = 0; i < 6; i++) {
            entities[i] = new Zombie(0, 0);
            entities[i].setPosition();
        }
    }

    public void restart() {
        stopMove();
        GamePanel.resetBoard();
        for (int i = 0; i < 3; i++) {
            human[i].setPosition();
        }
        for (int i = 0; i < 6; i++) {
            entities[i].setPosition();
        }
    }

    public void startMove() {
        for (int i = 0; i < 3; i++) {
            human[i].start();
        }
        for (int i = 0; i < 6; i++) {
            entities[i].start();
        }
    }

    public void stopMove() {
        for (int i = 0; i < 3; i++) {
            human[i].stop();
        }
        for (int i = 0; i < 6; i++) {
            entities[i].stop();
        }
    }
}
