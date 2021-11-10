package com.boardgame.server;

import java.io.*;
import java.net.*;

import NotYetDone.inProgress.Mediator.ChatRoom;
import NotYetDone.inProgress.Mediator.User;
import NotYetDone.inProgress.inProgress2.InterpreterContext;


public class ClientHandler extends Thread{
    private Socket client;
    private DataInputStream in = null;
    private PrintStream out = null;
    private int ids;
    private ClientHandler[] clients;
    public ClientHandler(Socket clientSocket, int ID, ClientHandler[] clients) throws IOException {
            this.client = clientSocket;
            this.clients = clients;
            this.ids = ID;
    }


	
	@Override
    public void run(){
        ClientHandler[] threads = this.clients;
        int num = 2;
        User user = new User("Player "+ ids);
        ChatRoom cr = new ChatRoom();
        makeChatExp message;
        makeCommandExp command;
        InterpreterContext ic  = new InterpreterContext();
        try {
            in = new DataInputStream(client.getInputStream());
            out = new PrintStream(client.getOutputStream());
            out.println(ids);
          
            while (true) {
                String line = in.readLine();
                message = new makeChatExp(line);
                command = new makeCommandExp(line);
                synchronized (this) {
                  if(command.interpret(ic))
                  {
                    for (int i = 0; i < clients.length; i++) {
                      if (Character.getNumericValue(line.charAt(3)) != threads[i].ids) {
                        threads[i].out.println(line);
                      }
                    }
                  }
                  else if(line.charAt(0) == '$') {
                    for (int i = 0; i < clients.length; i++) {
                      if (threads[i].ids != Character.getNumericValue(line.charAt(1))) {
                        threads[i].out.println(line);
                      }
                    }
                  }
                  else if(message.interpret(ic))
                  {
                    for (int i = 0; i < clients.length; i++) {
                      if (threads[i] != null) {
                        threads[i].out.println(line);
                      }
                    }
                  }
                   
                  }

                
            }
        }
        catch (IOException x) {
            System.err.println(x);
        }
    }
}
