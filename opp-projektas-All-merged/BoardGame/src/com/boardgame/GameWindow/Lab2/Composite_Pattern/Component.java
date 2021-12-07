package com.boardgame.GameWindow.Lab2.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    protected List<Component> list = new ArrayList<>();

    public abstract float getScore();

    public void add(Component g) {
        list.add(g);
    }

    public void remove(Component g) {
        list.remove(g);
    }

    public Component getChild(int i) {
        return (Component) list.get(i);
    }
}
