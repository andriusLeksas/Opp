package com.boardgame.GameWindow.Lab2.ChainOfResponsibility2;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("CHAIN-OF-RESPONSIBILITY - INFO::Logger: " + message);
    }
}
