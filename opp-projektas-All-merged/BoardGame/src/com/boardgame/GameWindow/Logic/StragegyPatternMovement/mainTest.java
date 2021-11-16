package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

public class mainTest {
    
    public static void main(String[] args) {
        newMovement context = new newMovement(new BlueCarOperation());		
        System.out.println("5 + BlueCar = " + context.executeStrategy(5));
  
       context = new newMovement(new BluePlaneOperation());		
        System.out.println("3 + BluePlane= " + context.executeStrategy(3));
  
        context = new newMovement(new BlueTankOperation());		
        System.out.println("3 + BlueTank = " + context.executeStrategy(3));

        context = new newMovement(new RedPlaneOperation());		
        System.out.println("3 + RedPlane= " + context.executeStrategy(3));
  
        context = new newMovement(new RedTankOperation());		
        System.out.println("6 + RedTank = " + context.executeStrategy(6));

        context = new newMovement(new RedCarOperation());		
        System.out.println("3 + RedCar= " + context.executeStrategy(3));
  
     }
}
