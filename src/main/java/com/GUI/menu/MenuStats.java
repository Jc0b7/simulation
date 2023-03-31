package com.GUI.menu;

import com.GUI.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MenuStats extends JPanel {

    private final int WIDTH = 400;
    private final int HEIGHT = 300;

    public MenuStats() {
        setBackground(MenuPanel.getMenuColor());
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
}
