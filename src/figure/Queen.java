package figure;

public class Queen extends Figure{
    public Queen(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265B";
    }
}
