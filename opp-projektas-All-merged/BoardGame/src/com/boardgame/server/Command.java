package com.boardgame.server;

public interface Command {
    public void execute();
    public void undo();
}
