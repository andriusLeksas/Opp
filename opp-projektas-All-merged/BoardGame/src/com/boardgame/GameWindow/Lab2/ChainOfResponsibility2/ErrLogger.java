package com.boardgame.GameWindow.Lab2.ChainOfResponsibility2;

public class ErrLogger extends AbstractLogger {

    public ErrLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("CHAIN-OF-RESPONSIBILITY - Error Console::Logger: " + message);
    }
}
