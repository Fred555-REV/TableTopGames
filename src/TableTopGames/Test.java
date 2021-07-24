package TableTopGames;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

//        System.out.println("player 1\n");
//        YahtzeePlayer player1 = new YahtzeePlayer("player 1", "red", 14);
//        player1.getDice(5, 6);
//        player1.dice.get(0).value = 5; // was displaying full house 3 times as possible score
//        player1.dice.get(1).value = 3;
//        player1.dice.get(2).value = 3;
//        player1.dice.get(3).value = 5;
//        player1.dice.get(4).value = 3;
//        Display.dice(player1);
//        Score.addYahtzee(player1);
//        Display.score(player1);
        DiceMage mage = new DiceMage("Fred", "Red");
        mage.addDice(20);
        mage.powerLevel = 20;
        System.out.println(mage.color + " Mage " + mage.name + "'s turn");
        Display.dice(mage);
//        mage.dice.get(0).value = 5;
//        mage.dice.get(1).value = 4;
//        mage.dice.get(2).value = 4;
//        mage.dice.get(3).value = 3;
//        mage.dice.get(4).value = 4;
//        mage.dice.get(5).value = 6;

        mage.rollAll();
        Display.dice(mage);
        mage.addMana();
        mage.mana += 100;
        mage.stats();
        while (!mage.hasSecret) {
            mage.addCompanion();
        }
    }
}
