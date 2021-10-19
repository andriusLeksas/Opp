package com.boardgame.GameWindow.Logic.FasadePatern;

import com.boardgame.GameWindow.Logic.Path;

public interface FasadeForPlayer {
    void Move(String eventname,Path path);
}
