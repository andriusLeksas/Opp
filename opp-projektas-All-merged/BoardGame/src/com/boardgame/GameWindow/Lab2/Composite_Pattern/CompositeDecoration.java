package com.boardgame.GameWindow.Lab2.Composite_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDecoration extends Component {

    protected ArrayList<Component> _children = new ArrayList<Component>();

    public CompositeDecoration(String name) {
        super(name);
    }

    @Override
    public void Add(Component component) {
        this._children.add(component);
    }

    @Override
    public void Remove(Component component) {
        this._children.remove(component);
    }


    @Override
    public String Display(int depth) {
        String result = "";
        for (Component component : this._children) {
            result = (result + component.Display((depth + 1)));
        }

        return result;
    }

    public final List<Component> GetChild() {
        return this._children;
    }

    @Override
    public int GetX() {
        return 0;
    }

    @Override
    public int GetY() {
        return 0;
    }

    @Override
    public int GetWidth() {
        return 0;
    }

    @Override
    public int GetHeight() {
        return 0;
    }

    @Override
    public String GetColor() {
        return null;
    }
}
