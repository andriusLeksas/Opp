package com.boardgame.server;
import java.util.ArrayList;
import java.util.List;

import com.boardgame.server.Client.GameFrame;

public class CommandHandler {
    private List<Command> commandList = new ArrayList<Command>();

    public void addCommand(Command command, int id){
        commandList.add(command);
    }

    public void doCommand(){
        for(Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }

    public void undoCommand(){
        for(Command command : commandList) {
            command.undo();
        }
        commandList.clear();
    }
}
