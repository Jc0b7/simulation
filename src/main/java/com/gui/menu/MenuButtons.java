package com.gui.menu;

import com.DynamicObjects.Human;
import com.gui.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtons extends JPanel implements ActionListener {

    private final int BUTTON_WIDTH = 310;
    private final int BUTTON_HEIGHT = 50;
    private final Button reset;
    private final Button start;
    private final Button settings;
    private final Button license;

    public MenuButtons() {
        setBackground(MenuPanel.getMenuColor());
        setLayout(new FlowLayout(FlowLayout.CENTER, MenuPanel.getWIDTH()/4,30));
        
        start = new Button("START");
        reset = new Button("RESTART");
        settings = new Button("SETTINGS");
        license = new Button("LICENSE");

        start.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        reset.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        settings.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        license.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        
        start.setBackground(Color.LIGHT_GRAY);
        reset.setBackground(Color.LIGHT_GRAY);
        settings.setBackground(Color.LIGHT_GRAY);
        license.setBackground(Color.LIGHT_GRAY);

        start.addActionListener(this);

        add(start);
        add(reset);
        add(settings);
        add(license);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset) {

        } else if (e.getSource() == settings) {

        } else if (e.getSource() == license) {

        } else if (e.getSource() == start) {
            Human.startMoving();
        }
    }
}
