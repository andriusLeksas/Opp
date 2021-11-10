package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BlueTankOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.RedCarOperation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedCarOperationTest {

    @Test
    void doOperation() {
        RedCarOperation operation = new RedCarOperation();
        Assert.assertEquals(6, operation.doOperation(5));
    }
}