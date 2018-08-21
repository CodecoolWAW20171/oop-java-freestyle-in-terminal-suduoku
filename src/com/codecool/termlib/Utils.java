package com.codecool.termlib;

import java.util.Arrays;
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
}
