import figure.Color;
import figure.Figure;

import java.util.LinkedList;
import java.util.List;

public class Player {
    Color color;
    LinkedList<Figure> figuresAlive;
    LinkedList<Figure> figuresLost;


    public Player(Color color)
    {
        this.color=color;
        figuresAlive=new LinkedList<>();
        figuresLost=new LinkedList<>();
    }
    public void addFigure(Figure figure)
    {
        figuresAlive.add(figure);
    }
    public void addFigure(List figures)
    {
        figuresAlive.addAll(figures);
    }

    public void moveFigure(Figure figure,int X,int Y)
    {

    }

}
