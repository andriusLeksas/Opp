package com.boardgame.Unit_Testing.FactoryPatternTests;

import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementEventFactoryTest {

    @Test
    void makeMovementEventTest() {
        MovementEventFactory f = new MovementEventFactory();
        assertNotNull(f);
    }
}