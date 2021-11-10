package com.boardgame.Unit_Testing.DecoratorTest;

import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.PlayerDecorate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDecorateTest {

    @Test
    void PlayerDecorateTest(){
        Player player = new Player() {
            @Override
            public String decorate() {
                return null;
            }
        };

        PlayerDecorate playerDecorate = new PlayerDecorate(player);
        Assert.assertNull(playerDecorate.decorate());
    }
}