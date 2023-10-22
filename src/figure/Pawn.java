package figure;

public class Pawn extends Figure{
    public Pawn(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u2659";
    }
}
