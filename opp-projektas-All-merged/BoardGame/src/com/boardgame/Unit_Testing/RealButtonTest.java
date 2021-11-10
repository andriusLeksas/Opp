package com.boardgame.Unit_Testing;

import com.boardgame.GameWindow.utils.DicePanel;
import com.boardgame.server.RealButton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class RealButtonTest {

    private String name;
    private JButton button;
    private DicePanel dice;

    @BeforeEach
    void setUp() {
        dice = new DicePanel();
        button = new JButton();
    }

    @AfterEach
    void tearDown() {
        dice = null;
        button = null;
    }

    @Test
    void on() {
        //dice = new DicePanel();
        //button = new JButton();
        RealButton r = new RealButton("fileName", dice);
        r.on();
        button.setName("GoodName");
        button.setEnabled(true);
        assertEquals("GoodName", button.getName());
    }

    @Test
    void off() {
        RealButton r = new RealButton("fileName", dice);
        r.off();
        button.setName("opponent turn...");
        button.setEnabled(false);
        assertEquals("opponent turn...", button.getName());
    }

    @Test
    void noOpponent() {
        RealButton r = new RealButton("fileName", dice);
        r.noOpponent();
        button.setName("Waiting for opponent...");
        button.setEnabled(false);
        assertEquals("Waiting for opponent...", button.getName());
    }

    @Test
    void getButton() {
        RealButton r = new RealButton("fileName", dice);
        button.setName("s");
        assertEquals("s", button.getName());
    }
}