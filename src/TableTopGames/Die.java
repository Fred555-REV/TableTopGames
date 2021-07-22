package TableTopGames;

import java.util.ArrayList;
import java.util.List;

public class Die {
    int number;
    int numOfSides;

    public Die(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public static void roll(Die die) {
        die.number = (int) Math.floor(Math.random() * die.numOfSides) + 1;
    }


    public static void roll(List<Die> dice, List<Integer> diceToRoll) {

        for (int i = 0; i < dice.size(); i++) {

            for (Integer integer : diceToRoll) {
                if (i == integer) {
                    roll(dice.get(i));
                }

            }
        }
    }
}
