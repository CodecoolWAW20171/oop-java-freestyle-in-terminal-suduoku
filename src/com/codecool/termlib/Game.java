package com.codecool.termlib;

public class Game {
    static public boolean gameSubmitted = false;

    public static void startGame(Field[][] board, String[] buttonNameList){
        board[0][0].setSelected(true);
        Buttons[] buttonList = Controls.createButtons(buttonNameList);
        while (!gameSubmitted){
            DisplayBoard.clearScreen();
            DisplayBoard.displayGameBoard(board);
            DisplayBoard.displayButtons(buttonList);
            Controls.makeMove(board);
//            System.out.println(Controls.xPosition);
//            System.out.println(Controls.yPosition);
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
