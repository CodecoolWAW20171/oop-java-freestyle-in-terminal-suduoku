package com.codecool.termlib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

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


    public static void youWon() {
        Utils.clearScreen();
        String youWon;
        youWon = "\n" +
                "                                        \n" +
                " __ __ _____ _____    _ _ _ _____ _____ \n" +
                "|  |  |     |  |  |  | | | |     |   | |\n" +
                "|_   _|  |  |  |  |  | | | |  |  | | | |\n" +
                "  |_| |_____|_____|  |_____|_____|_|___|\n" +
                "                                        \n";

        System.out.println(youWon);
    }

    public static void youLost(Field [][] board){
        DisplayBoard.displayGameBoard(board);
        System.out.println(" ");
        System.out.println("              You lost!");
        System.out.println("                 T_T");
        System.out.println(" ");

    }

}
