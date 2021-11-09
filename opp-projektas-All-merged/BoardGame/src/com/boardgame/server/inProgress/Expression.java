package com.boardgame.server.inProgress;

import com.boardgame.server.inProgress.InterpreterContext;

public interface Expression {
    public String write(InterpreterContext context);
    public boolean interpret(InterpreterContext context);
}
