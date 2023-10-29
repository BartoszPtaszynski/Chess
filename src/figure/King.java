package figure;

public class King extends Figure{
    public King(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265a";
    }

    @Override
    public boolean canMove(char X2, int Y2,Figure board[][]) {
        if(X2>'H' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        int x2=X2-'A';
        Y2-=1;

        return (Math.abs(x2-X)<=1 && Math.abs(Y2-Y)<=1);
    }
}
