package com.boardgame.GameWindow.Logic.BuilderPattern;

public class Test {
    private static Shop shop = new Shop();
    private static TrapBuilder builder;
    public static void main(String[] args) {
        builder = new GoldTrapBuilder();
        shop.Construct(builder);
        builder.Trap().Show();

        System.out.println();

        builder = new SilverTrapBuilder();
        shop.Construct(builder);
        builder.Trap().Show();
    }
}
