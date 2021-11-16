package com.boardgame.GameWindow.Logic.BuilderPattern;

import java.util.HashMap;

public class Trap {
    private String _trapType;
    HashMap<String, String> _parts = new HashMap<String, String>();

    public Trap(String trapType)
    {
        this._trapType = trapType;
    }

    public void Show()
    {
        System.out.print("Trap type: ");
        System.out.println( _trapType);
        _parts.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
