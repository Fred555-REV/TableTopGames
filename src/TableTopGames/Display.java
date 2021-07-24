package TableTopGames;


import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

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

    public static void availableActions(DiceMage mage) {
        System.out.println("Actions");
        int powerUpCost;
        if (mage.dice.size() > 6) {
            powerUpCost = 4 + (mage.dice.size() - 6 + mage.companionAmount);
        } else {
            powerUpCost = 4 + mage.companionAmount;
        }
        if (mage.mana > powerUpCost) {
            System.out.println("(1) increase power for " + powerUpCost + " (doesn't end turn.");
        }
        System.out.println("(2) summon a companion for min 6 mana (ends turn)");
        System.out.println("(3) attack with companions");
        System.out.println("(4) view field (doesn't end turn)");
        System.out.println("(5) end turn");
    }

    public static void companions(DiceMage mage) {
        System.out.println("Companions");
        if (mage.mana >= 6) {
            System.out.println("common 1d3    \tcost: 6 mana\tindex: 1");
        }
        if (mage.mana >= 7) {
            System.out.println("uncommon 1d4  \tcost: 7 mana\tindex: 2");

        }
        if (mage.mana >= 8) {
            System.out.println("rare 1d6      \tcost: 8 mana\tindex: 3");

        }
        if (mage.mana >= 9) {
            System.out.println("epic 1d8      \tcost: 9 mana\tindex: 4");

        }
        if (mage.dice.size() > 10) {
            System.out.println("legendary 1d20\tcost: 5 die \tindex: 5");
        }
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

    public static void survivor() {
        DiceMage survivor;
        if (((DiceMage) Turn.players.get(0)).health <= 0) {
            survivor = (DiceMage) Turn.players.get(1);
            System.out.println(survivor.color + " Mage " + survivor.name + " is the ULTIMATE BATTLE MAGE!!!!!");
        } else {
            survivor = (DiceMage) Turn.players.get(0);
            System.out.println(survivor.color + " Mage " + survivor.name + " is the ULTIMATE BATTLE MAGE!!!!!");
        }
    }

    public static void turnDiceMage() {
        DiceMage mage = (DiceMage) Turn.getActivePlayer();
        System.out.println(mage.color + " Mage " + mage.name + "'s turn");
    }

}
