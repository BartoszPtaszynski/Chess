import figure.Color;
import figure.Figure;

import java.util.LinkedList;
import java.util.List;

public class Player {
    Color color;
    LinkedList<Figure> figuresAlive;
    LinkedList<Figure> figuresLost;

    public Player(Color color, List figuresList)
    {
        this.color=color;
        figuresAlive=new LinkedList<>(figuresList);
        figuresLost=new LinkedList<>();
    }




}
