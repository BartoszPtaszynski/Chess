package figure;

public enum Color {
    BRIGHT,
    DARK;
    public String getColor()
    {
        return
                switch (this) {
                    case DARK -> "\u001B[32m";
                    case BRIGHT -> "\u001B[97m";
                };
        }


}
