package TableTopGames;

import java.util.List;
import java.util.Scanner;

public class Menu {
    //Testing laptop github pushing with new ssh
    public static void main(String[] args) {
        // write your code here
//        Turn.createPlayers();
//        Turn.setTurns();
//        while (Turn.turnMax != 0) {
//            Turn.displayTurn();
//            Turn.displayTurnsLeft();
//            Player.play(Turn.players.get(Turn.turnCounter));
//        }
        Player player = new Player("fred", "C");
        Player.getDice(player);
        player.dice[0].number = 3;
        player.dice[1].number = 3;
        player.dice[2].number = 3;
        player.dice[3].number = 2;
        player.dice[4].number = 3;
        Display.possibleScores(player);
        Player player2 = new Player("fred", "C");
        Player.getDice(player2);
        player2.dice[0].number = 1;
        player2.dice[1].number = 1;
        player2.dice[2].number = 1;
        player2.dice[3].number = 2;
        player2.dice[4].number = 2;
        Display.possibleScores(player2);
    }
}
