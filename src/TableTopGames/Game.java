package TableTopGames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void runYahtzee() {
        Turn.createPlayers();
        Turn.setTurns();
        while (Turn.turnMax != 0) {
            Turn.displayTurn();
            Turn.displayTurnsLeft();
            play(Turn.getActivePlayer());
        }
    }

    public static void play(Player player) {
        Scanner scan = new Scanner(System.in);
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

            System.out.println("roll " + i);
            Display.dice(player);
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
                System.out.println("\nFinal Dice");
                Display.dice(player);
                Score.add(player);
                Display.score(player);
            } else {
                Display.dice(player);
            }
        }
//        scan.next();
        Turn.turnPass();
    }
}
