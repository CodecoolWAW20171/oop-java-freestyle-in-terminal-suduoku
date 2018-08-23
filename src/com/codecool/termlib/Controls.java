package com.codecool.termlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controls {
    public static int xPosition = 0;
    public static int yPosition = 0;
    public static boolean isNumber = false;
    public static boolean isWsad = false;
    public static boolean correctInput = (isNumber || isWsad);


    public static char takeInput(){
        Scanner scanner = new Scanner(System.in);
        char[] numbers = new char[] {'1','2','3','4','5','6','7','8','9'};
        char[] wsad = new char[] {'w','s','a','d','W','S','A','D'};
        char inputChar = 'x';
        String input;
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

    public static void makeMove(){
        char input = takeInput();
        if (isNumber){
            setUserValue(input);
        } else if (isWsad){
            moveCursor(input);
        }
    }


    public static void setUserValue (char input){
//        input = input;
        System.out.println(input);
    }

    public static void moveCursor(char input) {
        if (input == 'w' || input == 'W') {
            moveUp();
        } else if (input == 's' || input == 'S') {
            moveDown();
        } else if (input == 'a' || input == 'A') {
              moveLeft();
        } else if (input == 'd' || input == 'D') {
            moveRight();
        }
    }


    private static void moveUp() {
        if (yPosition > 0) {
            yPosition -= 1;
        }
        System.out.print(xPosition + ", ");
        System.out.print(yPosition);
        System.out.println(" ");
    }

    private static void moveDown() {
        if (yPosition < 8) {
            yPosition += 1;
        }
        System.out.print(xPosition + ", ");
        System.out.print(yPosition);
        System.out.println(" ");
    }

    private static void moveLeft() {
        if (xPosition > 0) {

            xPosition -= 1;
        }
        System.out.print(xPosition + ", ");
        System.out.print(yPosition);
        System.out.println(" ");
    }

    private static void moveRight() {
        if (xPosition < 8) {
            xPosition += 1;
        }
        System.out.print(xPosition + ", ");
        System.out.print(yPosition);
        System.out.println(" ");

    }

}


