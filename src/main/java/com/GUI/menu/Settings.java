package com.GUI.menu;

import com.Functional.GameController;
import com.GUI.MenuPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Settings extends JFrame implements ChangeListener {


    private static JSlider boardSize;
    private static JSlider humanAmount;
    private static JSlider obstacleAmount;
    private static JLabel boardSet;
    private static JLabel humanSet;
    private static JLabel obstacleSet;

    private static JButton save;

    public Settings() {
        setResizable(false);
        setVisible(true);
        setBackground(Color.lightGray);
        setLocation(505,400);
        setSize(500,500);

        save = new JButton("Save");
        save.setPreferredSize(new Dimension(155,50));

        boardSize = new JSlider(8,12);
        humanAmount = new JSlider(1,3);
        obstacleAmount = new JSlider(8,16);

        boardSize.setMajorTickSpacing(1);
        boardSize.setPaintTicks(true);
        humanAmount.setMajorTickSpacing(1);
        humanAmount.setPaintTicks(true);
        obstacleAmount.setMajorTickSpacing(1);
        obstacleAmount.setPaintTicks(true);

        boardSet = new JLabel();
        humanSet = new JLabel();
        obstacleSet = new JLabel();

        setLayout(new FlowLayout(FlowLayout.CENTER, MenuPanel.getWIDTH() / 3, 30));
        add(boardSet);
        add(boardSize);
        add(humanSet);
        add(humanAmount);
        add(obstacleSet);
        add(obstacleAmount);
        add(save);

        humanAmount.addChangeListener(this);
        boardSize.addChangeListener(this);
        obstacleAmount.addChangeListener(this);

        boardSet.setText("Board Size = " + boardSize.getValue());
        humanSet.setText("Amount of humans = " + humanAmount.getValue());
        obstacleSet.setText("Amount of obstacles = " + obstacleAmount.getValue());

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == boardSize) {
            boardSet.setText("Board Size = " + boardSize.getValue());
        } else if (e.getSource() == humanAmount) {
            humanSet.setText("Amount of humans = " + humanAmount.getValue());
        } else if (e.getSource() == obstacleAmount) {
            obstacleSet.setText("Amount of obstacles = " + obstacleAmount.getValue());
        }
    }
}
