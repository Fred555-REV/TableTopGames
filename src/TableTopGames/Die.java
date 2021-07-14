package TableTopGames;

import java.util.ArrayList;
import java.util.List;

public class Die {
    int number;

    public Die() {

    }

    public static void initialRoll(Die die) {
        die.number = (int) Math.floor(Math.random() * 6) + 1;

    }

    public static void roll(Die[] dice, List<Integer> diceToRoll) {
        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < diceToRoll.size(); j++) {
                if (i == diceToRoll.get(j)) {
                    dice[i].number = (int) Math.floor(Math.random() * 6) + 1;
                }
            }
        }
    }
}
