package com.codecool.termlib;

import java.util.Scanner;

class Controls {
    private static int xPosition = 0;
    private static int yPosition = 0;
    private static int previousXPosition = 0;
    private static int previousYPosition = 0;
    private static int previousButtonPosition = 0;
    private static int buttonPosition = 0;
    private static boolean isNumber = false;
    private static boolean isWsad = false;
    private static boolean isCheat = false;
    private static boolean buttonIsClicked = false;
    static boolean isMenuActive = false;
    static boolean correctInput = false;
    static String[] buttonNameList = {"Submit", "Hint", "Restart", "Quit"};
    private static Buttons[] buttonList;
    private static char takeInput(Field[][] board){

        Scanner scanner = new Scanner(System.in);
        char[] numbers = new char[] {'0','1','2','3','4','5','6','7','8','9'};
        char[] wsad = new char[] {'w','s','a','d','W','S','A','D'};
        char inputChar = 'x';
        String input;
        while (!correctInput) {
            input = scanner.nextLine();
            if (input.length() == 1) {
                inputChar = input.charAt(0);
                for (char number : numbers) {
                    if (inputChar == number) {
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
            } else if (input.length() == 0 && isMenuActive){
                buttonIsClicked = true;
            } else {
                DisplayBoard.clearScreen();
                DisplayBoard.displayGameBoard(board);
                DisplayBoard.displayButtons(buttonList);
            }
            correctInput = (isNumber || isWsad || isCheat || buttonIsClicked);
        }
        return inputChar;
    }

    static void makeMove(Field[][] board){
        char input = takeInput(board);
        if (isNumber){
            setUserValue(input, board);
            isNumber = false;
        } else if (isWsad){
            moveCursor(input, board, buttonList);
            isWsad = false;
        } else if (isCheat){
            Game.discoverBoard(board);
            isCheat = false;
        } else if (buttonIsClicked){
            runMethodFromMenu(board);
            buttonIsClicked = false;
        }
    }

    private static void runMethodFromMenu(Field[][] board) {
        switch (buttonPosition){
            case 0:
                Game.setGameSubmitted(true);
                break;
            case 1:
                Game.giveAHint(board);
                break;
            case 2:
                Game.resetBoard(board);
                break;
            case 3:
                Game.quit();
                break;
        }
    }

    private static void setUserValue(char input, Field[][] board){
        if (board[yPosition][xPosition].isEditable()){
            int userValue = Character.getNumericValue(input);
            setUserValue(board, userValue);
        }
    }

    private static void moveCursor(char input, Field[][] board, Buttons[] buttonList) {
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
                if (buttonPosition < buttonList.length-1) {
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
        buttonList[previousButtonPosition].setSelected(false);
        buttonList[buttonPosition].setSelected(true);
        previousButtonPosition = buttonPosition;
    }

    private static void setUserValue(Field[][] board, int value){
        board[yPosition][xPosition].setUserValue(value);
    }

    static Buttons[] createButtons(String[] buttonNameList) {
        buttonList = new Buttons[buttonNameList.length];
        for (int i = 0; i < buttonNameList.length; i++) {
            Buttons button = new Buttons(buttonNameList[i], i);
            buttonList[i] = button;
        }
        return buttonList;
    }

    private static void activateMenu(){
        buttonList[0].setSelected(true);
        isMenuActive = true;
    }

    private static void deactivateMenu(){
        for (Buttons button : buttonList) {
            button.setSelected(false);
            previousButtonPosition = 0;
            buttonPosition = 0;
        }
        isMenuActive = false;
    }
}


