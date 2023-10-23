import figure.*;

import java.util.List;

public class Game {
    private final int width=8;
    private Figure[][] board;

    Player player1;
    Player player2;
    public Game()
    {
        board=new Figure[width][width];



        player1=new Player(Color.BRIGHT);
        player2=new Player(Color.DARK);

        //adding pawns to the players:
        for(int i=0;i<8;i++)
        {
            player1.addFigure(new Pawn(1,i));
            player2.addFigure(new Pawn(6,i));

        }
        player1.addFigure(List.of(new Rook(0,7),new Rook(0,0),new Knight(0,1),new Knight(0,6),
                new Bishop(0,2),new Bishop(0,5),new King(0,4),new Queen(0,3)));

        player2.addFigure(List.of(new Rook(7,7),new Rook(7,0),new Knight(7,1),new Knight(7,6),
                new Bishop(7,2),new Bishop(7,5),new King(7,4),new Queen(7,3)));

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
        System.out.print(" ");
        for(int i=1;i<=width;i++)
        {
            System.out.print("| "+(char)('\uFF11' + i - 1)+" ");

        }
        System.out.print("|\n");
        for(int i=0;i<width;i++)
        {
            System.out.print("-".repeat(39)+"\n"+ row++);
            for(int j=0;j<width;j++)
            {
                if(board[i][j]==null)
                {
                    System.out.print("|\u2003  ");
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
        System.out.print("-".repeat(39)+"\n");
    }

}
