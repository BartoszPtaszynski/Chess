package figure;

public class Knight extends Figure{
    public Knight(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265e";
    }
}
