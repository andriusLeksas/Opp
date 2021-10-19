package com.boardgame.GameWindow.utils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DicePanel extends JPanel implements ActionListener {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // =============================================== instance variables
private Die _left; // component for one die
private int Rolled;
private JButton rollButton = new JButton("Roll");
private JButton undoButton = new JButton("Roll");
TextField textField = new TextField();
//end instance variables
//====================================================== constructor
/** Create border layout panel with two Die's and one button. */
public DicePanel() {
//--- Create the dice
_left = new Die();

//--- Create the button to roll the dice
//JButton rollButton = new JButton("Roll");
rollButton.setFont(new Font("Sansserif", Font.PLAIN, 12));
undoButton.setFont(new Font("Sansserif", Font.PLAIN, 12));

rollButton.addActionListener(this);
undoButton.addActionListener(this);
System.out.println(_left.getValue());
//--- Create panel for two dice
JPanel dicePanel = new JPanel();
dicePanel.setLayout(new GridLayout(1, 2, 4, 0));
dicePanel.add(_left);
System.out.println(Rolled);
//--- Add components to content pane

this.setLayout(new BorderLayout());
this.setSize( 300, 300 );
//this.add(rollButton, BorderLayout.NORTH);
//this.add(undoButton, BorderLayout.EAST);
this.add(dicePanel , BorderLayout.CENTER);
}//end constructor
/////////////////////////////////// inner listener class RollListener
/** Inner listener class for Roll button. */


public void actionPerformed(ActionEvent e) {
    _left.roll();
    _left.getValue();
    
}


}
