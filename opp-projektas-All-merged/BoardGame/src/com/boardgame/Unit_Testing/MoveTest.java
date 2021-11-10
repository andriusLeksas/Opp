package com.boardgame.Unit_Testing;

import com.boardgame.server.Move;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void execute() {
        Move m = Mockito.mock(Move.class);
        Mockito.doNothing().when(m).execute();
        m.execute();
        Mockito.verify(m).execute();
    }

    @Test
    void undo() {
        Move m = Mockito.mock(Move.class);
        Mockito.doNothing().when(m).undo();
        m.undo();
        Mockito.verify(m).undo();
    }
}