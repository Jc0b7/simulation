package com.GUI.menu;

import com.Functional.GameController;
import com.GUI.GamePanel;
import com.GUI.MenuPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements ChangeListener, ActionListener {

    private static int boardValue = 9;
    private static int humanValue = 2;
    private static int obstacleValue = 8;
    private static JSlider boardSlider;
    private static JSlider humanSlider;
    private static JSlider obstacleSlider;
    private static JLabel boardText;
    private static JLabel humanText;
    private static JLabel obstacleText;

    private static JButton save;

    public Settings() {
        setResizable(false);
        setVisible(true);
        setBackground(Color.lightGray);
        setLocation(505,400);
        setSize(500,500);

        save = new JButton("Save");
        save.setPreferredSize(new Dimension(155,50));

        boardSlider = new JSlider(8,12);
        humanSlider = new JSlider(1,3);
        obstacleSlider = new JSlider(8,16);

        boardSlider.setMajorTickSpacing(1);
        boardSlider.setPaintTicks(true);
        humanSlider.setMajorTickSpacing(1);
        humanSlider.setPaintTicks(true);
        obstacleSlider.setMajorTickSpacing(1);
        obstacleSlider.setPaintTicks(true);

        boardText = new JLabel();
        humanText = new JLabel();
        obstacleText = new JLabel();

        setLayout(new FlowLayout(FlowLayout.CENTER, MenuPanel.getWIDTH() / 3, 30));
        add(boardText);
        add(boardSlider);
        add(humanText);
        add(humanSlider);
        add(obstacleText);
        add(obstacleSlider);
        add(save);

        humanSlider.addChangeListener(this);
        boardSlider.addChangeListener(this);
        obstacleSlider.addChangeListener(this);

        save.addActionListener(this);

        boardText.setText("Board Size = " + boardSlider.getValue());
        humanText.setText("Amount of humans = " + humanSlider.getValue());
        obstacleText.setText("Amount of obstacles = " + obstacleSlider.getValue());

    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == boardSlider) {
            boardText.setText("Board Size = " + boardSlider.getValue());
        } else if (e.getSource() == humanSlider) {
            humanText.setText("Amount of humans = " + humanSlider.getValue());
        } else if (e.getSource() == obstacleSlider) {
            obstacleText.setText("Amount of obstacles = " + obstacleSlider.getValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            GameController game = GameController.getInstance();
            GamePanel.setBoardSize(boardSlider.getValue());
            GameController.setHumanAmount(humanSlider.getValue());
            GameController.setObstacleAmount(obstacleSlider.getValue());
            super.dispose();
            new GamePanel();

        }
    }

    public static int getBoardValue() {
        return boardValue;
    }

    public static int getHumanValue() {
        return humanValue;
    }

    public static int getObstacleValue() {
        return obstacleValue;
    }
}
