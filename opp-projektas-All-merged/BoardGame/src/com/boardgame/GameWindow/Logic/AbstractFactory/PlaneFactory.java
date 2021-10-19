package com.boardgame.GameWindow.Logic.AbstractFactory;

public class PlaneFactory implements AbstractFactory<Plane> {

    @Override
    public Plane create(String vehicleType) {
        if ("BluePlane".equalsIgnoreCase(vehicleType)) {
            return new BluePlane();
        } else if ("RedPlane".equalsIgnoreCase(vehicleType)) {
            return new RedPlane();
        }
        return null;
    }
    
}

