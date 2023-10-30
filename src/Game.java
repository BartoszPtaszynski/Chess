import figure.*;

import java.util.List;
import java.util.Scanner;

public class Game {
    private final int width=8;
    private Figure[][] board;

    private final Player player1;
    private final Player player2;
    boolean isFinished=false;
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

        refreshBoard();
    }
    private void printBoard(){
        refreshBoard();
        char row='A';
        System.out.print(" ");
        for(int i=1;i<=width;i++)
        {
            System.out.print("| "+(char)('１' + i - 1)+" ");
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
                else if(player1.getFiguresAlive().contains(board[i][j]))
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

    private boolean moveFigure(Player player,Figure figure,char X,int Y)
    {
        if(player.getFiguresAlive().contains(figure)) {
            if (player == player1) {
               return  moveFigureConditions(figure, player1, player2, X, Y);

            } else {
               return moveFigureConditions(figure, player2, player1, X, Y);
            }
        }
        else {
            return false;
        }
    }
   private boolean moveFigureConditions(Figure figure,Player playerPlaying,Player playerWaiting,char X, int Y)
   {
       int x=X-'A';

       int copyX= figure.getX();
       int copyY= figure.getY();


       if(figure instanceof Pawn p && !p.canMove(X,Y,board))
       {
           if(((p.isTop() && p.getX()==x-1) || (!p.isTop() && p.getX()==x+1)) && Math.abs(p.getY()-(Y-1))==1  && playerWaiting.getFiguresAlive().contains(board[x][Y-1]))
           {
               Figure toKill=board[x][Y-1];
               playerWaiting.removeFigure(board[x][Y-1]);
               figure.setX(x);
               figure.setY(Y-1);
               refreshBoard();
               if(isCheck(playerWaiting))
               {
                   System.out.println("You cannot go there, cause there is a CHECK!");
                   figure.setX(copyX);
                   figure.setY(copyY);
                   playerWaiting.getFiguresLost().remove(toKill);
                   playerWaiting.getFiguresAlive().add(toKill);

                   refreshBoard();
                   return false;
               }

               return true;
           }
       }
       if(figure.canMove(X,Y,board) )
       {
           if(playerWaiting.getFiguresAlive().contains(board[x][Y-1]))
           {
               if(figure instanceof Pawn)
               {
                   return  false;
               }
               Figure toKill=board[x][Y-1];
               playerWaiting.removeFigure(board[x][Y-1]);
               figure.setX(x);
               figure.setY(Y-1);
               refreshBoard();
               if(isCheck(playerWaiting))
               {
                   System.out.println("You cannot go there, cause there is a CHECK!");
                   figure.setX(copyX);
                   figure.setY(copyY);
                   playerWaiting.getFiguresLost().remove(toKill);
                   playerWaiting.getFiguresAlive().add(toKill);

                   refreshBoard();
                   return false;
               }

               return true;

           }
           else if(playerPlaying.getFiguresAlive().contains(board[x][Y-1]))
           {
               return false;
           }

           figure.setX(x);
           figure.setY(Y-1);
           refreshBoard();

           if(isCheck(playerWaiting))
           {
               System.out.println("You cannot go there, cause there is a CHECK!XDDDDD");
               figure.setX(copyX);
               figure.setY(copyY);
               refreshBoard();
               return false;
           }

           return  true;

       }
       refreshBoard();

       return false;
   }

    private void refreshBoard()
    {
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<width;j++)
            {
                board[i][j]=null;
            }
        }
        for(Figure figure:player1.getFiguresAlive())
        {
            board[figure.getX()][figure.getY()]= figure;
        }
        for(Figure figure:player2.getFiguresAlive())
        {
            board[figure.getX()][figure.getY()]= figure;
        }
    }

    public void playGame() {
        int i=0;
        Player activePlayer;
        String coordinates;
        int  x1,y1,y2;
        char x2;
        Scanner scanner=new Scanner(System.in);
        String communicate="";
        while (true) {

            activePlayer=i%2==0?player1:player2;
            System.out.println("////CHESS GAME//// - to end game kill king of the opponent");
            System.out.println(communicate);
            communicate="";
            printBoard();

            System.out.print(player1.color.getColor()+"Player 1:\nActive figures:");
            for(Figure figure:player1.getFiguresAlive()) System.out.print(figure.getSign()+" ");
            System.out.print("\nLost Figures: ");
            for(Figure figure:player1.getFiguresLost()) System.out.print(figure.getSign()+" ");
            System.out.println();
            System.out.print(player2.color.getColor()+"Player 2:\nActive figures:");
            for(Figure figure:player2.getFiguresAlive()) System.out.print(figure.getSign()+" ");
            System.out.print("\nLost Figures: ");
            for(Figure figure:player2.getFiguresLost()) System.out.print(figure.getSign()+" ");
            System.out.println("\u001B[97m");


            System.out.println((activePlayer.equals(player1)?"Player 1":"Player 2")+" provide coordinates of figure which you want to move or provide END to surrender: ");

            do{
                coordinates=scanner.nextLine().toUpperCase();

            }while(!checkCoordinates(coordinates));

            if(isFinished)
            {
                System.out.println((activePlayer.equals(player1) ? "Player 2" : "Player 1" )+ " won! Thank you for game. ");
                System.exit(0);
            }

            x1=coordinates.charAt(0)-'A';
            y1=coordinates.charAt(1)-'0'-1;

            System.out.println("Provide coordinates WHERE: ");
            do{
                coordinates=scanner.nextLine().toUpperCase();
            }while(!checkCoordinates(coordinates));

            x2=coordinates.charAt(0);
            y2=coordinates.charAt(1)-'0';
            if(moveFigure(activePlayer,board[x1][y1],x2,y2))
            {
                communicate+=("Your move has been done!\n");
                i++;
            }
            else  communicate+=("Bad move!");
            if(isCheck(activePlayer))  communicate+=("IT IS A CHECK! for "+(activePlayer.equals(player1)?"player 1":"player 2")+"\n");
        }
    }
    private boolean checkCoordinates(String coordinates)
    {
        if(coordinates.equals("END"))
        {
            isFinished=true; return true;
        }
        return coordinates.length() == 2 && (coordinates.charAt(0) >= 'A' && coordinates.charAt(0) <= 'H' && coordinates.charAt(1) - '0' >= 1 && coordinates.charAt(1) - '0' <= 8);
    }
    private boolean isCheck(Player attacker)
    {
        Player deffender=attacker.equals(player1)?player2:player1;
        int x=0,y=0;
        for(Figure f:deffender.getFiguresAlive())
        {
            if(f instanceof King king)
            {
                x=king.getX();y=king.getY();break;
            }
        }
        for(Figure f:attacker.getFiguresAlive())
        {
            if(f.canMove((char)(x+'A'),(y+1),board))return true;
        }
        return false;
    }

}
