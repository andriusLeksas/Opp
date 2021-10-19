package com.boardgame.GameWindow.Logic.DecoratorPattern;


public class test {
    
    public static void main(String[] args) {

        Player player1 = new OneStar(new Playerlmpl());
        System.out.println(player1.decorate());
        player1 = new TwoStars(player1);
        System.out.println(player1.decorate());
       
    }
}
