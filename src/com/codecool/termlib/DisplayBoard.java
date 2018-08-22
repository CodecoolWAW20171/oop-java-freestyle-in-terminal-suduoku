package com.codecool.termlib;
import java.util.Arrays;

public class DisplayBoard {

    static String upperFrame = "┌───┬───┬───╥───┬───┬───╥───┬───┬───┐";
    static String verticalLine = " │ ";
    static String doubleVerticalLine = " ║ ";
    static String middleFrame = "├───┼───┼───╫───┼───┼───╫───┼───┼───┤";
    static String boldMiddleFrame = "╞═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╡";
    static String downFrame= "└───┴───┴───╨───┴───┴───╨───┴───┴───┘";
    static String[][] boardToDisplay = new String[9][9];

    public static final String RED = "\033[0;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";
    public static final String CYAN = "\033[0;36m";


    public static void displayGameBoard(Field[][] board){
        String[][] boardToDisplay = new String[9][9];
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardToDisplay[i][j] = Integer.toString(board[i][j].getUserValue());
                if (board[i][j].getUserValue() == 0) {
                    boardToDisplay[i][j] = " ";
                }
                if (board[i][j].isEditable() == false ){
                    boardToDisplay[i][j] = RED + boardToDisplay[i][j] + RESET; // PREDEFINED FIELD
                } else if (board[i][j].isSelected() && board[i][j].isEditable() && board[i][j].isVisibility()){
                    boardToDisplay[i][j] = CYAN + boardToDisplay[i][j] + RESET; // SELECTED FIELD
                }
                else if (board[i][j].isSelected() && board[i][j].isEditable() && !board[i][j].isVisibility()){
                    boardToDisplay[i][j] = CYAN + "█" + RESET; // SELECTED EMPTY FIELD
                }
            }
        }

        System.out.println(upperFrame);
        for (int i =0; i < 9; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 2 && j != 8) {
                    System.out.print(boardToDisplay[i][j]);
                    System.out.print(doubleVerticalLine);

                } else {
                    System.out.print(boardToDisplay[i][j]);
                    System.out.print(verticalLine);
                }
            }
            System.out.println(" ");
            if (i % 3 == 2 && i != 8) {
                System.out.println(boldMiddleFrame);
            } else if ( i == 8) {
                System.out.println(downFrame);
            } else {
                System.out.println(middleFrame);
            }
        }
    }
}
