package com.codecool.termlib;

public class Buttons {
    private String name;
    private boolean isSelected;
    private int buttonPosition;

    public int getButtonPosition() {
        return buttonPosition;
    }

    public void setButtonPosition(int xPosition) {
        this.buttonPosition = xPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Buttons(String name, int buttonPosition) {
        this.name = name;
        this.isSelected = false;
        this.buttonPosition = buttonPosition;
    }


}
