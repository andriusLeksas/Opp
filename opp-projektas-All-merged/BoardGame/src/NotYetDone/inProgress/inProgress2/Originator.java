package NotYetDone.inProgress.inProgress2;

public class Originator {
    private int[] state;

    public void setState(int[] player)
    {
        this.state = player;
    }

    public memento save()
    {
        return new memento(state);
    }

    public void restore(memento m)
    {
        this.state = m.getState();
    }

    public int[] getRestored()
    {
        return state;
    }
}
