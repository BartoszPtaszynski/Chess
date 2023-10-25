import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

// compile in intelij due to bad encoding in console cms in windows.

public class Main {
    public static void main(String[] args) {

        //setting UTF to get symbols of figures in console.
        try {
            System.setProperty("file.encoding", "UTF-8");
            System.setOut(new PrintStream(System.out, true,  "UTF-8"));
            System.out.println("Hello, World! ©");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Game board=new Game();
        board.playGame();

        }

}

