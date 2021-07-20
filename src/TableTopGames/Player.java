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
    int bonus;
    int scoreSheet[] = new int[14];
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
        if (ready.equalsIgnoreCase("Chicken")) {
            System.out.println("chicken");
        }
        System.out.println("roll 1");
        for (Die die : player.dice) {
            Die.roll(die);
        }
        Display.dice(player);
        for (int i = 2; i <= 3; i++) {
            List<Integer> diceToRoll = new ArrayList<>();

            System.out.println("enter die/dice to re-roll. 0 if none, 1-5 (position) followed by spaces");


            String input = scan.nextLine();
            String[] inputArr = input.split(" ");
            for (int j = 0; j < inputArr.length; j++) {
                for (String number : inputArr) {
                    diceToRoll.add(Integer.parseInt(number) - 1);
                }
                if (j == inputArr.length - 1) {
                    Die.roll(player.dice, diceToRoll);
                }
            }
            if (i == 3 || inputArr.length == 0) {
                System.out.println("Final Dice");
                Display.dice(player);
                Score.add(player);
                Display.score(player);
            } else {
            System.out.println("roll " + i);
                Display.dice(player);
            }
        }
//        scan.next();
        Turn.turnPass();
    }
}
