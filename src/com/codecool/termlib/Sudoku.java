package com.codecool.termlib;
<<<<<<< HEAD

import com.codecool.termlib.FileReader;
import com.codecool.termlib.Utils;

=======
>>>>>>> ef990baa4bbd990aad0351bcc3ca731e6ef899a0
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;


public class Sudoku {
    public static void main (String [] args){
        // display board


        LinkedList<int[][][]> listOfBoards = FileReader.readFile("easy.txt");
<<<<<<< HEAD

=======
>>>>>>> ef990baa4bbd990aad0351bcc3ca731e6ef899a0
        int randomNumber = Utils.getRandomNumber(listOfBoards.size());
        int [][][] randomBoardSet = Utils.getRandomBoardSet(listOfBoards,randomNumber);
        int [][] emptyBoard = Utils.getEmptyBoard(randomBoardSet);
        int [][] completedBoard = Utils.getCompletedBoard(randomBoardSet);

<<<<<<< HEAD
        Field[][] board;
        board = BoardGenerator.generateBoardOutOfChosenSet(completedBoard, emptyBoard);
        DisplayBoard.displayGameBoard(board);


//
//        for (int[] elem : emptyBoard){
//            System.out.println(Arrays.toString(elem));
//        }
//
//        System.out.println(" ");
//
//        for (int[] elem : completedBoard){
//            System.out.println(Arrays.toString(elem));
//        }

=======
        for (int[] elem : emptyBoard){
            System.out.println(Arrays.toString(elem));
        }
>>>>>>> ef990baa4bbd990aad0351bcc3ca731e6ef899a0

        System.out.println(" ");

        for (int[] elem : completedBoard){
            System.out.println(Arrays.toString(elem));
        }


        // JSON to 2d array
        //int[][] intArray2 = gson.fromJson("[[1,2,3],[4,5,6]]", int[][].class);

        // 2d array to JSON
        //System.out.println(gson.toJson(board));
    }


}
