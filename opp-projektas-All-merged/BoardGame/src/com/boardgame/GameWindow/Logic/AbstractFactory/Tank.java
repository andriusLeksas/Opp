package com.boardgame.GameWindow.Logic.AbstractFactory;

import javax.swing.ImageIcon;

public interface Tank {
    ImageIcon getTank();
    ImageIcon getTankPlayer(int id);
    int getSpeed();
}
