package com.codecool.termlib;

class BoardGenerator {

    private static Field[][] fields = new Field[9][9];
    static Field[][] generateBoardOutOfChosenSet(int[][] completedBoard, int[][] emptyBoard) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                boolean editability;
                editability =  (emptyBoard[row][column] == 0);
                fields[row][column] = new Field(completedBoard[row][column], emptyBoard[row][column], editability);
            }
        }
        return fields;
    }
}
