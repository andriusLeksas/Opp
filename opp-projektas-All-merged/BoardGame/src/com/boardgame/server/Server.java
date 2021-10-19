package com.boardgame.server;

import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.io.*;

public class Server
{
	//private int clients = 0;
	private static final int port = 4200;
	private static ArrayList<ClientHandler> clients = new ArrayList<>();
	private static int IDs = 0;
	private static final ClientHandler[] threads = new ClientHandler[2];
	private static ServerSocket listener = null;
	public static void main(String args[]) throws IOException
	{
		ServerSocket listener = new ServerSocket(port);

		System.out.println("[SERVER] started!");
		System.out.println("Waiting for players...");
		
		while (true) {
			try{
				Socket client = listener.accept();
				System.out.println("A client connected!");
				for(int i = 0; i <= IDs; i++){
					if(threads[i] == null) {
						System.out.println("Server says this is client's ID: " + IDs);
						(threads[i] = new ClientHandler(client, IDs, threads)).start();
					}
				}
				IDs++;
				if(IDs >=2)
				{
					break;
				}
			} catch (IOException e) {
				System.out.println(e);
			  }
		}

	}
}