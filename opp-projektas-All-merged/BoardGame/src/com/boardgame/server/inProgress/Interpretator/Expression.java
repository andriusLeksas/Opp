package com.boardgame.server.inProgress.Interpretator;

public interface Expression {
    public String write(InterpreterContext context);
    public boolean interpret(InterpreterContext context);
}
