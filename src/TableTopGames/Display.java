package TableTopGames;


import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void dice(Player player) {
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("/¯¯¯\\");
        }
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("|" + " " + player.dice.get(i).value + " " + "|");
        }
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("\\___/");
        }
        System.out.println();
    }

    public static void allGames() {
        System.out.println("Yahtzee, index: 1");
        System.out.println("HighLow, index: 2");
        System.out.println("DiceMage, index: 3");
    }

    public static void score(Player player) {
        System.out.println("Score is " + player.score + " for " + player.name);
    }

    public static void winner() {
        Player winner = Turn.players.get(0);
        List<Player> winners = new ArrayList<>();
        List<Player> losers = new ArrayList<>();
        // seperates the winner(s) from the losers
        for (int i = 1; i < Turn.players.size(); i++) {
            if (Turn.players.get(i).score > winner.score) {
                losers.add(winner);
                winner = Turn.players.get(i);
            } else if (Turn.players.get(i).score == winner.score) {
                winners.add(Turn.players.get(i));
                winners.add(winner);
            } else {
                losers.add(Turn.players.get(i));
            }
        }
        // displays the winner(s) and the losers
        if (winners.size() > 1) {
            System.out.println("The winners are");
            for (Player player : winners) {
                System.out.println(player.name + " with " + player.score + " points.");
            }
        } else {
            System.out.println("The winner is " + winner.name + " with " + winner.score + " points.");
        }
        System.out.println("The losers are");
        for (Player loser : losers) {
            System.out.println(loser.name + " with " + loser.score + " points.");
        }

    }

}
