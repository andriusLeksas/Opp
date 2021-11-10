package com.boardgame.Unit_Testing.AbstractFactoryTest;

import com.boardgame.GameWindow.Logic.AbstractFactory.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTests {

    @ParameterizedTest
    @ValueSource(strings = {"BlueTank", "RedTank"})
    void parameterizedTankObjectTest(String value){
        TankFactory tankFactory = new TankFactory();
        assertNotNull(tankFactory.create(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"BluePlane", "RedPlane"})
    void parameterizedPlaneObjectTest(String value){
        PlaneFactory planeFactory = new PlaneFactory();
        assertNotNull(planeFactory.create(value));
    }

    @Test
    void createTankFactoryTest() {
        //RedTank
        //BlueTank
        TankFactory tankFactory = new TankFactory();
        assertNotNull(tankFactory.create("BlueTank"));
    }
    @Test
    void createPlaneFactoryTest() {
        //RedPlane
        //BluePlane
        PlaneFactory planeFactory = new PlaneFactory();
        assertNotNull(planeFactory.create("BluePlane"));
    }
    @Test
    void createCarFactoryTest() {
        //RedCar
        //BlueCar
        CarFactory carFactory = new CarFactory();
        assertNotNull(carFactory.create("BlueCar"));
    }
    @Test
    void getBluePlaneTypeTest(){
        BluePlane bluePlane = new BluePlane();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(bluePlane.getPlane() instanceof ImageIcon);
    }
    @Test
    void getBlueCarTypeTest(){
        BlueCar blueCar = new BlueCar();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(blueCar.getCar() instanceof ImageIcon);
    }
    @Test
    void getBlueTankTypeTest(){
        BlueTank blueTank = new BlueTank();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(blueTank.getTank() instanceof ImageIcon);
    }
    @Test
    void getRedPlaneTypeTest(){
        RedPlane redPlane = new RedPlane();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(redPlane.getPlane() instanceof ImageIcon);
    }
    @Test
    void getRedCarTypeTest(){
        RedCar redCar = new RedCar();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(redCar.getCar() instanceof ImageIcon);
    }
    @Test
    void getRedTankTypeTest(){
        RedTank redTank = new RedTank();
        ImageIcon imageIcon = new ImageIcon();
        assertTrue(redTank.getTank() instanceof ImageIcon);
    }
    @Test
    void getRedTankSpeedTest(){
        //speed = 1
        RedTank redTank = new RedTank();
        assertEquals(1, redTank.getSpeed());
    }
    @Test
    void getBluePlaneSpeedTest(){
        //speed = 2
        BluePlane bluePlane = new BluePlane();
        assertEquals(2, bluePlane.getSpeed());
    }
    @Test
    void getRedPlaneSpeedTest(){
        //speed = 2
        RedPlane redPlane = new RedPlane();
        assertEquals(3, redPlane.getSpeed());
    }
}