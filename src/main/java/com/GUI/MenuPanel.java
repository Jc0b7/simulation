package com.GUI;

import com.GUI.menu.MenuButtons;
import com.GUI.menu.MenuStats;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final static int WIDTH = 400;
    private final static int HEIGHT = 900;
    private final static Color MENU_COLOR = Color.lightGray;

    public MenuPanel() {
        setBackground(MENU_COLOR);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new MenuStats());
        add(new MenuButtons());
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static Color getMenuColor() {
        return MENU_COLOR;
    }
}
