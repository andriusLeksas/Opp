package com.boardgame.server;

public interface Subject {
    
    void attach(Observer ob);
    void detach(Observer ob);
    void notifyClients(Object str);
}
