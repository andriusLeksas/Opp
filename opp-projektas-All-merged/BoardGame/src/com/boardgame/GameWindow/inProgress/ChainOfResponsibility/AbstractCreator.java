package com.boardgame.GameWindow.inProgress.ChainOfResponsibility;

public abstract class AbstractCreator {
 
 
    //next element in chain or responsibility
    protected AbstractCreator nextLogger;
 
    public void setNextChain(AbstractCreator nextLogger){
       this.nextLogger = nextLogger;
    }
 
    abstract protected void CreateFactory(String message,String type);
     
 }
