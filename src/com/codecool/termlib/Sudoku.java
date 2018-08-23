package com.codecool.termlib;

import com.codecool.termlib.FileReader;
import com.codecool.termlib.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;


public class Sudoku {
    public static void main (String [] args){
        // display board

        String difficulty = UI.selectDifficulty();

        // wydruk kontrolny:
        System.out.println("Difficulty set to " + difficulty);
        System.out.println(" ");

        LinkedList<int[][][]> listOfBoards = FileReader.readFile(difficulty+".txt");

        int randomNumber = Utils.getRandomNumber(listOfBoards.size());
        int [][][] randomBoardSet = Utils.getRandomBoardSet(listOfBoards,randomNumber);
        int [][] emptyBoard = Utils.getEmptyBoard(randomBoardSet);
        int [][] completedBoard = Utils.getCompletedBoard(randomBoardSet);

        Field[][] board;
        board = BoardGenerator.generateBoardOutOfChosenSet(completedBoard, emptyBoard);
        Game.startGame(board, Controls.buttonNameList);
    }
}
