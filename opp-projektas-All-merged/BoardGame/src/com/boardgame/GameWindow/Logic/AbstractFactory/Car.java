package com.boardgame.GameWindow.Logic.AbstractFactory;

import javax.swing.ImageIcon;

public interface Car {
    ImageIcon getCar();
    ImageIcon getCarPlayer(int id);
    int getSpeed();
}
