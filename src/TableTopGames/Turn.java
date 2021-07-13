package TableTopGames;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    public static int turnCounter = 0;
    public static List<Player> players = new ArrayList<>();


    public static void turnPass() {

        if (turnCounter == players.size() - 1) {
            turnCounter = 0;
        } else {
            turnCounter++;
        }
    }

    public static void turnBack(Player player) {
        turnCounter--;//for accidents
    }

    public static void displayTurn() {
        System.out.println(players.get(turnCounter).name + "'s or " + players.get(turnCounter).color + "'s turn ");
    }
}
