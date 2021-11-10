package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.Logic.EventHandler;
import com.boardgame.GameWindow.Logic.Path;
import com.boardgame.GameWindow.Logic.PlayerIcon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventHandlerTest {

    @Test
    void handleEvent() {
        Path path = new Path(2);
        PlayerIcon p = new PlayerIcon(1,1,1);
        EventHandler e = new EventHandler(p, "Car");
        //assertNotNull(e.HandleEvent(path));

    }
}