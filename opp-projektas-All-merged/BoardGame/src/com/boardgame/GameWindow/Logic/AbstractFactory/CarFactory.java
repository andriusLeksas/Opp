package com.boardgame.GameWindow.Logic.AbstractFactory;

public class CarFactory implements AbstractFactory<Car> {

    @Override
    public Car create(String vehicleType) {
        if ("BlueCar".equalsIgnoreCase(vehicleType)) {
            return new BlueCar();
        } else if ("RedCar".equalsIgnoreCase(vehicleType)) {
            return new RedCar();
        }
        return null;
    }
    
}
