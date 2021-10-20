package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.Factory_pattern.BlueMovement;
import com.boardgame.GameWindow.Factory_pattern.BlackMovement;
import com.boardgame.GameWindow.Factory_pattern.RedMovement;
import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovementEventTests {


    @Test
    void getBlueMovementName() {
        BlueMovement blueMovement = new BlueMovement();
        blueMovement.setName("blue");
        assertEquals("blue", blueMovement.getname());
    }

    @Test
    void getBlueMovementTiles() {
        BlueMovement blueTiles = new BlueMovement();
        blueTiles.setTiles(-3);
        assertEquals(-3, blueTiles.getTiles());
    }

    @Test
    void getBlackMovementName() {
        BlackMovement blackMovement = new BlackMovement();
        blackMovement.setName("black");
        assertEquals("black", blackMovement.getname());
    }

    @Test
    void getBlackMovementTiles() {
        BlackMovement blackTiles = new BlackMovement();
        blackTiles.setTiles(5);
        assertEquals(5, blackTiles.getTiles());
    }
}