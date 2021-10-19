package com.boardgame.server;

import com.boardgame.server.inProgress.InterpreterContext;

public interface Expression {
    public String write(InterpreterContext context);
    public boolean interpret(InterpreterContext context);
}
