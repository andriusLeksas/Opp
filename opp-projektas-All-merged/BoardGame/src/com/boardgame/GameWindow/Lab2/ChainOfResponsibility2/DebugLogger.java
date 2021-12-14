package com.boardgame.GameWindow.Lab2.ChainOfResponsibility2;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("CHAIN-OF-RESPONSIBILITY -  Debug::Logger: " + message);
    }
}