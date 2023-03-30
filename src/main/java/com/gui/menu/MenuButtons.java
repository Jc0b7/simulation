package com.gui.menu;

import com.gui.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtons extends JPanel implements ActionListener {

    private final int BUTTON_WIDTH = 275;
    private final int BUTTON_HEIGHT = 75;
    private final Button reset;
    private final Button settings;
    private final Button license;

    public MenuButtons() {
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, MenuPanel.getWIDTH()/4,30));

        reset = new Button("Restart");
        settings = new Button("Settings");
        license = new Button("License");

        reset.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        settings.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        license.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));

        reset.setBackground(Color.LIGHT_GRAY);
        settings.setBackground(Color.LIGHT_GRAY);
        license.setBackground(Color.LIGHT_GRAY);

        add(reset);
        add(settings);
        add(license);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset) {

        } else if (e.getSource() == settings) {

        } else if (e.getSource() == license) {

        }
    }
}
