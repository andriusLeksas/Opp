package com.boardgame.GameWindow.inProgress.Mediator;

public class User {
	String name;
	public User(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	 public String sendMessage(String message){
		 String msg= ChatRoom.showMessage(this,message);
	  return  msg;
	   }

}
