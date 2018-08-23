package com.codecool.termlib;

import java.util.LinkedList;

public class Utils {


    public static int getRandomNumber (int range){
        int number = (int) (Math.random() * range);
        return number;
    }

    public static int[][][] getRandomBoardSet(LinkedList<int[][][]> listOfBoards, int number){
        int[][][] randomBoardSet = listOfBoards.get(number);
        return randomBoardSet;
    }

    public static int[][] getEmptyBoard(int [][][] randomBoardSet){
        int[][] emptyBoard = randomBoardSet[0];
        return emptyBoard;
    }

    public static int[][] getCompletedBoard(int [][][] randomBoardSet){
        int[][] completedyBoard = randomBoardSet[1];
        return completedyBoard;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void discoverBoard(Field[][] board) {
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j].setUserValue(board[i][j].getCorrectValue());
            }
        }
    }

    public static void giveAHint(Field[][] board) {
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

    public static boolean hasSpace(Field[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].getUserValue() == 0){
                    return true;
                }
            }
        }
        return false;
    }
}

