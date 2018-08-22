package com.codecool.termlib;

import com.codecool.termlib.Field;

public class Game {
    static public boolean gameSubmitted = false;

    public static void startGame(Field[][] board){
        board[0][0].setSelected(true);
        while (!gameSubmitted){
            DisplayBoard.displayGameBoard(board);
            Controls.makeMove(board);
            Controls.correctInput = false;
        }
    }

    public static boolean checkBoard(Field[][] board){
        boolean gameWon = true;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column].getUserValue() != board[row][column].getCorrectValue()){
                    gameWon = false;
                    break;
                }
            }
        }
        return gameWon;
    }
}
