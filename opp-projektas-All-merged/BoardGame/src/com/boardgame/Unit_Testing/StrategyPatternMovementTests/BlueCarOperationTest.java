package com.boardgame.Unit_Testing.StrategyPatternMovementTests;

import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.StragegyPatternMovement.BlueCarOperation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlueCarOperationTest {

    @Test
    void doOperation() {
        BlueCarOperation operation = new BlueCarOperation();
        Assert.assertEquals(7, operation.doOperation(5));
    }
}