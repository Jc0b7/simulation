package com.gui;

import com.gui.menu.MenuButtons;
import com.gui.menu.MenuStats;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final static int WIDTH = 400;
    private final static int HEIGHT = 900;

    public MenuPanel() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        add(new MenuStats());
        add(new MenuButtons());
    }

    static public int getWIDTH() {
        return WIDTH;
    }
}
