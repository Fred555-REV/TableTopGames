package TableTopGames;

import java.util.List;
import java.util.Scanner;

public class Menu {
    //Testing laptop github pushing with new ssh
    public static void main(String[] args) {
        // v v v This is the game v v v

//        Turn.createPlayers();
//        Turn.setTurns();
//        while (Turn.turnMax != 0) {
//            Turn.displayTurn();
//            Turn.displayTurnsLeft();
//            Player.play(Turn.players.get(Turn.turnCounter));
//        }

        // comment ^^^ this ^^^ out to manually test certain rolls
        System.out.println("player 1\n");
        Player player = new Player("player 1", "red");
        Player.getDice(player);
        player.dice[0].number = 1;
        player.dice[1].number = 2;
        player.dice[2].number = 3;
        player.dice[3].number = 4;
        player.dice[4].number = 5;
        Display.possibleScores(player);

        System.out.println("\nplayer 2\n");
        Player player2 = new Player("player 2", "blue");
        Player.getDice(player2);
        player2.dice[0].number = 1;
        player2.dice[1].number = 1;
        player2.dice[2].number = 1;
        player2.dice[3].number = 1;
        player2.dice[4].number = 1;
        Display.possibleScores(player2);
    }
}
