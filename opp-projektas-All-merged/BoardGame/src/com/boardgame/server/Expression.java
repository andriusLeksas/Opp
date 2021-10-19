package com.boardgame.server;

public interface Expression {
    public String write(InterpreterContext context);
    public boolean interpret(InterpreterContext context);
}
