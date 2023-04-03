package com.Functional;

import com.DynamicObjects.Human;
import com.DynamicObjects.Zombie;
import com.GUI.GamePanel;
import com.StaticObjects.Obstacle;

public class GameController {


    public GameController() {
        new Human();
        new Zombie();
        new Obstacle();
    }

    public static void restart() {
        GamePanel.resetBoard();
        stopMove();
        Human.setPosition();
        Zombie.setPosition();
        Obstacle.setPosition();
    }

    public static void startMove() {
        Zombie.startMove();
        Human.startMove();
    }

    public static void stopMove() {
        Human.stopMove();
        Zombie.stopMove();
    }
}
