package com.boardgame.GameWindow.Logic;

import javax.swing.JButton;

import com.boardgame.GameWindow.inProgress.Template_pattern.MovementEvent;

public class Path {
    
    
    private Square[] Path;
    private int index = 0;
    private boolean haspath = false;
    public Path (int dimensions)
    {
        this.Path = new Square[dimensions*dimensions];
    }

    public void add (int x, int y, JButton button,boolean hasevent,MovementEvent event)
    {
        Path[index++] = new Square(x, y, button,hasevent,event);
    }

    public void add (int x, int y, JButton button,boolean hasevent, String eventName)
    {
        Path[index++] = new Square(x, y, button,hasevent,eventName);
    }

    /*public void addWithEvent (int x, int y, String event)
    {
        Path[index++] = new Square(x, y, event);
    }*/

    public void Print()
    {
        for (int i = 0; i < index; i++)
        {
            System.out.println(Path[i].returnX() + " " + Path[i].returnY());
        }
    }

    public Square getSquare (int i)
    {
        if(i > index)
        {
            return Path[index - 1];
        }
        return Path[i];
    }
    public boolean hasPath(){
        return haspath;
    }
    public void SethasPath(){
       this.haspath=true;
    }
}
