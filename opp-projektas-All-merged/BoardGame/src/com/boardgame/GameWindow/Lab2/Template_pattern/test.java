package com.boardgame.GameWindow.Lab2.Template_pattern;

public class test {

	public static void main(String[] args) {
		MovementEventFactory f = new MovementEventFactory();

		MovementEvent event= f.makeMovementEvent("red");
		System.out.println("name: "+event.getname()+" tiles :"+event.getTiles());

		 event= f.makeMovementEvent("blue");
		 System.out.println("name: "+event.getname()+" tiles :"+event.getTiles());

		event= f.makeMovementEvent("black");
		System.out.println("name: "+event.getname()+" tiles :"+event.getTiles());

	}

}
