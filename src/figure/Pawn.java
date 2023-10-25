package figure;

public class Pawn extends Figure{

    public Pawn(int X, int Y) {
        super(X, Y);
    }



    @Override
    public String getSign() {
        return "\u265f";
    }


    @Override
    public boolean canMove(char X2, int Y2) {


        if(X2>'H' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        if((Y==Y2-1 && ((isTop && X2-'A'-1==X)|| (!isTop && X2-'A'+1==X)) )  )
        {
            return true;
        }


        return false;
    }




}
