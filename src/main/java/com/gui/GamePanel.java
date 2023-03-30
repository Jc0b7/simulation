package com.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int boardSize = 12;

    private final JPanel[][] board = new JPanel[boardSize][boardSize];
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 900;

    public GamePanel() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setLayout(new GridLayout(boardSize,boardSize,6,6));

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new JPanel();
                board[i][j].setBackground(Color.white);
                add(board[i][j]);
            }
        }

    }
}
