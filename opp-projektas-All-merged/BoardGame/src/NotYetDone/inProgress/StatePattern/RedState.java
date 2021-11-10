package NotYetDone.inProgress.StatePattern;

public class RedState implements State {
    
    public void doAction(StepsCounter counter) {
        System.out.println("Player is in Red state");
        counter.setState(this);	
     }
  
     public String toString(){
        return "Red";
     }
}
