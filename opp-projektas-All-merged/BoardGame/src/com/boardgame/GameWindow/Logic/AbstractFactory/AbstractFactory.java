package com.boardgame.GameWindow.Logic.AbstractFactory;

public interface AbstractFactory<T> {

    T create(String vehicleType) ;
}
