package com.boardgame.GameWindow.Logic.AbstractFactory;

import javax.swing.ImageIcon;

public interface Plane {
    ImageIcon getPlane();
    ImageIcon getPlanePlayer(int id);
    int getSpeed();
}
