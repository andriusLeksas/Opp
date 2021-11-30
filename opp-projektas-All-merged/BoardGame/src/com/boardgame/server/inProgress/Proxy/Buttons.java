package com.boardgame.server.inProgress.Proxy;
import javax.swing.JButton;

import com.boardgame.server.Client.GameFrame;

public interface Buttons {
    void on();
    void off();
    void noOpponent();
    void addToGame(GameFrame listen);
    JButton getButton();
}
