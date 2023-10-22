package figure;

public abstract  class Figure {
    private int X;
    private int Y;
    public  Figure(int X,int Y)
    {
        this.X=X;
        this.Y=Y;

    }

    public abstract String getSign();

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
