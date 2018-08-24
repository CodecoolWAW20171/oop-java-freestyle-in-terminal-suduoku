package com.codecool.termlib;

class DisplayBoard {
    private static String verticalLine = " │ ";

    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String BACKGROUND = "\033[43m";
    private static final String ANSI_BLUE = "\u001B[34m";

    static void displayGameBoard(Field[][] board){
        String[][] boardToDisplay = new String[9][9];
        Utils.clearScreen();
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardToDisplay[i][j] = Integer.toString(board[i][j].getUserValue());
                if (board[i][j].getUserValue() == 0) {
                    boardToDisplay[i][j] = " ";
                }
                if (!board[i][j].isEditable()){
                    boardToDisplay[i][j] = ANSI_BLUE + boardToDisplay[i][j] + RESET; // PREDEFINED FIELD
                }
                if (board[i][j].isSelected() && !Controls.isMenuActive){
                    boardToDisplay[i][j] = BACKGROUND + boardToDisplay[i][j] + RESET; // SELECTED FIELD
                }
                if (Game.gameSubmitted && board[i][j].getUserValue() != board[i][j].getCorrectValue()){
                    if (board[i][j].getUserValue() == 0){
                        boardToDisplay[i][j] = "x";
                    }
                    boardToDisplay[i][j] = RED + boardToDisplay[i][j] + RESET;
                }
                if (Game.gameSubmitted && board[i][j].getUserValue() == board[i][j].getCorrectValue()){
                    boardToDisplay[i][j] = GREEN + boardToDisplay[i][j] + RESET;
                }
            }
        }

        String upperFrame = "┌───┬───┬───╥───┬───┬───╥───┬───┬───┐";
        System.out.println(upperFrame);
        for (int i =0; i < 9; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 2 && j != 8) {
                    System.out.print(boardToDisplay[i][j]);
                    String doubleVerticalLine = " ║ ";
                    System.out.print(doubleVerticalLine);

                } else {
                    System.out.print(boardToDisplay[i][j]);
                    System.out.print(verticalLine);
                }
            }
            System.out.println(" ");
            if (i % 3 == 2 && i != 8) {
                String boldMiddleFrame = "╞═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╡";
                System.out.println(boldMiddleFrame);
            } else if ( i == 8) {
                String downFrame = "└───┴───┴───╨───┴───┴───╨───┴───┴───┘";
                System.out.println(downFrame);
            } else {
                String middleFrame = "├───┼───┼───╫───┼───┼───╫───┼───┼───┤";
                System.out.println(middleFrame);
            }
        }
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void displayButtons(Buttons[] buttonList){
        System.out.println(" ");
        System.out.print(verticalLine);
        for (Buttons button : buttonList){
            if (button.isSelected()){
                System.out.print(ANSI_YELLOW + button.getName() + RESET);
            } else {
                System.out.print(button.getName());
            }
            System.out.print(verticalLine);
        }
        System.out.println(" ");

    }

}
