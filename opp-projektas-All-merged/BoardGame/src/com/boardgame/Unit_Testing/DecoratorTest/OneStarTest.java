package com.boardgame.Unit_Testing.DecoratorTest;

import com.boardgame.GameWindow.Logic.DecoratorPattern.OneStar;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneStarTest {

    @Test
    void decorateTest() {
        Player p = new OneStar(new Playerlmpl());
        assertEquals("Player with BlueStar", p.decorate());
    }
}