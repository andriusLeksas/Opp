package com.boardgame.GameWindow.Logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.*;
import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Plane;
import com.boardgame.GameWindow.Logic.AbstractFactory.Tank;
import com.boardgame.GameWindow.inProgress.IteratorPattern.BoardRepository;
import com.boardgame.GameWindow.inProgress.IteratorPattern.Iterator;


public class BoardLayout {

    private final int Dimensions = 16;

    private JPanel Board;
    private Path path = new Path(Dimensions);
    private BoardRepository boardIterator;
    public BoardLayout(Square[] boardSquares, JPanel board) {
        this.Board = board;
        boardIterator = new BoardRepository(Dimensions*Dimensions);
    }

    public void fillMatrix()
    {

        int right = 0;
        int down = 0;
        Insets buttonMargin = new Insets(0,0,0,0);
        Scanner in = new Scanner(System.in);
        System.out.println("Choose tank sprite enter 1(RedTank), 2(BLueTank):");
        int choice = in.nextInt();
        System.out.println("Choose car sprite enter 1(RedCar), 2(BLueCar):");
        int choice2 = in.nextInt();
        System.out.println("Choose plane sprite enter 1(RedPlane), 2(BLuePlane):");
        int choice3 = in.nextInt();

        for (int ii = 0; ii < Dimensions; ii++) {
            for (int jj = 0; jj < Dimensions; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                FactoryProvider vehciles = new FactoryProvider();


                if(ii == right && jj == down)
                {
                    if(ii == 5 && jj == 5){
                        if(choice == 1){
                            Tank red = (Tank)vehciles.getFactory("Tank").create("RedTank");
                            b.setIcon(red.getTank());
                            path.add(right, down, b, true, "RedTank");
                        }else if(choice == 2){
                            Tank blue = (Tank)vehciles.getFactory("Tank").create("BlueTank");
                            b.setIcon(blue.getTank());
                            path.add(right, down, b, true, "BlueTank");
                        }

                    }
                    else if (ii == 12 && jj == 12)
                    {
                        if(choice2 == 1){
                            Car red = (Car)vehciles.getFactory("Car").create("RedCar");
                            b.setIcon(red.getCar());
                            path.add(right, down, b, true, "RedCar");
                        }else if(choice2 == 2){
                            Car blue = (Car)vehciles.getFactory("Car").create("BlueCar");
                            b.setIcon(blue.getCar());
                            path.add(right, down, b, true, "BlueCar");
                        }

                    }
                    else if (ii == 8 && jj == 8)
                    {
                        if(choice3 == 1){
                            Plane red = (Plane)vehciles.getFactory("Plane").create("RedPlane");
                            b.setIcon(red.getPlane());
                            path.add(right, down, b, true, "RedPlane");
                        }else if(choice3 == 2){
                            Plane blue = (Plane)vehciles.getFactory("Plane").create("BluePlane");
                            b.setIcon(blue.getPlane());
                            path.add(right, down, b, true, "BluePlane");
                        }
                    }

                    else if (ii == 2 && jj == 2)
                    {

                        b.setBackground(Color.PINK);
                        path.add(right, down, b, true,"Star");
                    }
                    else if (ii == 3 && jj == 3)
                    {
                        b.setBackground(Color.RED);
                        path.add(right, down, b, true,"red");
                    }
                    else if (ii == 6 && jj == 6)
                    {
                        b.setBackground(Color.blue);
                        path.add(right, down, b, true,"blue");
                    }
                    else{
                        b.setBackground(Color.YELLOW);
                        path.add(right, down, b, false, "");
                    }

                    if(right > down )
                    {
                        down++;
                    }
                    else
                    {
                        right++;
                    }

                }
                else
                {
                    b.setBackground(Color.white);
                }

                Square square;

                if(ii == 5 && jj == 5){
                    square = new Square(ii,jj,b,true);
                }
                else if (ii == 8 && jj == 8)
                {
                    square = new Square(ii,jj,b,true);
                }
                else if (ii == 12 && jj == 12)
                {
                    square = new Square(ii,jj,b,true);
                }
                else {
                    square = new Square(ii,jj,b,false);
                }
                // boardSquares[index++] = square;
                boardIterator.addSquare(square);
                Board.add(b);

            }
        }
    }

    public void  initializeBoard (PlayerIcon player1, PlayerIcon player2, int player_ID)
    {

        if(player_ID == 0)
        {
            if(player1.getEffectedByEvent())
            {
                player1.setEffectedTurns(player1.getEffectedTurns()-1);
                if(player1.getEffectedTurns() == 0)
                {

                    player1.setEffectedByEvent(false);
                    player1.setEventName("");
                }
            }
            player1.sumRolled(player1.getRolled());
            Square newSquare = path.getSquare(player1.getSumRolled());
            player1.setX(newSquare.returnX());
            player1.setY(newSquare.returnY());
            if(newSquare.getEvent()){
                System.out.println(newSquare.getEventName());
                EventHandler handle = new EventHandler(player1, newSquare.getEventName());
                player1 = handle.HandleEvent(path);

            }
            System.out.println(player1.getEffectedTurns());

            for(Iterator iter = boardIterator.getIterator(); iter.hasNext();){

                Square square = (Square)iter.next();

                if(square.returnX() == player1.getCurrentX() && square.returnY() == player1.getCurrentY())
                {
                    player1.Icon(player1.getCurrentX(),player1.getCurrentY(),player2.getCurrentX(),player2.getCurrentY());
                    square.updateButton(player1.getIcon());
                    Board.add(square.returnButton());

                }
                else if(square.returnX() == player2.getCurrentX() && square.returnY() == player2.getCurrentY())
                {
                    player2.Icon(player1.getCurrentX(),player1.getCurrentY(),player2.getCurrentX(),player2.getCurrentY());
                    square.updateButton(player2.getIcon());
                    Board.add(square.returnButton());
                }
                else if (square.getEvent())
                {
                    Board.add(square.returnButton());
                }
                else
                {
                    ImageIcon icon = new ImageIcon(
                            new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB));
                    square.updateButton(icon);
                    Board.add(square.returnButton());
                }


            }
        }
        else
        {
            if(player2.getEffectedByEvent())
            {
                player2.setEffectedTurns(player2.getEffectedTurns()-1);
                if(player2.getEffectedTurns() == 0)
                {
                    player2.setEffectedByEvent(false);
                    player2.setEventName("");
                }
            }

            player2.sumRolled(player2.getRolled());
            Square newSquare = path.getSquare(player2.getSumRolled());
            player2.setX(newSquare.returnX());
            player2.setY(newSquare.returnY());
            if(newSquare.getEvent()){
                System.out.println(newSquare.getEventName());
                EventHandler handle = new EventHandler(player2, newSquare.getEventName());
                player2 = handle.HandleEvent(path);

            }
            System.out.println(player2.getEffectedTurns());


            for(Iterator iter = boardIterator.getIterator(); iter.hasNext();){

                Square square = (Square)iter.next();


                if(square.returnX() == player1.getCurrentX() && square.returnY() == player1.getCurrentY())
                {
                    player1.Icon(player1.getCurrentX(),player1.getCurrentY(),player2.getCurrentX(),player2.getCurrentY());
                    square.updateButton(player1.getIcon());
                    Board.add(square.returnButton());
                }
                else if(square.returnX() == player2.getCurrentX() && square.returnY() == player2.getCurrentY())
                {
                    player2.Icon(player1.getCurrentX(),player1.getCurrentY(),player2.getCurrentX(),player2.getCurrentY());
                    square.updateButton(player2.getIcon());
                    Board.add(square.returnButton());
                }
                else if (square.getEvent())
                {
                    Board.add(square.returnButton());
                }
                else
                {
                    ImageIcon icon = new ImageIcon(
                            new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB));
                    square.updateButton(icon);
                    Board.add(square.returnButton());
                }

            }
        }
    }
}
