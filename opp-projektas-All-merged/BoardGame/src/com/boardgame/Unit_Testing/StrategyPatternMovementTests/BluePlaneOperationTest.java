package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BlueCarOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BluePlaneOperation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BluePlaneOperationTest {

    @Test
    void doOperation() {
        BluePlaneOperation operation = new BluePlaneOperation();
        Assert.assertEquals(10, operation.doOperation(5));
    }
}