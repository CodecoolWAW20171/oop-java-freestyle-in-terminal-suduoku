package com.codecool.termlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controls {
    public static int xPosition = 0;
    public static int yPosition = 0;

    public static char takeInput(){
        Scanner scanner = new Scanner(System.in);
        char[] numbers = new char[] {'1','2','3','4','5','6','7','8','9'};
        char[] wsad = new char[] {'w','s','a','d','W','S','A','D'};
        boolean isNumber = false;
        boolean isWsad = false;
        char inputChar = 'x';
        String input = "x";
        boolean correctInput = (isNumber || isWsad);
        while (!correctInput) {
            input = scanner.nextLine();
            if (input.length() == 1) {
                inputChar = input.charAt(0);
                for (int i = 0; i < numbers.length-1; i++){
                    if (inputChar == numbers[i]){
                        isNumber = true;
                    }
                }
                for (int i = 0; i < wsad.length-1; i++) {
                    if (inputChar == wsad[i]) {
                        isWsad = true;
                    }
                }
            }
            correctInput = (isNumber || isWsad);
        }
        return inputChar;
    }

    public void setUserValue (String input){
        input = (int) input;
    }
}
