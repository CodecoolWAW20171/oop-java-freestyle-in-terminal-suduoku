package com.codecool.termlib;

class Field {
    private int userValue;
    private int correctValue;
    private int row;
    private int column;
    private boolean visibility;
    private boolean editable;
    private boolean isSelected;

    boolean isSelected() {
        return isSelected;
    }

    void setSelected(boolean selected) {
        isSelected = selected;
    }

    int getUserValue() {
        return userValue;
    }

    void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    int getCorrectValue() {
        return correctValue;
    }

    boolean isEditable() {
        return editable;
    }

    Field(int correctValue, int userValue, int row, int column, boolean visibility, boolean editable) {
        this.userValue = userValue;
        this.correctValue = correctValue;
        this.row = row;
        this.column = column;
        this.visibility = visibility;
        this.editable = editable;
        this.isSelected = false;
    }
}
