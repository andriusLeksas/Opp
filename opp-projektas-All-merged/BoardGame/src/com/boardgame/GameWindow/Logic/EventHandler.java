package com.boardgame.GameWindow.Logic;

public class EventHandler {

    private PlayerIcon player;
    private String eventName;

    public EventHandler(PlayerIcon player, String eventName)
    {
        this.player = player;
        this.eventName = eventName;
    }
    public PlayerIcon HandleEvent(Path path)
    {
       player.Move(eventName, path);
       return player;
    }
    
}
