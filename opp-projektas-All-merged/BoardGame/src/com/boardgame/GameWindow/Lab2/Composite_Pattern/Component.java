package com.boardgame.GameWindow.Lab2.Composite_Pattern;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Component
{
    public abstract int GetX();
    public abstract int GetY();
    public abstract int GetWidth();
    public abstract int GetHeight();
    public abstract String GetColor();

    protected String  name;
    public Component(String name)
    {
        this.name = name;
    }
    public abstract String Display(int depth);

    public void Add(Component component)
    {
        throw new NotImplementedException();
    }
    public void Remove(Component component)
    {
        throw new NotImplementedException();
    }

}

