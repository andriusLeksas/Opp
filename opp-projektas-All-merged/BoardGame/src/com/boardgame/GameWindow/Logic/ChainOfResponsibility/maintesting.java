package com.boardgame.GameWindow.Logic.ChainOfResponsibility;

public class maintesting {
    private static AbstractCreator getChainOfLoggers(){

        AbstractCreator factory = new FactoryCreator();
        AbstractCreator abstractFactory = new AbstractFacotryCreator();
  
        factory.setNextChain(abstractFactory);
  
        return factory;	
     }
  
     public static void main(String[] args) {
        AbstractCreator factoryChain = getChainOfLoggers();
  
        factoryChain.CreateFactory("factory", "blue");
        factoryChain.CreateFactory("abstract","redCar");
     }
}
