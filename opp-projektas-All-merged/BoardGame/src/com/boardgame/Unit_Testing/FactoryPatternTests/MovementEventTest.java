package com.boardgame.Unit_Testing.FactoryPatternTests;

import com.boardgame.GameWindow.Factory_pattern.BlackMovement;
import com.boardgame.GameWindow.Factory_pattern.BlueMovement;
import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementEventTest {

    private MovementEventFactory fac;
    private String name;
    private int tiles;

    @BeforeEach
    void setUpTest() {
        fac = new MovementEventFactory();
    }

    @Test
    void getnameTest() {
        MovementEvent event= new MovementEvent() {
            @Override
            public String getname() {
                return super.getname();
            }
        };
        event.setName("Nice");
        assertEquals("Nice",event.getname());
    }

    @Test
    void setNameTest() {
        MovementEvent event= new MovementEvent() {
            @Override
            public void setName(String Name) {
                super.setName(Name);
            }
        };
        event.setName("Good Name");
        assertEquals("Good Name",event.getname());
    }

    @Test
    void getTilesTest() {
        MovementEvent event = new MovementEvent() {
            @Override
            public int getTiles() {
                return super.getTiles();
            }
        };
        event.setTiles(7);
        assertEquals(7,event.getTiles());
    }

    @Test
    void setTilesTest() {
        MovementEvent event = new MovementEvent() {
            @Override
            public int getTiles() {
                return super.getTiles();
            }
        };
        event.setTiles(9);
        assertEquals(9,event.getTiles());
    }
    @Test
    void createRedTemplateTest() {
        MovementEvent event= new MovementEvent() {
            @Override
            public MovementEvent CreateTemplate(String type) {
                return super.CreateTemplate(type);
            }
        };
        assertNotNull(event.CreateTemplate("red"));
    }
    @Test
    void createBlueTemplateTest() {
        MovementEvent event= fac.makeMovementEvent("blue");
        MovementEvent Event = new BlueMovement();
        assertNotNull(event.CreateTemplate("blue"));
    }
    @Test
    void createBlackTemplateTest() {
        MovementEvent event= fac.makeMovementEvent("black");
        MovementEvent Event = new BlackMovement();
        assertNotNull(event.CreateTemplate("black"));
    }

    @AfterEach
    void tearDownTest() {
        fac = null;
        assertNull(fac);
    }
}