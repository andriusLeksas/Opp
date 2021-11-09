package com.boardgame.server;

import com.boardgame.GameWindow.Logic.PlayerIcon;
import com.boardgame.server.Client.GameFrame;

public class Move implements Command{

    private GameFrame frame;
    private CareTaker saver = new CareTaker();
    private Originator worker = new Originator();
    private int id;
    private int count = -1;

    public Move(GameFrame frame){
        this.frame = frame;
        id = 0;
    }

    public void execute(){
        this.id = frame.getID();
        if(id == 0)
        {
            int[] toHold = {frame.getp1().getSumRolled(), frame.getp1().getCurrentX(), frame.getp1().getCurrentY(), frame.getp1().getRolled()};
            //int temp = frame.getp1().getSumRolled();
            //System.out.println("rolled before moving " + temp);
            worker.setState(toHold);
            saver.addMemento(worker.save());
            count++;
        }
        else if(id == 1)
        {
            int[] toHold = {frame.getp2().getSumRolled(), frame.getp2().getCurrentX(), frame.getp2().getCurrentY(), frame.getp2().getRolled()};
            //int temp = frame.getp2().getSumRolled();
            worker.setState(toHold);
            saver.addMemento(worker.save());
            count++;
        }
        frame.move();
    }

    public void undo(){
        worker.restore(saver.getMemento(count));
        int[] restored = worker.getRestored();
        System.out.println("total rolled after undo " + restored[0]);
        System.out.println("X after undo " + restored[1]);
        System.out.println("Y after undo " + restored[2]);
        System.out.println("rolled after undo " + restored[3]);
        frame.undo(restored, id);
    }
}
