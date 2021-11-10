package com.boardgame.Unit_Testing;

import com.boardgame.server.inProgress.InterpreterContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterContextTest {

    InterpreterContext i;
    @BeforeEach
    void setUp() {
        i = new InterpreterContext();
    }

    @Test
    void makeCommand() {
        assertEquals("@2 2", i.makeCommand("2", "2"));
    }

    @Test
    void makeChat() {
        assertEquals("Player 1: Hello", i.makeChat("Hello",1));
    }

    @Test
    void checkCommandTrueTest() {
        assertTrue(i.checkCommand("@2 1"));
    }
    @Test
    void checkCommandFalseTest() {
        assertFalse(i.checkCommand("@2"));
    }

    @Test
    void checkChatTrueTest() {
        assertTrue(i.checkChat("&"));
    }
    @Test
    void checkChatFalseTest() {
        assertFalse(i.checkChat("@"));
    }
}