package com.codecool.termlib;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Sudoku {
    public static void main (String [] args){
        Gson gson = new GsonBuilder().create();

        int[][] board = new int[][] {
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9}
        };

        // display board
        for (int[] element : board){
            System.out.println(Arrays.toString(element));
            System.out.println();
        }

        // JSON to 2d array
        //int[][] intArray2 = gson.fromJson("[[1,2,3],[4,5,6]]", int[][].class);

        // 2d array to JSON
        System.out.println(gson.toJson(board));
    }
}
