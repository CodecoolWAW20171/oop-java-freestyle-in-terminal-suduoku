package com.codecool.termlib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class FileReader {
    private static Gson gson = new GsonBuilder().create();
    static List<int[][][]> readFile(String fileName){
        List<int[][][]> listOfBoards = new LinkedList<>();
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                int[][][] board = gson.fromJson(sc.nextLine(), int[][][].class);
                listOfBoards.add(board);
            }
        } catch (FileNotFoundException error){
            System.out.println("File not found.");
        }
        return listOfBoards;
    }
}
