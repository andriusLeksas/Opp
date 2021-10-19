package com.boardgame.GameWindow.Logic.IteratorPattern;

import javax.swing.JButton;

import com.boardgame.GameWindow.Logic.Square;

public class demo {
    public static void main(String[] args) {
        BoardRepository namesRepository = new BoardRepository(2);
        JButton a = new JButton();
        namesRepository.addSquare(new Square(1, 1, a, false));
  
       for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
           Square name = (Square)iter.next();
           System.out.println(name.returnX());
        }	
     }
}
