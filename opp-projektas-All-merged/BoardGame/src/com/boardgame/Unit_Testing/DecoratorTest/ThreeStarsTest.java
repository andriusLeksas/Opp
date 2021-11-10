package com.boardgame.Unit_Testing.DecoratorTest;

import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import com.boardgame.GameWindow.Logic.DecoratorPattern.ThreeStars;
import com.boardgame.GameWindow.Logic.DecoratorPattern.TwoStars;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeStarsTest {

    @Test
    void decorateTest() {
        Player p = new ThreeStars(new Playerlmpl());
        assertEquals("Player with RedStar", p.decorate());
    }
}