package TableTopGames;

public class Dice {
    int number;

    public Dice() {

    }

    public static void roll(Dice dice) {
        dice.number = (int) Math.floor(Math.random() * 6) + 1;
    }
}
