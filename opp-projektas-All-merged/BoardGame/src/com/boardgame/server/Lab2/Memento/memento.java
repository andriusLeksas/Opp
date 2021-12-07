package com.boardgame.server.Lab2.Memento;

public class memento {
    private int[] player;

    public memento(int[] player)
    {
        this.player = player;
    }

    public int[] getState()
    {
        //System.out.println("before getting out of memento = " + this.player.getRolled());
        return player;
    }
}
