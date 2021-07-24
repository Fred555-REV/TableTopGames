package TableTopGames;

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
        DiceMage mage = new DiceMage("fred", "c");
        mage.getDice(3, 3);
        System.out.println(mage.dice);
    }
}
