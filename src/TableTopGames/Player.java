package TableTopGames;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public static Scanner scan = new Scanner(System.in);
    String name;
    String color;
    int score;
    Dice[] dice = new Dice[5];

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
    }

    public static void getDice(Player player) {
        for (int i = 0; i < 5; i++) {
            player.dice[i] = new Dice();
        }
    }

    public static void play(Player player) {
        System.out.println("roll 1");
        for (Dice die : player.dice) {
            Dice.roll(die);
            System.out.println(die);
        }
        for (int i = 2; i <= 3; i++) {
            System.out.println("roll " + i);
            System.out.println("how many dice would you like to roll?");
            int diceAmount = scan.nextInt();
            for (int j = 0; j < diceAmount; j++) {

                System.out.println("which die?");
                int rollThis = scan.nextInt();
            }
            Display.dice(player);
        }
        Turn.turnPass();
    }
}
