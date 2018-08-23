package com.codecool.termlib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controls {
    public static int xPosition = 0;
    public static int yPosition = 0;
    public static int previousXPosition = 0;
    public static int previousYPosition = 0;
    public static int previousButtonPosition = 0;
    public static int buttonPosition = 0;
    public static boolean isNumber = false;
    public static boolean isWsad = false;
    public static boolean isCheat = false;
    public static boolean isMenuActive = false;
    public static boolean correctInput = (isNumber || isWsad || isCheat);

    public static String[] buttonNameList = {"Submit", "Hint", "Restart", "Quit"};
    public static Buttons[] buttonList;

    public static char takeInput(Field[][] board){

        Scanner scanner = new Scanner(System.in);
        char[] numbers = new char[] {'1','2','3','4','5','6','7','8','9'};
        char[] wsad = new char[] {'w','s','a','d','W','S','A','D'};
        char inputChar = 'x';
        String input;
        while (!correctInput) {
            input = scanner.nextLine();
            if (input.length() == 1) {
                inputChar = input.charAt(0);
                for (int i = 0; i < numbers.length; i++){
                    if (inputChar == numbers[i]){
                        isNumber = true;
                    }
                }
                for (int i = 0; i < wsad.length-1; i++) {
                    if (inputChar == wsad[i]) {
                        isWsad = true;
                    }
                }
                if (inputChar == 'F'){
                    isCheat = true;
                }
            }
            correctInput = (isNumber || isWsad || isCheat);
        }
        return inputChar;
    }

    public static void makeMove(Field[][] board){
        char input = takeInput(board);
        if (isNumber){
            setUserValue(input, board);
            isNumber = false;
        } else if (isWsad){
            moveCursor(input, board, buttonList);
            isWsad = false;
        } else if (isCheat){
            Utils.discoverBoard(board);
            isCheat = false;
        }
    }

    public static void setUserValue (char input, Field[][] board){
        if (board[yPosition][xPosition].isEditable()){
            int userValue = Character.getNumericValue(input);
            setUserValue(board, userValue);
        }
    }

    public static void moveCursor(char input, Field[][] board, Buttons [] buttonList) {
        if (input == 'w' || input == 'W') {
            moveUp(board);
        } else if (input == 's' || input == 'S') {
            moveDown(board);
        } else if (input == 'a' || input == 'A') {
              moveLeft(board, buttonList);
        } else if (input == 'd' || input == 'D') {
            moveRight(board, buttonList);
        }
    }

    private static void moveUp(Field[][] board) {
        if (!isMenuActive) {
            if (yPosition > 0 && yPosition < 9) {
                yPosition -= 1;
                select(board);
            }
        } else {
            deactivateMenu();
        }
    }

    private static void moveDown(Field[][] board) {
        if (yPosition < 8) {
            yPosition += 1;
            select(board);
        } else if (yPosition == 8){
            activateMenu();
        }
    }

    private static void moveLeft(Field[][] board, Buttons [] buttonList) {
        if (!isMenuActive) {
            if (xPosition > 0) {
                xPosition -= 1;
                select(board);
            }
        } else {
            if (buttonPosition > 0) {
                buttonPosition -= 1;
                selectButton(buttonList);
            }
        }
    }

    private static void moveRight(Field[][] board, Buttons[] buttonList) {
        if (!isMenuActive) {
            if (xPosition < 8) {
                xPosition += 1;
                select(board);
            }
        } else {
                System.out.println("1");

                if (buttonPosition < 3) {
                    System.out.println("s");
                    buttonPosition += 1;
                    selectButton(buttonList);
                }
            }
        }

    private static void select(Field[][] board) {

        board[previousYPosition][previousXPosition].setSelected(false);
        board[yPosition][xPosition].setSelected(true);
        previousXPosition = xPosition;
        previousYPosition = yPosition;
    }

    private static void selectButton(Buttons[] buttonList) {

        System.out.println(previousButtonPosition);
        System.out.println(buttonPosition);

        buttonList[previousButtonPosition].setSelected(false);
        buttonList[buttonPosition].setSelected(true);
        previousButtonPosition = buttonPosition;
    }

    private static void setUserValue(Field[][] board, int value){
        board[yPosition][xPosition].setUserValue(value);
    }

    public static Buttons[] createButtons(String[] buttonNameList) {
        buttonList = new Buttons[buttonNameList.length];
        for (int i = 0; i < buttonNameList.length; i++) {
            Buttons button = new Buttons(buttonNameList[i], i);
            buttonList[i] = button;
        }
        return buttonList;
    }

    public static void activateMenu(){
        buttonList[0].setSelected(true);
        isMenuActive = true;
    }

    public static void deactivateMenu(){
        for (int i=0; i<buttonList.length; i++) {
            buttonList[i].setSelected(false);
            previousButtonPosition = 0;
            buttonPosition = 0;
        }
        isMenuActive = false;
    }
}


