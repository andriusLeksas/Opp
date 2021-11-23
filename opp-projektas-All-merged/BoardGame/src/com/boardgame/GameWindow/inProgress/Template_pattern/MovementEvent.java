package com.boardgame.GameWindow.inProgress.Template_pattern;

public abstract class MovementEvent {
	
    private String name;
    private int tiles;
    public MovementEvent() {
		
	}
    public String getname(){ return name;};
    public void setName(String Name){
    this.name = Name;
    }
    public int getTiles(){ return tiles;};
    public void setTiles(int tilesnum){
    this.tiles = tilesnum;
    }
    public MovementEvent CreateTemplate(String type) {

        MovementEvent Event =null;
        if (type == "red") 
        {
          Event =new RedMovement();     
        }
        else if(type == "blue")
        {
          Event =new BlueMovement();     
        }
        else if (type == "black")
        {
          Event = new BlackMovement();
        }
       return Event;
      }
    }
