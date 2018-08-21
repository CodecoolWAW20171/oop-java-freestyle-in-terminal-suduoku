package com.codecool.termlib;
import java.util.Arrays;

public class DisplayBoard {

    static String upperFrame = "┌---┬---┬---┬---┬---┬---┬---┬---┬---┐";
    static String verticalLine = " │ ";
    static String middleFrame = "├---┼---┼---┼---┼---┼---┼---┼---┼---┤";
    static String downFrame= "└---┴---┴---┴---┴---┴---┴---┴---┴---┘";
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
            }
        }

        System.out.println(upperFrame);
        for (int i =0; i < 8; i++) {
            System.out.print("│ ");
            for (int j = 0; j < 9; j++) {
                System.out.print(boardToDisplay[i][j]);
                System.out.print(verticalLine);
            }
            System.out.println(" ");
            System.out.println(middleFrame);
        }
        int i = 8;
        System.out.print("│ ");
        for (int j = 0; j < 9; j++) {
            System.out.print(boardToDisplay[i][j]);
            System.out.print(verticalLine);
        }
        System.out.println(" ");
        System.out.println(downFrame);

    }
}
