package TableTopGames;

import java.util.ArrayList;
import java.util.List;

public class Die {
    int number;
    int numOfSides;

    public Die() {
        this.numOfSides = 6;
    }

    public Die(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public void roll() {
        number = (int) Math.floor(Math.random() * numOfSides) + 1;
    }


    public static void roll(List<Die> dice, List<Integer> diceToRoll) {

        for (int i = 0; i < dice.size(); i++) {

            for (Integer integer : diceToRoll) {
                if (i == integer) {
                    dice.get(i).roll();
                }

            }
        }
    }
}
