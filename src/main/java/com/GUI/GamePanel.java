package com.GUI;

import com.GUI.menu.Settings;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static int boardSize = 8;
    private static final Color boardColor = Color.white;
    private static final JButton[][] board = new JButton[boardSize][boardSize];
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 900;

    public GamePanel() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setLayout(new GridLayout(boardSize, boardSize, 3, 3));

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new JButton();
                board[i][j].setBackground(boardColor);
                board[i][j].setBorderPainted(false);
                board[i][j].setFocusPainted(false);
                add(board[i][j]);
            }
        }
    }

    public static int getBoardSize() {
        return boardSize;
    }

    public static boolean checkPosition(int x, int y) {
        return board[x][y].getIcon() != null;
    }

    public static boolean checkPosition(int x, int y, Color color) {
        return board[x][y].getBackground() != boardColor && board[x][y].getBackground() != color;
    }

    public static boolean checkOutOfBorder(int x, int y) {
        return (x < 0 || y < 0 || y >= boardSize || x >= boardSize);
    }

    public static void setObject(int x, int y, ImageIcon icon) {
        board[x][y].setIcon(icon);
    }

    public static Color getBoardColor() {
        return boardColor;
    }

    public static void resetBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j].setIcon(null);
            }
        }
    }

    public static void setBoardSize(int boardSize) {
        GamePanel.boardSize = boardSize;
    }
}
