package figure;

public class Bishop extends Figure{
    public Bishop(int X, int Y) {
        super(X, Y);
    }

    @Override
    public String getSign() {
        return "\u265d";
    }
}
