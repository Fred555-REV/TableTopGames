package TableTopGames;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    String color;
    int score;
    int bonus;
    List<Die> dice;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
        this.dice = new ArrayList<>();
    }

    public int getTotalDiceValue(List<Die> list) {
        int total = 0;
        for (Die die : list) {
            total += die.value;
        }
        return total;
    }

    public void addDice(int diceAmount) {
        for (int i = 0; i < diceAmount; i++) {
            dice.add(new Die());
        }
    }

    public void addDice(int diceAmount, int numOfSides) {
        for (int i = 0; i < diceAmount; i++) {
            dice.add(new Die(numOfSides));
        }
    }

    public void rollAll() {
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).roll();
        }
    }
}
