package com.boardgame.GameWindow.inProgress.StatePattern;

public class StepsCounter {
    
    private State _state;
    private int step;
    
    public StepsCounter(int step)
    {
        this.step = step;
        _state = new GreenState();
    }

    public void setSteps(int number)
    {
        this.step = number;
    }

    void stateCheck()
    {
        if(step < 21 && step >= 11)
        {
            _state = new YellowState();
        }
        else if(step < 11)
        {
            _state = new RedState();
        }
    }
  
     public State getState(){
         stateCheck();
        return _state;
     }

     public void setState(State state){
        this._state = state;		
     }
}
