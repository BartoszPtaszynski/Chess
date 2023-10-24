import figure.Color;
import figure.Figure;

import java.util.LinkedList;
import java.util.List;

public class Player {
    Color color;
    private LinkedList<Figure> figuresAlive;
    private LinkedList<Figure> figuresLost;


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
    public LinkedList<Figure> getFiguresAlive()
    {
        return figuresAlive;
   }
    public LinkedList<Figure> getFiguresLost()
    {
        return figuresLost;
    }

    public void removeFigure(Figure figure)
    {
        if(figuresAlive.contains(figure))
        {
            figuresAlive.remove(figure);
            figuresLost.add(figure);
        }
    }




}
