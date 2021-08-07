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
        System.out.println(Color.BLACK_BOLD);
        Mage mage = new Mage("Fred", "Red");
//        mage.addDice(6);
        System.out.println(mage.color + " Mage " + mage.name + "'s turn");
//        mage.dice.get(0).value = 5;
//        mage.dice.get(1).value = 4;
//        mage.dice.get(2).value = 4;
//        mage.dice.get(3).value = 3;
//        mage.dice.get(4).value = 4;
//        mage.dice.get(5).value = 6;
        mage.mana = 100;
        mage.health = 2;
        while (mage.powerLevel < 25) {
        mage.addDice(10,12);
        mage.rollAll();
        Display.dice(mage.dice);
//            mage.rollAll();
//            mage.addMana();
//            mage.stats();
//            mage.takeAction();
            mage.stats();
            mage.addCompanion();
        }


//        mage.rollAll();
//        Display.dice(mage.dice);
//        mage.addMana();
//        mage.mana += 100;
//        mage.stats();
//        while (!mage.hasSecret) {
//            mage.addCompanion();
//        }
    }
}
