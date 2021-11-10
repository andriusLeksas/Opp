package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.Strategy;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.newMovement;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class newMovementTest {

    private Strategy strategy;
    private newMovement _newMovement;

    @BeforeEach
    void setUp() {
        strategy = new Strategy() {
            @Override
            public int doOperation(int rolled) {
                return 3;
            }
        };
        _newMovement = new newMovement(strategy);
    }

    @Test
    void executeStrategy() {
        Assert.assertEquals(3,_newMovement.executeStrategy(5));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: tearDown");
        _newMovement = null;
        strategy = null;
        assertNull(_newMovement);
    }
}