package com.codecool.termlib;
import java.util.Arrays;

public class DisplayBoard {

    public static void displayGameBoard(Field[][] board){
        for (int i =0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j].getUserValue());
                System.out.print(" ");
            }
            System.out.println(" ");
        }

    }
}
