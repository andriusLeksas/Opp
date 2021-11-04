package com.boardgame.GameWindow.utils;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Die extends JPanel {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // =============================================== instance variables
private int _value; // value that shows on face of die
private int _diam = 12; // Diameter of spots
//end instance variables
//=============================================== class variables
private static Random random = new Random(); // random generator
//end class variables
//====================================================== constructor
/** Initialize to white background and 60x60 pixels. Initial roll.*/
public Die() {
setBackground(Color.white);
//-- Preferred size is set, but layout may change it.
setPreferredSize(new Dimension(60,60));
roll(); // Set to random initial value
}//end constructor
//====================================================== method roll
/** Produce random roll in range 1-6. Causes repaint().
@return Result of roll (1-6).
*/
public int roll() {
int val = (int)(Math.random()*(6-1+1)+1); // Range 1-6         totalRolled = (int)(Math.random()*(7-1+1)+1);
setValue(val);
return val;
}//end roll

public int roll1() {
    int val = 1; // Range 1-6         totalRolled = (int)(Math.random()*(7-1+1)+1);
    setValue(val);
    return val;
}//end roll
//================================================== method getValue
/** Returns result of last roll.*/
public int getValue() {
return _value;
}//end setValue
//================================================== method setValue
/** Sets the value of the Die. Causes repaint().
@param spots Number from 1-6.
*/
public void setValue(int spots) {
_value = spots;

repaint(); // Value has changed, must repaint
}//end setValue
//============================================ method paintComponent
/** Draws spots of die face. */
public void paintComponent(Graphics g) {
super.paintComponent(g); // required
int w = getWidth();
int h = getHeight(); // should use to resize spots too.
switch (_value) {
case 1: drawSpot(g, w/2, h/2);
break;
case 3: drawSpot(g, w/2, h/2);
// Fall thru to next case
case 2: drawSpot(g, w/4, h/4);
drawSpot(g, 3*w/4, 3*h/4);
break;
case 5: drawSpot(g, w/2, h/2);
// Fall thru to next case
case 4: drawSpot(g, w/4, h/4);
drawSpot(g, 3*w/4, 3*h/4);
drawSpot(g, 3*w/4, h/4);
drawSpot(g, w/4, 3*h/4);
break;
case 6: drawSpot(g, w/4, h/4);
drawSpot(g, 3*w/4, 3*h/4);
drawSpot(g, 3*w/4, h/4);
drawSpot(g, w/4, 3*h/4);
drawSpot(g, w/4, h/2);
drawSpot(g, 3*w/4, h/2);
break;
}
}//end paintComponent
/** Utility method used by paintComponent(). */
//================================================== method drawSpot
private void drawSpot(Graphics g, int x, int y) {
g.fillOval(x-_diam/2, y-_diam/2, _diam, _diam);
}//end drawSpot
}
