package TableTopGames;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
    public String name;
    public String color;
    public int score;
    public int bonus;
    public List<Die> dice;
    public int winStreak;

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

    public void resetDice() {
        dice.removeAll(dice);
    }

    public void rollAll() {
        for (int i = 0; i < dice.size(); i++) {
            dice.get(i).roll();
        }
    }

}
