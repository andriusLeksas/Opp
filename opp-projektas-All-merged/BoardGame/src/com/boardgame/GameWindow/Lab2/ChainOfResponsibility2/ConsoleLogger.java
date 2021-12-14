package com.boardgame.GameWindow.Lab2.ChainOfResponsibility2;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("CHAIN-OF-RESPONSIBILITY -  Standard Console::Logger: " + message);
    }
}
