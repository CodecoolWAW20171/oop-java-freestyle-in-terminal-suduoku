package com.codecool.termlib;
import java.util.Arrays;

public class DisplayBoard {

    static String upperFrame = "┌---┬---┬---╥---┬---┬---╥---┬---┬---┐";
    static String verticalLine = " │ ";
    static String doubleVerticalLine = " ║ ";
    static String middleFrame = "├---┼---┼---╫---┼---┼---╫---┼---┼---┤";
    static String boldMiddlaFrame = "╞═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╡";
    static String downFrame= "└---┴---┴---╨---┴---┴---╨---┴---┴---┘";
    static String[][] boardToDisplay = new String[9][9];

    public static void displayGameBoard(Field[][] board){
        String[][] boardToDisplay = new String[9][9];
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].getUserValue() == 0) {
                    boardToDisplay[i][j] = " ";
                } else {
                    boardToDisplay[i][j] = Integer.toString(board[i][j].getUserValue());
                }

                if(board[i][j].isEditable() == false ){
                    boardToDisplay[i][j] = "\033[31;1m" + boardToDisplay[i][j] + "\033[0m";
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
                System.out.println(boldMiddlaFrame);
            } else if ( i == 8) {
                System.out.println(downFrame);
            } else {
                System.out.println(middleFrame);
            }
        }
    }
}
