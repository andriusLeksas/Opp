package com.boardgame.server;

import NotYetDone.inProgress.inProgress2.Expression;
import NotYetDone.inProgress.inProgress2.InterpreterContext;

public class makeChatExp implements Expression {
    private String value;
    private int id;
    private String fullText;

    public makeChatExp(String val, int x)
    {
        this.value = val;
        this.id = x;
        fullText = val + x;
    }

    public makeChatExp(String text){
        this.fullText = text; 
    }

    @Override
    public String write(InterpreterContext ic) {
        fullText = ic.makeChat(value, id);
        return fullText;
    }

    @Override
    public boolean interpret(InterpreterContext ic){
        return ic.checkChat(fullText);
    }


}
