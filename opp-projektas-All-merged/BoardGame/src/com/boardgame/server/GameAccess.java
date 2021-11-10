package com.boardgame.server;

import com.boardgame.server.ClientClasses.Client;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class GameAccess implements Subject {
    private Socket socket;
    private OutputStream outputStream;
    private ArrayList<Observer> list = new ArrayList<>();
    private Object asd = "";
    public int playerID;

    public void attach(Observer o) {
        list.add(o);
        System.out.println("Observer attached and will update objects");
    }

    public void detach(Observer o) {
        list.remove(o);
    }

    //@Override
    public void notifyClients(Object asd) {
        for (Observer o : list) {
            o.update(asd);
        }
    }

    public void InitSocket(String server, int port, GameAccess access) throws IOException {
        socket = new Socket(server, port);
        outputStream = socket.getOutputStream();

        JFrame game = new JFrame();
        Client.GameFrame cb = new Client.GameFrame(access);
        JPanel frame = new Client.ChatFrame(access);

        Thread receivingThread = new Thread() {
            //@Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    String temp = reader.readLine();
                    System.out.println("Connected");
                    int ID = Integer.parseInt(temp);
                    cb.createPlayer(ID);
                    game.add(cb.getGui());
                    game.add(frame, BorderLayout.EAST);
                    game.setTitle("StrategyBoardGame: Player " + ID);
                    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    game.setLocationByPlatform(true);
                    game.pack();
                    game.setMinimumSize(game.getSize());
                    game.setLocationRelativeTo(null);
                    game.setResizable(true);
                    game.setVisible(true);
                    playerID = ID;
                    String line;
                    while ((line = reader.readLine()) != null) {
                        asd = line;
                        notifyClients(asd);
                    }
                } catch (IOException x) {
                    asd = x;
                    notifyClients(asd);
                }
            }
        };
        receivingThread.start();
    }

    private static final String CRLF = "\r\n"; // newline

    public void send(String text) {
        try {
            outputStream.write((text + CRLF).getBytes());
            outputStream.flush();
        } catch (IOException ex) {
            asd = ex;
            notifyClients(asd);
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            asd = ex;
            notifyClients(asd);
        }
    }
}
