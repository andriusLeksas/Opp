package com.boardgame.server.Lab2.Interpretator;

public interface Expression {
    public String write(InterpreterContext context);
    public boolean interpret(InterpreterContext context);
}
