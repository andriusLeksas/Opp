package com.boardgame.GameWindow.Logic.BuilderPattern;

abstract class TrapBuilder {

        protected Trap trap;

        public Trap Trap()
        {
            return trap;
        }

        public abstract void BuildMaterial();
        public abstract void BuildPrice();
        public abstract void BuildMovesAffected();
        public abstract void BuildChance();

}
