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
        Player player1 = new Player("player 1", "red");
        Player.getDice(player1);
        player1.dice[0].number = 5;
        player1.dice[1].number = 5;
        player1.dice[2].number = 3;
        player1.dice[3].number = 5;
        player1.dice[4].number = 3;
        Display.dice(player1);
        Display.possibleScores(player1);

        System.out.println("\nplayer 2\n");
        Player player2 = new Player("player 2", "blue");
        Player.getDice(player2);
        player2.dice[0].number = 6;
        player2.dice[1].number = 6;
        player2.dice[2].number = 5;
        player2.dice[3].number = 6;
        player2.dice[4].number = 6;
        Display.dice(player2);
        Display.possibleScores(player2);

    }
}
