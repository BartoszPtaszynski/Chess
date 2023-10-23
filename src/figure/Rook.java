package figure;

public class Rook extends Figure{
    public Rook(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265C";
    }
}
