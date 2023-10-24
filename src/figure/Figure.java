package figure;

import java.awt.*;
import java.util.ArrayList;

public abstract  class Figure {
    protected int X;
    protected int Y;
    //checks if figures are on the top or the bottom of the board
    protected boolean isTop;

    public Figure(int X, int Y) {
        this.X = X;
        this.Y = Y;
        isTop = X < 2;

    }

    public abstract String getSign();

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public abstract boolean canMove(char X2, int Y2);

    public  ArrayList<Point> getRoad(char X2, int Y2)
    {
        return null;
    }


}
