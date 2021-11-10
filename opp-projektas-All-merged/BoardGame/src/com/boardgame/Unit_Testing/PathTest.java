package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;
import com.boardgame.GameWindow.Logic.Path;
import com.boardgame.GameWindow.Logic.Square;
import org.junit.jupiter.api.Test;

class PathTest {

    private Square[] path;
    private int index = 0;
    private boolean haspath = false;
    MovementEventFactory fac = new MovementEventFactory();
    MovementEvent event= fac.makeMovementEvent("red");

    @Test
    void addTest() {

    }

    @Test
    void testAddTest() {
    }

    @Test
    void printTest() {
        Path p = new Path(5);
        index = 5;
        //path = new Square[5];
        //assert(p.Print());
    }

    @Test
    void getSquareTest() {
    }

    @Test
    void hasPathTest() {
    }

    @Test
    void sethasPathTest() {
    }
}