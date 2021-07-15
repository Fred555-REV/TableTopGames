package TableTopGames;

import java.util.List;
import java.util.Scanner;

public class Menu {
//Testing laptop github pushing with new ssh
    public static void main(String[] args) {
        // write your code here
        Turn.createPlayers();
        Turn.setTurns();
        while (Turn.turnMax != 0) {
            Turn.displayTurn();
            Turn.displayTurnsLeft();
            Player.play(Turn.players.get(Turn.turnCounter));
        }

    }
}
