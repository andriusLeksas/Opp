package com.boardgame.GameWindow.Logic.BridgePattern;

public class Test {
    public static void main(String[] args) {
        System.out.println("Appying Remote detonation to the Tnt");
        AbstractBomb TntRemote = new RefinedBombTnt(new ConcreteDetonationRemote());
        TntRemote.applyBombDetonation();

// Creating the Triangle instance and apply green color
        System.out.println("Appying Standart detonation to the Tnt");
        AbstractBomb TntStandart = new RefinedBombTnt(new ConcreteDetonationStandart());
        TntRemote.applyBombDetonation();

// Creating the Circle instance and apply red color
        System.out.println("Appying Remote detonation to the Dynamite");
        AbstractBomb DynamiteRemote = new RefinedBombDynamite(new ConcreteDetonationRemote());
        DynamiteRemote.applyBombDetonation();

// Creating the Circle instance and apply green colour
        System.out.println("Appying Standart detonation to the Dynamite");
        AbstractBomb DynamiteStandart = new RefinedBombDynamite(new ConcreteDetonationStandart());
        DynamiteStandart.applyBombDetonation();
    }
}
