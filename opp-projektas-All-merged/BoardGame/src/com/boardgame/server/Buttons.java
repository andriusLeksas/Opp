package com.boardgame.server;
import javax.swing.JButton;

import com.boardgame.server.ClientClasses.Client.GameFrame;

public interface Buttons {
    void on();
    void off();
    void noOpponent();
    void addToGame(GameFrame listen);
    JButton getButton();
}
