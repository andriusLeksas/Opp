package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.RedPlaneOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.RedTankOperation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedTankOperationTest {

    @Test
    void doOperation() {
        RedTankOperation operation = new RedTankOperation();
        Assert.assertEquals(4, operation.doOperation(5));
    }
}