package com.boardgame.Unit_Testing;
import com.boardgame.GameWindow.Logic.AbstractFactory.*;
import com.boardgame.GameWindow.Logic.DecoratorPattern.*;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Player;
import com.boardgame.GameWindow.Logic.DecoratorPattern.PlayerDecorate;
import com.boardgame.GameWindow.Logic.DecoratorPattern.Playerlmpl;
import com.boardgame.GameWindow.Logic.DecoratorPattern.ThreeStars;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.ImageIcon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class DecoratorTests {

    private String decorateWithBlueStar() {
        return " with BlueStar";
    }

    @Test
    void DecorateWithBlueStarTest(){
        DecoratorTests test = new DecoratorTests();
        assertEquals(" with BlueStar", test.decorateWithBlueStar());
    }

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

    @Test
    void PlayerImplTest(){
        Playerlmpl test = new Playerlmpl();
        assertEquals("Player", test.decorate());
    }
}
