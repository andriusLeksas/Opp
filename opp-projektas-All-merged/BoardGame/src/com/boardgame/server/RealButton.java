package com.boardgame.server;

import java.awt.BorderLayout;

import javax.swing.JButton;

import com.boardgame.GameWindow.Logic.BoardLayout;
import com.boardgame.GameWindow.utils.DicePanel;
import com.boardgame.server.Client.GameFrame;
import java.awt.event.ActionListener;

public class RealButton implements Buttons {
    
    private String name;
    private JButton button;
    private DicePanel dice;

    public RealButton(String fileName, DicePanel dic) {
        this.name = fileName;
        this.dice = dic;
        button = new JButton(name);
    }

    @Override
    public void on() {
        button.setName(name);
        button.setEnabled(true);
    }

    @Override
    public void off() {
        button.setName("opponent turn...");
        button.setEnabled(false);
    }

    @Override
    public void noOpponent() {
        button.setName("Waiting for opponent...");
        button.setEnabled(true);
    }

    @Override
    public void addToGame(GameFrame listen) {
        if(name == "Roll"){
            dice.add(button, BorderLayout.NORTH);
            button.addActionListener(listen);
        }
        else if(name == "Undo"){
            dice.add(button, BorderLayout.WEST);
            button.addActionListener(listen);
        }else if(name == "End"){
            dice.add(button, BorderLayout.EAST);
            button.addActionListener(listen);
        }
    }

    @Override
    public JButton getButton(){
        return this.button;
    }
}
