package com.boardgame.GameWindow.Logic;

import javax.swing.ImageIcon;

import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;
import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Plane;
import com.boardgame.GameWindow.Logic.AbstractFactory.Tank;
import com.boardgame.GameWindow.Logic.FasadePatern.FasadeForPlayer;
import com.boardgame.GameWindow.Logic.DecoratorPattern.OneStar;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import com.boardgame.GameWindow.Logic.DecoratorPattern.ThreeStars;
import com.boardgame.GameWindow.Logic.DecoratorPattern.TwoStars;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.*;
import com.boardgame.GameWindow.inProgress.flyWeightPattern.ImageFactory;
import com.boardgame.GameWindow.inProgress.flyWeightPattern.drawImage;


public class PlayerIcon implements FasadeForPlayer {
    
    /**
     *
     */
    private ImageIcon playerIcon;
    private int currentX;
    private int currentY;
    private int rolledValue;
    private int ID;
    private int totalRolled;
    private boolean effectedByEvent;
    private int turnsEffected;
    private String eventName;
    private Player StarDecorator;
    private int DecorationCounter;

    public PlayerIcon(final int x, final int y, final int ID) {
        this.rolledValue = 0;
        this.currentX = x;
        this.currentY = y;
        this.ID = ID;
        this.totalRolled = 0;
        this.effectedByEvent = false;
        this.turnsEffected = 0;
        this.eventName = "";
        this.StarDecorator = new Playerlmpl();
        this.DecorationCounter = 0;
    }

    public void Icon (final int p1X, final int p1Y, final int p2X, final int p2Y)
    {
        if(turnsEffected == 0)
        {
                if(p1X == p2X && p1Y == p2Y)
                {
                    drawImage image = (drawImage)ImageFactory.getImage("../../res/BlackAndWhite.png");
                    image.setSizeX(50);
                    image.setSizeY(50);
                    playerIcon = image.draw();
                }
                else if(ID == 0) {
                    if(DecorationCounter == 0)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/white_pawn.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                        
                    }
                    else if(DecorationCounter == 1)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/white_blue.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                    }
                    else if(DecorationCounter == 2)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/white_blue_yellow.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                    }
                    else if(DecorationCounter == 3)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/white_all.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                    }
                      
                }             
                else {
                    if(DecorationCounter == 0)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/black.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                        
                    }
                    else if(DecorationCounter == 1)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/black_blue.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                      
                    }
                    else if(DecorationCounter == 2)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/black_blue_yellow.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                    }
                    else if(DecorationCounter == 3)
                    {
                        drawImage image = (drawImage)ImageFactory.getImage("../../res/black_all.png");
                        image.setSizeX(50);
                        image.setSizeY(50);
                        playerIcon = image.draw();
                    }
                }   
        }
        
    }
    public Player getDecorator ()
    {
        return StarDecorator;
    }

    public void setDecorator(Player set)
    {
        StarDecorator = set;
    }

    public int DecoratorCounter ()
    {
        return DecorationCounter;
    }

    public void setDecoratorCounter(int set)
    {
        DecorationCounter = set;
    }


    public void setEventName (String set)
    {
        eventName = set;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEffectedTurns (int set)
    {
        turnsEffected = set;
    }

    public int getEffectedTurns ()
    {
        return turnsEffected;
    }

    
    public void setEffectedByEvent (boolean set)
    {
        effectedByEvent = set;
    }

    public boolean getEffectedByEvent ()
    {
        return effectedByEvent;
    }

    public void setIcon(ImageIcon image)
    {
        this.playerIcon = image;
    }

    public ImageIcon getIcon()
    {
        return playerIcon;
    }

    public int getCurrentX()
    {
        return currentX;
    }

    public int getCurrentY()
    {
        return currentY;
    }

    public void sumRolled(int sum)
    {
        
        newMovement modifiedMovement = new newMovement();
        if(eventName == "RedTank")
        {
            modifiedMovement = new newMovement(new RedTankOperation());	
            sum = modifiedMovement.executeStrategy(sum);
            totalRolled+=sum;
        }
        else if(eventName == "BlueTank")
        {
            modifiedMovement = new newMovement(new BlueTankOperation());	
            sum = modifiedMovement.executeStrategy(sum);
            totalRolled+=sum;
        }
        else if(eventName == "RedPlane")
        {
            modifiedMovement = new newMovement(new RedPlaneOperation());
            sum = modifiedMovement.executeStrategy(sum);	
            totalRolled+=sum;
            
        }
        else if(eventName == "BluePlane")
        {
            modifiedMovement = new newMovement(new BluePlaneOperation());
            sum = modifiedMovement.executeStrategy(sum);	
            totalRolled+=sum;
        }
        else if(eventName == "RedCar")
        {
            modifiedMovement = new newMovement(new RedCarOperation());
            sum = modifiedMovement.executeStrategy(sum);
            totalRolled+=sum;
        }
        else if(eventName == "BlueCar")
        {
            modifiedMovement = new newMovement(new BlueCarOperation());
            sum = modifiedMovement.executeStrategy(sum);	
            totalRolled+=sum;
        }        
        else{
            totalRolled+=sum;
        }
    }

    public int getSumRolled()
    {

        return totalRolled;
    }
    public void setSumRolled(int sum)
    {
        totalRolled = sum;
    }

    public int getID()
    {
        return ID;
    }

    public int getRolled()
    {
        return rolledValue;
    }

    public void setX(final int x)
    {
        this.currentX = x;
    }

    public void setY(final int y)
    {
        this.currentY = y;
    }

    public void setRolled(final int rolled)
    {
        this.rolledValue = rolled;
    }
    

    public void setID(final int id)
    {
        this.ID = id;
    }

    @Override
    public void Move(String eventName, Path path) {
        FactoryProvider tanks = new FactoryProvider();
        MovementEvent event = null;
        MovementEventFactory factory = new MovementEventFactory();
        if(eventName.endsWith("Tank")){
            Tank tank = (Tank)tanks.getFactory("Tank").create(eventName);
            setIcon(tank.getTank());
            setEffectedByEvent(true);
            setEffectedTurns(2);
            setEventName(eventName);
        }
        else if(eventName.endsWith("Plane")){
            Plane plane = (Plane)tanks.getFactory("Plane").create(eventName);
            setIcon(plane.getPlane());
            setEffectedByEvent(true);
            setEffectedTurns(2);
            setEventName(eventName);
        }
        else if(eventName.endsWith("Car")){
            Car car = (Car)tanks.getFactory("Car").create(eventName);
            setIcon(car.getCar());
            setEffectedByEvent(true);
            setEffectedTurns(2);
            setEventName(eventName);
        }
        else if(eventName.endsWith("Star"))
        {
           if(DecoratorCounter() == 0)
           {
             StarDecorator = new OneStar(StarDecorator);  
            setDecoratorCounter(1);
           }
           else if(DecoratorCounter() == 1)
           {
                StarDecorator = new TwoStars(StarDecorator);  
                setDecoratorCounter(2);
           }
           else if (DecoratorCounter() == 2)
           {
              StarDecorator = new ThreeStars(StarDecorator);  
               setDecoratorCounter(3);
           }  
               
        }       
        else{
            event =factory.makeMovementEvent(eventName);
            setSumRolled(getSumRolled()+event.getTiles());
            Square newSquare = path.getSquare(getSumRolled());
            setX(newSquare.returnX());
            setY(newSquare.returnY());
        }
    }

}
