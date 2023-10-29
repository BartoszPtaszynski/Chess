package figure;

public class Queen extends Figure{
    public Queen(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265B";
    }

    @Override
    public boolean canMove(char X2, int Y2,Figure board[][]) {
        if(X2>'H' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        if(!(Math.abs(X2 - 'A' - X) - Math.abs(Y2 - 1 - Y) == 0 || X2-'A'==X || Y2-1==Y))return false;

        int XDirection=(X2-'A'==X)?0:((X2-'A'>X)?1:-1);
        int YDirection=(Y2-1==Y)?0:((Y2-1>Y)?1:-1);

        int currentX=X+XDirection;
        int currentY=Y+YDirection;

        while (currentX != X2 - 'A' && currentY != Y2 - 1) {
            if (board[currentX][currentY] != null) {
                return false;
            }
            currentX += XDirection;
            currentY += YDirection;
        }
        return true;

    }
}
