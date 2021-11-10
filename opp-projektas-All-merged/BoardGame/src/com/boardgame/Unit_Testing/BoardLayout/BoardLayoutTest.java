package com.boardgame.Unit_Testing.BoardLayout;

import com.boardgame.GameWindow.Logic.BoardLayout;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class BoardLayoutTest {

    @Test
    void fillMatrix() {
        BoardLayout b = Mockito.mock(BoardLayout.class);
        Mockito.doNothing().when(b).fillMatrix();
        b.fillMatrix();
        Mockito.verify(b).fillMatrix();
    }

    @Test
    void initializeBoard() {

        BoardLayout b = Mockito.mock(BoardLayout.class);
        Mockito.doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                System.out.println("called with arguments: " + Arrays.toString(args));
                return null;
            }
        }).when(b).fillMatrix();
    }
}