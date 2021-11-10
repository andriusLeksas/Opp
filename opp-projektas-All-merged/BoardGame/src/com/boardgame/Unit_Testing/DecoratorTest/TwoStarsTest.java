package com.boardgame.Unit_Testing.DecoratorTest;

import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import com.boardgame.GameWindow.Logic.DecoratorPattern.TwoStars;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoStarsTest {

    @Test
    void decorateTest() {
        Player p = new TwoStars(new Playerlmpl());
        assertEquals("Player with YellowStar", p.decorate());
    }
}