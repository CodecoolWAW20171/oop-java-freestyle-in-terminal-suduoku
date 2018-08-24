package com.codecool.termlib;

public class Buttons {
    private String name;
    private boolean isSelected;

    String getName() {
        return name;
    }

    boolean isSelected() {
        return isSelected;
    }

    void setSelected(boolean selected) {
        isSelected = selected;
    }

    Buttons(String name) {
        this.name = name;
        this.isSelected = false;
    }


}
