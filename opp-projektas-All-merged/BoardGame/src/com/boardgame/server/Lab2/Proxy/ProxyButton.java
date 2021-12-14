package com.boardgame.server.Lab2.Proxy;

import com.boardgame.GameWindow.Lab2.Visitor.DicePanel;
import com.boardgame.server.Client.GameFrame;

import javax.swing.JButton;

public class ProxyButton implements Buttons {
    
    private RealButton realButton;
    private String name;
    private GameFrame game;
    private DicePanel dice;

    public ProxyButton(String fileName, DicePanel dic) {
        this.name = fileName;
        this.dice = dic;
    }

    @Override
    public void on(){
        realButton.on();
    }

    @Override
    public void off(){
        realButton.off();
    }

    @Override
    public void noOpponent(){
        realButton.noOpponent();
    }

    @Override
    public void addToGame(GameFrame listen){
        if(realButton == null){
            this.realButton = new RealButton(name, dice);
        }
        realButton.addToGame(listen);
    }

    @Override
    public JButton getButton(){
        return realButton.getButton();
    }
}
