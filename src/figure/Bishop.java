package figure;

public class Bishop extends Figure{
    public Bishop(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265d";
    }

    @Override
    public boolean canMove(char X2, int Y2) {
        if(X2>'G' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        return Math.abs(X2 - 'A' - X) - Math.abs(Y2 - 1 - Y) == 0;

    }
}
