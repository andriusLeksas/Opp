package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BlueCarOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BlueTankOperation;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.Strategy;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlueTankOperationTest {

    @Test
    void doOperation() {
        BlueTankOperation operation = new BlueTankOperation();
        Assert.assertEquals(3, operation.doOperation(5));
    }
}