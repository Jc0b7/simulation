package com.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final int WIDTH = 1000;
    private final int HEIGHT = 900;

    public GamePanel() {
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
}
