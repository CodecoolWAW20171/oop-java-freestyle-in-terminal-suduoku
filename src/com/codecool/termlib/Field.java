package com.codecool.termlib;

class Field {
    private int userValue;
    private int correctValue;
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

    Field(int correctValue, int userValue, boolean editable) {
        this.userValue = userValue;
        this.correctValue = correctValue;
        this.editable = editable;
        this.isSelected = false;
    }
}
