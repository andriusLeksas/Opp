package com.boardgame.GameWindow.Logic.flyWeightPattern;

public class demo {
    
    private static final String colors[] = { "../../res/bluePlane.png", "../../res/black.png"};
    public static void main(String[] args) {
 
       for(int i=0; i < 5; ++i) {
          drawImage circle = (drawImage)ImageFactory.getImage(getRandomColor());
          System.out.println(circle.draw()); 
       }
    }
    private static String getRandomColor() {
       return colors[(int)(Math.random()*colors.length)];
    }

}
