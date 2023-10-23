package figure;

public class King extends Figure{
    public King(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265a";
    }
}
