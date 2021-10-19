package com.boardgame.GameWindow.Logic.DecoratorPattern;
public abstract class PlayerDecorate implements Player{
    
    private Player player;
    
    public PlayerDecorate(Player player) {
        this.player = player;
	}

	// standard constructors
    @Override
    public String decorate() {
        return player.decorate();
    }
}
