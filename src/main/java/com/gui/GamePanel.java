package com.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 900;

    public GamePanel() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));


    }
}

