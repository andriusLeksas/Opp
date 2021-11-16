package com.boardgame.GameWindow.Logic.AdapterPattern;

public class Adapter implements Target
{
    private Adaptee _adaptee = new Adaptee();

    public String RequestUsername(String username)
    {
        if (username.equals(""))
        {
            return _adaptee.RandomUsername();
        }
        else
        {
            return _adaptee.UsernameFill(username);
        }
    }
}
