package com.boardgame.server.inProgress.Interpretator;

import com.boardgame.server.inProgress.Interpretator.Expression;
import com.boardgame.server.inProgress.Interpretator.InterpreterContext;

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