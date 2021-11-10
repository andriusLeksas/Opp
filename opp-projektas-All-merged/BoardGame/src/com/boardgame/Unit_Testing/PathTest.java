package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.Logic.Path;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    Path path = new Path(5);
    int index = 5;

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void getSquare() throws NoSuchFieldException, IllegalAccessException {
        Field index = Path.class.getDeclaredField("index");
        index.setAccessible(true);
        assertNotNull(index);
    }

    @Test
    void hasPath() {

        assertFalse(path.hasPath());
    }

    @Test
    void sethasPath() {
        path.SethasPath();
        assertTrue(path.hasPath());
    }
}