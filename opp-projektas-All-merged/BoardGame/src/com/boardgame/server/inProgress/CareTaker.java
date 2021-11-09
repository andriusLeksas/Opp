package com.boardgame.server.inProgress;

import com.boardgame.server.inProgress.memento;

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
