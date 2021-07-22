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
    int scoreSheet[] = new int[14];
    Die[] dice = new Die[5];

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
    }

    public void getDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }
}
