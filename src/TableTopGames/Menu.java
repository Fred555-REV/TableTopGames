package TableTopGames;

import java.util.List;
import java.util.Scanner;

public class Menu {
    // YAHTZEE!
    public static void main(String[] args) {
        // v v v This is the game v v v

        Turn.createPlayers();
        Turn.setTurns();
        while (Turn.turnMax != 0) {
            Turn.displayTurn();
            Turn.displayTurnsLeft();
            Player.play(Turn.players.get(Turn.turnCounter));
        }
        if (Turn.players.size() > 1) {
            Display.winner();
        }
    }
}
