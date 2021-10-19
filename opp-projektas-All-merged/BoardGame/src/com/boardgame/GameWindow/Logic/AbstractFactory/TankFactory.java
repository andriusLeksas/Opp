package com.boardgame.GameWindow.Logic.AbstractFactory;

public class TankFactory implements AbstractFactory<Tank> {

    @Override
    public Tank create(String vehicleType) {
        if ("BlueTank".equalsIgnoreCase(vehicleType)) {
            return new BlueTank();
        } else if ("RedTank".equalsIgnoreCase(vehicleType)) {
            return new RedTank();
        }
        return null;
    }
    
}
