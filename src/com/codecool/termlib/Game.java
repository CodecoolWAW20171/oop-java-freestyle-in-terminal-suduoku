package com.codecool.termlib;

import java.io.IOException;

public class Game {
    public static boolean isGameSubmitted() {
        return gameSubmitted;
    }

    static void setGameSubmitted(boolean gameSubmitted) {
        Game.gameSubmitted = gameSubmitted;
    }

    static boolean gameSubmitted = false;

    static void startGame(Field[][] board, String[] buttonNameList) throws IOException {
        board[0][0].setSelected(true);
        Buttons[] buttonList = Controls.createButtons(buttonNameList);
        while (!gameSubmitted){
            DisplayBoard.clearScreen();
            DisplayBoard.displayGameBoard(board);
            DisplayBoard.displayButtons(buttonList);
            Controls.makeMove(board);
            Controls.correctInput = false;
        }
        if (gameWon(board)){
            UI.youWon(board);
        } else {
            UI.youLost(board);
        }
        System.in.read();
    }

    private static boolean gameWon(Field[][] board){
        boolean gameWon = true;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column].getUserValue() != board[row][column].getCorrectValue()){
                    gameWon = false;
                    break;
                }
            }
        }
        gameSubmitted = true;
        return gameWon;
    }

    static void discoverBoard(Field[][] board) {
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setUserValue(board[i][j].getCorrectValue());
            }
        }
    }

    static void resetBoard(Field[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].isEditable()) {
                    board[i][j].setUserValue(0);
                }
            }
        }
    }

    static void giveAHint(Field[][] board) {
        boolean validHint = true;
        if (hasSpace(board)) {
            do {
                int randomY = (int) Math.floor(Math.random() * 9);
                int randomX = (int) Math.floor(Math.random() * 9);
                Field randomField = board[randomY][randomX];
                validHint = randomField.isEditable() && (randomField.getUserValue() == 0);
                randomField.setUserValue(randomField.getCorrectValue());
            } while (!validHint);
        }
    }

    private static boolean hasSpace(Field[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].getUserValue() == 0){
                    return true;
                }
            }
        }
        return false;
    }

    static void quit() {
        System.exit(0);
    }
}
