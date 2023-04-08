package com.GUI;


import com.Functional.GameController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        super("Last Existence");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(50, 50);
        setVisible(true);
        setBackground(Color.black);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        add(new GamePanel());
        add(new MenuPanel());
        pack();
    }


    public static void main(String[] args) {
        new MainFrame();
        GameController.getInstance();
    }
}