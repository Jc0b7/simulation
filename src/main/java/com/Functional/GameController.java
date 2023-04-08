package com.Functional;

public class GameController {

    private static GameController instance = null;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
    }

    public void restart() {

    }

    public void startMove() {

    }

    public void stopMove() {
    }
}
