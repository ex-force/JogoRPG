package main;

import models.Game;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello RPG Game!");

        Game game = new Game();
        game.startGame();
    }
}