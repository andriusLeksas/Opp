package com.boardgame.server.inProgress;

import com.boardgame.server.inProgress.memento;

public class Originator {
    private int[] state;

    public void setState(int[] player)
    {
        this.state = player;
    }

    public memento save()
    {
        return new memento(state);
    }

    public void restore(memento m)
    {
        this.state = m.getState();
    }

    public int[] getRestored()
    {
        return state;
    }
}
