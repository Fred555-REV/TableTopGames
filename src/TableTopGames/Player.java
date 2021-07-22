package TableTopGames;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    String name;
    String color;
    int score;
    int bonus;
    int[] scoreSheet;
    List<Die> dice;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
        this.dice = new ArrayList<>();
    }

    public Player(String name, String color, int scoreAmount) {
        this.name = name;
        this.color = color;
        this.score = 0;
        this.scoreSheet = new int[scoreAmount];
        this.dice = new ArrayList<>();
    }

    public int getTotalDiceValue() {
        int total = 0;
        for (Die die : dice) {
            total += die.number;
        }
        return total;
    }

    public void getDice(int diceAmount) {
        for (int i = 0; i < diceAmount; i++) {
            dice.add(new Die());
        }
    }

    public void getDice(int diceAmount, int numOfSides) {
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
