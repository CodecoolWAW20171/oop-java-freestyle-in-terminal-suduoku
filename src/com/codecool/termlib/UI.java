package com.codecool.termlib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";
    public static String selectDifficulty(){
        Scanner scanner = new Scanner(System.in);
        String[] difficultySettings = {"easy","medium","hard"};

        int index = 0;
        for (int i = 0; i < difficultySettings.length; i++)
        {
            System.out.println(i+1 + ". " + difficultySettings[i].substring(0, 1).toUpperCase() + difficultySettings[i].substring(1));
        }
        boolean wrongInput = true;
        while (wrongInput) {
            try {
                System.out.println("Select difficulty: ");
                index = scanner.nextInt()-1;
                if (index < 0 || index > difficultySettings.length-1) {
                    System.out.println("You may only use numbers between 1 and 3!");
                } else {
                    wrongInput = false;
                }
            } catch (InputMismatchException error) {
                System.out.println("You may only use numbers between 1 and 3!");
                scanner.next();
                wrongInput = true;
            }
        }
        return difficultySettings[index];
    }


    public static void youWon(Field [][] board) {
        DisplayBoard.displayGameBoard(board);
        System.out.println(GREEN + "               You won!" + RESET);
        System.out.println(GREEN + "                  :D" + RESET);
    }

    public static void youLost(Field [][] board){
        DisplayBoard.displayGameBoard(board);
        System.out.println(RED + "              You lost!" + RESET);
        System.out.println(RED + "                 T_T" + RESET);
    }

}
