package figure;

public abstract  class Figure {
    protected int X;
    protected int Y;
    //checks if figures are on the top or the bottom of the board
    protected boolean isTop;
    public  Figure(int X,int Y)
    {
        this.X=X;
        this.Y=Y;
        isTop= X < 2;

    }

    public abstract String getSign();

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public abstract boolean canMove(char X2,int Y2);

}
