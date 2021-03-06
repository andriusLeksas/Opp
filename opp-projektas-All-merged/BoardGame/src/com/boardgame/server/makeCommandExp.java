package com.boardgame.server;

import NotYetDone.inProgress.inProgress2.Expression;
import NotYetDone.inProgress.inProgress2.InterpreterContext;

public class makeCommandExp implements Expression {
    private String value;
    private String id;
    private String fullText;

    public makeCommandExp(String val, String x)
    {
        this.value = val;
        this.id = x;
    }

    public makeCommandExp(String text)
    {
        this.fullText = text;
    }

    @Override
    public String write(InterpreterContext ic) {
        fullText = ic.makeCommand(value, id);
        return fullText;
    }

    @Override
    public boolean interpret(InterpreterContext ic){
        return ic.checkCommand(fullText);
    }
}
