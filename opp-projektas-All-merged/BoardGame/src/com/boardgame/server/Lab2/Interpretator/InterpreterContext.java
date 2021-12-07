package com.boardgame.server.Lab2.Interpretator;

public class InterpreterContext {
    public String makeCommand(String x, String y)
    {
        return "@"+x+" "+y;
    }

    public String makeChat(String x, int id)
    {
        return "Player " + id + ": " + x;
    }

    public boolean checkCommand(String x){
        if(x.length() == 4 && x.charAt(0) == '@'){
            return true;
        }
        else
            return false;
    }

    public boolean checkChat(String x){
        if(x.length() > 0 && x.charAt(0)!= '@' && x.charAt(0)!= '$'){
            return true;
        }
        else
            return false;
    }
}
