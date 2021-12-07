package com.boardgame.server.Lab2.Mediator;

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
	  	 return  ChatRoom.showMessage(this,message);
	   }

}
