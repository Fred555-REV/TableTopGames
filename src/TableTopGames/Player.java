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
    int scoreSheet[] = new int[13];
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
        String ready = scan.nextLine();
        if(ready.equalsIgnoreCase("Chicken")){
            System.out.println("chicken");
        }
        System.out.println("roll 1");
        for (Die die : player.dice) {
            Die.roll(die);
        }
        Display.dice(player);
        for (int i = 2; i <= 3; i++) {
            System.out.println("roll " + i);
            System.out.println("how many dice would you like to roll?");
            int diceAmount = scan.nextInt();
            Display.dice(player);
            List<Integer> diceToRoll = new ArrayList<>();
            if (diceAmount == 0) {
                i = 4;
            } else {
                System.out.println("which die/dice? 1/2/3/4/5");
            }

            for (int j = 0; j < diceAmount; j++) {

                int rollThis = scan.nextInt() - 1;
                diceToRoll.add(rollThis);

                if (j == diceAmount - 1) {
                    Die.roll(player.dice, diceToRoll);
                }
            }
            if (i == 3 || diceAmount == 0) {
                System.out.println("\nFinal Dice");
                Display.dice(player);
                Score.add(player);
                Display.score(player);
            } else {
                Display.dice(player);
            }
        }
        scan.nextLine();
        Turn.turnPass();
    }
}
