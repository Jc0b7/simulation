package com.gui.menu;

import com.gui.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MenuStats extends JPanel {

    private int WIDTH = 400;
    private int HEIGHT = 300;


    public MenuStats() {
        setBackground(MenuPanel.getMenuColor());
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }
}
