package com.boardgame.GameWindow.Logic;

import javax.swing.*;
import javax.swing.ImageIcon;

import com.boardgame.GameWindow.inProgress.Template_pattern.MovementEvent;
import com.boardgame.GameWindow.Logic.Prototype.Prototype;

public class Square implements Prototype {
    
    private int X, Y;
    private JButton button;
    private boolean hasevent;
    private MovementEvent movementEvent;
    private String eventName;

    public Square (int x, int y, JButton button,boolean event,MovementEvent MoveEvent)
    {
        this.X = x;
        this.Y = y;
        this.button = button;
        this.hasevent = event;
        this.movementEvent = MoveEvent;
    }

    public Square (int x, int y, JButton button, boolean event, String eventName)
    {
        this.X = x;
        this.Y = y;
        this.button = button;
        this.hasevent = event;
        this.eventName = eventName;
    }

    public Square (int x, int y, JButton button, boolean event)
    {
        this.X = x;
        this.Y = y;
        this.button = button;
        this.hasevent = event;
    }



    public String getEventName()
    {
        return eventName;
    }

    public int returnX()
    {
        return X;
    }

    public int returnY()
    {
        return Y;
    }
    
    public JButton returnButton()
    {
        return button;
    }
    public MovementEvent returnMovementEvent()
    {
        return movementEvent;
    }

    /*public MovementEvent returnMovementEvent()
    {
        return movementEvent;
    }*/

    public void updateButton(ImageIcon icon)
    {
        button.setIcon(icon);
    }
    public boolean getEvent(){

        return hasevent;
    }

    @Override
    public Prototype getClone() {

        return new Square(X, Y, button,hasevent,movementEvent);
    }

}
