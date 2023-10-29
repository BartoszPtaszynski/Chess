package figure;

public class Rook extends Figure{
    public Rook(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265C";
    }
    @Override
    public boolean canMove(char X2, int Y2,Figure board[][]) {


        if(X2>'H' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        if(X!=X2-'A' && Y!=Y2-1 )return false;

        int XDirection=(X2-'A')>X?1:-1;
        int YDirection=(Y2-1>Y)?1:-1;


        if(X==X2-'A')
        {
            for(int currentY=Y+YDirection;currentY!=Y2-1;currentY+=YDirection)
            {
                if(board[X][currentY]!=null) return  false;
            }
            return true;
        }
        else
        {
            for(int currentX=X+XDirection;currentX!=X2-'A';currentX+=XDirection)
            {
                if(board[currentX][Y]!=null) return  false;
            }return true;
        }
    }



}
