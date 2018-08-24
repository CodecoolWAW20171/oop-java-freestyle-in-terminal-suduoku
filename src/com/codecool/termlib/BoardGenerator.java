package com.codecool.termlib;

class BoardGenerator {

    private static Field[][] fields = new Field[9][9];
    static Field[][] generateBoardOutOfChosenSet(int[][] completedBoard, int[][] emptyBoard) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                boolean visibility;
                boolean editability;
                if (emptyBoard[row][column] == 0){
                    visibility = false;
                    editability = true;
                } else {
                    visibility = true;
                    editability = false;
                }
                fields[row][column] = new Field(completedBoard[row][column], emptyBoard[row][column], row, column, visibility, editability);
            }
        }
        return fields;
    }
}
