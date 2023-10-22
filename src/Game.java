import figure.Color;
import figure.Figure;
import figure.Pawn;

import java.util.List;

public class Game {
    private final int width=8;
    private Figure[][] board;

    Player player1=new Player(Color.BRIGHT, List.of(new Pawn(1,1)));
    Player player2=new Player(Color.DARK,List.of(new Pawn(6,1)));
    public Game()
    {
        board=new Figure[width][width];
      /*  for(int i=0;i<width;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(board[i][j] == null)
                {

                }
            }
        }*/

        for(Figure figure:player1.figuresAlive)
        {
            board[figure.getX()][figure.getY()]= figure;
        }
        for(Figure figure:player2.figuresAlive)
        {
            board[figure.getX()][figure.getY()]= figure;
        }
    }
    public void printBoard(){
        char row='A';
        for(int i=1;i<=width;i++)
        {
            System.out.print(" | "+i);
        }
        System.out.print(" |\n");
        for(int i=0;i<width;i++)
        {
            System.out.print("-".repeat(34)+"\n"+ row++);
            for(int j=0;j<width;j++)
            {
                if(board[i][j]==null)
                {
                    System.out.print(j==0?"|    ":"|   ");
                }
                else if(player1.figuresAlive.contains(board[i][j]))
                {
                    System.out.print("| "+player1.color.getColor()+board[i][j].getSign()+"\u001B[97m"+" ");
                }
                else {
                    System.out.print("| "+player2.color.getColor()+board[i][j].getSign()+"\u001B[97m"+" ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print("-".repeat(34)+"\n");

    }
}
