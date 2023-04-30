package com.GUI.menu;

import com.Functional.GameController;
import com.GUI.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtons extends JPanel implements ActionListener {

    private final int BUTTON_WIDTH = 310;
    private final int BUTTON_HEIGHT = 50;
    private final JButton reset;
    private final JButton start;
    private final JButton settings;
    private final JButton license;
    private final Color BUTTON_COLOR = Color.white;

    public MenuButtons() {
        setBackground(MenuPanel.getMenuColor());
        setLayout(new FlowLayout(FlowLayout.CENTER, MenuPanel.getWIDTH() / 4, 30));

        start = new JButton("START");
        reset = new JButton("RESTART");
        settings = new JButton("SETTINGS");
        license = new JButton("LICENSE");


        start.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        reset.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        settings.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        license.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        start.setBackground(BUTTON_COLOR);
        reset.setBackground(BUTTON_COLOR);
        settings.setBackground(BUTTON_COLOR);
        license.setBackground(BUTTON_COLOR);

        start.setFocusPainted(false);
        reset.setFocusPainted(false);
        settings.setFocusPainted(false);
        license.setFocusPainted(false);

        start.addActionListener(this);
        reset.addActionListener(this);
        settings.addActionListener(this);


        add(start);
        add(reset);
        add(settings);
        add(license);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameController game = GameController.getInstance();
        if (e.getSource() == reset) {
            game.restart();
        } else if (e.getSource() == settings) {
            new Settings();
        } else if (e.getSource() == license) {
        } else if (e.getSource() == start) {
            game.startMove();
        }
    }
}
