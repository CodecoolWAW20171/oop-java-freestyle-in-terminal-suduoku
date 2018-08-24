package com.codecool.termlib;

import java.util.LinkedList;
import java.util.List;

class Utils {


    static int getRandomNumber(int range){
        return (int) (Math.random() * range);
    }

    static int[][][] getRandomBoardSet(List<int[][][]> listOfBoards, int number){
        return listOfBoards.get(number);
    }

    static int[][] getEmptyBoard(int[][][] randomBoardSet){
        return randomBoardSet[0];
    }

    static int[][] getCompletedBoard(int[][][] randomBoardSet){
        return randomBoardSet[1];
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

