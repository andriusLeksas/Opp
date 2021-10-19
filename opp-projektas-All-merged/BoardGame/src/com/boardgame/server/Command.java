package com.boardgame.server;

import com.boardgame.server.Client.GameFrame;

public interface Command {
    public void execute();
    public void undo();
}
