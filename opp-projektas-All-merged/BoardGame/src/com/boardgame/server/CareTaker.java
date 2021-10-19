package com.boardgame.server;

import java.util.*;

public class CareTaker {
    private ArrayList<memento> mementos = new ArrayList<memento>();

    public void addMemento(memento m)
    {
        mementos.add(m);
    }

    public memento getMemento(int index)
    {
        return mementos.get(index);
    }
}
