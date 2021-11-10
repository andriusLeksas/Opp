package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.RedCarOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.RedPlaneOperation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedPlaneOperationTest {

    @Test
    void doOperation() {
        RedPlaneOperation operation = new RedPlaneOperation();
        Assert.assertEquals(15, operation.doOperation(5));
    }
}