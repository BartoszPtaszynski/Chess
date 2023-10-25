package figure;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Figure{
    public Rook(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265C";
    }
    @Override
    public boolean canMove(char X2, int Y2) {


        if(X2>'H' || X2<'A' || Y2<1 || Y2>8 )
        {
            return false;
        }
        return true;
    }


    public ArrayList<Point> getRoad(char X2, int Y2)
    {
        ArrayList<Point> road=new ArrayList<>();

        if(canMove(X2,Y2))
        {
            if(Y2-1>Y)
            {
                for(int i=Y+1;i<Y2-1;i++)
                {
                    road.add(new Point(getX(),i));
                }
            }

            else if(Y2-1<Y)
            {
                for(int i=Y-1;i>Y2;i--)
                {
                    road.add(new Point(getX(),i));

                }
            }

            else if( X2-'A'<X)
            {
                for(int i=X-1;X>X2-'A';i--)
                {
                    road.add(new Point(i,getY()));
                }
            }
            else if(X2-'A'>X)
            {
                for (int i=X+1;i<X2-'A';i++)
                {
                    road.add(new Point(i,getY()));
                }
            }

        }
        return road;
    }
}
