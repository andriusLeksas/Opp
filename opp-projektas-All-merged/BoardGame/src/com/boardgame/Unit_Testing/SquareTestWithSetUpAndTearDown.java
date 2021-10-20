package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;
import com.boardgame.GameWindow.Factory_pattern.RedMovement;
import com.boardgame.GameWindow.Logic.Square;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SquareTestWithSetUpAndTearDown {

    private Square square;

    @BeforeEach
    void setUp() {
         int X = 5, Y = 5;
         JButton button = new JButton();
         boolean hasevent = true;
         String eventName = "Red";
         square = new Square(X,Y,button,hasevent,eventName);
    }

    @Test
    void getEventNameTest() {
        System.out.println("Running getEventNameTest");
        assertEquals(square.getEventName(), "Red");
    }

    @Test
    void returnXTest() {
        System.out.println("Running returnXTest");
        assertEquals(square.returnX(),5);
    }

    @Test
    void returnYTest() {
        System.out.println("Running returnYTest");
        assertEquals(square.returnX(),5);
    }

    @Test
    void returnButtonTest() {
        System.out.println("Running returnButtonTest");
        assertNotNull(square.returnButton());
    }

    @Test
    void getEventTest() {
        System.out.println("Running getEventTest");
        assertTrue(square.getEvent());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: tearDown");
        square = null;
        assertNull(square);
    }
}