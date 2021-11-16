package com.boardgame.GameWindow.Logic.AdapterPattern;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Create a Scanner object
        Target target = new Adapter();
        System.out.println("Input your username, if you leave it empty it will be generated");
        String username = input.nextLine();
        //target.RequestUsername(username);
        System.out.print("Hello " + target.RequestUsername(username));
    }
}
