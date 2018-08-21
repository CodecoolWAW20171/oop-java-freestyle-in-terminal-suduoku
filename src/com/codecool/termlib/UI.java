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
}
