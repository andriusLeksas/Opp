package com.boardgame.Unit_Testing.DecoratorTest;

import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PlayerlmplTest {

    @Test
    void PlayerImplTest(){
        Playerlmpl test = new Playerlmpl();
        assertEquals("Player", test.decorate());
    }
}