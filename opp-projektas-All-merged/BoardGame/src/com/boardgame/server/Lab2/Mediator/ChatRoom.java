package com.boardgame.server.Lab2.Mediator;

import java.util.Date;

public class ChatRoom {
	public static String showMessage(User user, String message){
	     return (new Date().toString() + " [" + user.getName() + "] : " + message).toString();
	   }
}
