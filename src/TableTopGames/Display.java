package TableTopGames;


import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Display {
    public static void dice(List<Die> list) {
        Collections.sort(list, Die::compareTo);
        System.out.println(Color.BLUE);
        StringBuilder dice = new StringBuilder();
        StringBuilder part1 = new StringBuilder();
        StringBuilder part2 = new StringBuilder();
        StringBuilder part3 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            part1.append("/¯¯¯\\");
            part2.append("| ").append(list.get(i).value).append(" |");
            part3.append("\\___/");
        }
        part1.append("\n");
        part2.append("\n");
        part3.append("\n");
        dice.append(part1).append(part2).append(part3);
        System.out.println(dice);
        System.out.println(Color.RESET);
    }

    public static void allGames() {
        System.out.println("Yachtsea, index: 1");
        System.out.println("HighLow, index: 2");
        System.out.println("DiceMage, index: 3");
    }

    public static void availableActions(DiceMage mage) {
//        System.out.println();
        System.out.println("Actions");
        int powerUpCost;
        if (mage.dice.size() > 6) {
            powerUpCost = 4 + (mage.dice.size() - 6);
        } else {
            powerUpCost = 4;
        }
        if (mage.mana >= powerUpCost) {
            System.out.println("(1) increase power for " + powerUpCost + " and increases health by 1(ends turn)");
        }
        if (mage.mana >= 7) {
            System.out.println("(2) summon a companion for min 7 mana(ends turn)");

        }
        if (mage.companionDice.size() > 0) {
            System.out.println("(3) attack with companions(ends turn)");
        }
        System.out.println("(4) view field(doesn't end turn)");
        System.out.println("(5) end turn");
        System.out.print(Color.RESET);
    }

    public static void availableCompanions(DiceMage mage) {
        System.out.println("Companions");
        if (mage.mana >= 7) {
            System.out.println("common 1d3    \tcost: 7 mana\tindex: 1");
        }
        if (mage.mana >= 8) {
            System.out.println("uncommon 1d4  \tcost: 8 mana\tindex: 2");

        }
        if (mage.mana >= 9) {
            System.out.println("rare 1d6      \tcost: 9 mana\tindex: 3");

        }
        if (mage.mana >= 10) {
            System.out.println("epic 1d8      \tcost: 10 mana\tindex: 4");

        }
        if (mage.dice.size() >= 10) {
            System.out.println("legendary 1d20\tcost: 5 die \tindex: 5");
        }
    }

    public static void den(DiceMage mage) {
        System.out.println(Color.getColor(mage) + "Den:");
        //powerlevels 3 4 6 8 20
        for (int i = 0; i <= 20; i++) {
            if (mage.companions.containsKey(i) && mage.companions.get(i) > 0) {
                System.out.printf(" %sd%s", mage.companions.get(i), i);
            }

        }
        System.out.println(Color.RESET);
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
        System.out.println(Color.getColor(mage) + mage.color + " Mage " + mage.name + "'s turn" + Color.RESET);
    }

}
