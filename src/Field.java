public class Field {
    private int userValue;
    private int correctValue;
    private int row;
    private int column;
    private boolean visibility;
    private boolean editable;


    public int getUserValue() {
        return userValue;
    }

    public void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    public int getCorrectValue() {
        return correctValue;
    }

    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Field(int value, int row, int column, boolean visibility, boolean editable) {
        this.userValue = 0;
        this.correctValue = correctValue;
        this.row = row;
        this.column = column;
        this.visibility = visibility;
        this.editable = editable;
    }
}
