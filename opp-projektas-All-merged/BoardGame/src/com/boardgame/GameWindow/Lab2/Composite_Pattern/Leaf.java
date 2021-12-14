package com.boardgame.GameWindow.Lab2.Composite_Pattern;

public class Leaf extends Component {

    public String color;

    public int width;

    public int height;

    public int x;

    public int y;

    public Leaf(String name, String color, int width, int height, int x, int y) {
        super(name);

        this.color = color;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    @Override
    public String Display(int depth) {
        return ("\n"
                + ('-' +  String.valueOf(depth)) + (" "
                + (name + (" "
                + (this.color + (" "
                + (this.width + (" "
                + (this.height + (" "
                + (this.x + (" " + this.y))))))))))));
    }
    @Override
    public int GetX() {
        return this.x;
    }
    @Override
    public int GetY() {
        return this.y;
    }
    @Override
    public int GetWidth() {
        return this.width;
    }

    @Override
    public int GetHeight() {
        return this.height;
    }
    @Override
    public String GetColor() {
        return this.color;
    }
}
