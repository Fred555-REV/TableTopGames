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
    Die[] dice = new Die[5];

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.score = 0;
    }

    public static void getDice(Player player) {
        for (int i = 0; i < 5; i++) {
            player.dice[i] = new Die();
        }
    }

    public static void play(Player player) {
        System.out.println("ready?");
        scan.nextLine();
        System.out.println("roll 1");
        for (Die die : player.dice) {
            Die.roll(die);
            System.out.println(die.number);
        }
        for (int i = 2; i <= 3; i++) {
            System.out.println("roll " + i);
            System.out.println("how many dice would you like to roll?");
            int diceAmount = scan.nextInt();
            Display.dice(player);
            List<Integer> diceToRoll = new ArrayList<>();
            for (int j = 0; j < diceAmount; j++) {

                System.out.println("which die? 1/2/3/4/5");
                int rollThis = scan.nextInt() - 1;
                diceToRoll.add(rollThis);

                if (j == diceAmount - 1) {
                    Die.roll(player.dice, diceToRoll);
                }
            }
            System.out.println("Final Dice");
            Display.dice(player);
        }
        Turn.turnPass();
    }
}
