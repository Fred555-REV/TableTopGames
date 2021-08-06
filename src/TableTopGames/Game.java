package TableTopGames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static boolean isRunning;

    public static void run() {
        Turn.reset();
        isRunning = true;
        Display.allGames();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of game you want to play or 0 if you want to exit");
        int index = scan.nextInt();
        switch (index) {
            case 1:
                runYachtsea();
                break;
            case 2:
                runHighLow();
                break;
            case 3:
                runDiceMage();
                break;
            default:
                System.out.println("Error: " + index + " not a game");
                run();
                break;
        }
    }

    public static void runYachtsea() {
        System.out.println("Welcome to Yachtsea.");
        Turn.createYachtseaPlayers(14, 5, 6);
        Turn.setTurns(13);
        while (Turn.turnMax != 0) {
            Turn.displayTurn();
            Turn.displayTurnsLeft();
            playYachtsea((YachtseaPlayer) Turn.getActivePlayer());
            if (!isRunning) {
                break;
            }
        }
        if (Turn.players.size() > 1) {
            Display.winner();
        }
        run();
    }

    public static void runHighLow() {
        System.out.println("Welcome to High Low");
        Turn.createPlayers();
        for (Player player : Turn.players) {
            playHighLow(player);
            if (!isRunning) {
                break;
            }
        }
        run();
    }

    public static void runDiceMage() {
        isRunning = true;
        System.out.println("Welcome to Dice Mage");
        Turn.createMages(6, 6);
        while (isRunning) {
            playDiceMage((DiceMage) Turn.getActivePlayer());
            for (Player player : Turn.players) {
                DiceMage mage = (DiceMage) player;
                if (mage.health <= 0) {
                    isRunning = false;
                    break;
                }
            }
            if (!isRunning) {
                break;
            }
        }
        Display.survivor();
        run();
    }

    public static void playDiceMage(DiceMage mage) {
        Scanner scan = new Scanner(System.in);

        Display.turnDiceMage();

        System.out.println("ready?");
        String ready = scan.nextLine();
        if (ready.equals("EXIT")) {
            System.out.println("ok");
            isRunning = false;
        }

        mage.rollAll();
        mage.addMana();
        mage.stats();
        mage.takeAction();

        Turn.turnPass();
    }

    public static void playYachtsea(YachtseaPlayer player) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ready?");
        String ready = scan.nextLine();
        if (ready.equalsIgnoreCase("exit")) {
            System.out.println("ok");
            isRunning = false;
        }
        System.out.println("roll 1");
        for (Die die : player.dice) {
            die.roll();
        }
        Display.dice(player.dice);
        for (int i = 2; i <= 3; i++) {

            System.out.println("roll " + i);
            Display.dice(player.dice);
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
                Display.dice(player.dice);
                player.addYachtsea();
                Display.score(player);
            } else {
                Display.dice(player.dice);
            }
        }
//        scan.next();
        Turn.turnPass();
    }

    public static void playHighLow(Player player) {
        Scanner scan = new Scanner(System.in);
        if (player.dice.size() < 1) {
            System.out.println("How many dice do you want to play Higher or Lower with?");
            int diceAmount = scan.nextInt();
            scan.nextLine();
            player.addDice(diceAmount, 6);
        } else {
            System.out.println("Do you want to change dice amount? y/n");
            String change = scan.next();
            if (change.equalsIgnoreCase("y")) {
                System.out.println("How many dice do you want to play Higher or Lower with?");
                int diceAmount = scan.nextInt();
                scan.nextLine();
                player.resetDice();
                player.addDice(diceAmount, 6);
            }
        }
        System.out.println("The values go from " + player.dice.size() + " to " + (player.dice.size() * 6));
        boolean didLose = false;
        player.rollAll();
        player.score = 0;

        while (!didLose) {
            System.out.println();
            int total = player.getTotalDiceValue(player.dice);
            int newTotal;
            Display.dice(player.dice);
            System.out.println(total);
            System.out.println("Higher or lower? enter: h/l");
            String inputHL = scan.next();
            player.rollAll();
            newTotal = player.getTotalDiceValue(player.dice);
            Display.dice(player.dice);
            System.out.println(newTotal);
            boolean isLarger = newTotal > total;

            if (inputHL.equals("h")) { //guessed higher
                if (!isLarger) {
                    didLose = true;
                    System.out.println("Sorry you lost");
                } else {
                    System.out.println("\nYou won");
                    player.score += 1;
                }
            } else { //guessed lower
                if (isLarger || total == newTotal) {
                    didLose = true;
                    System.out.println("Sorry you lost");
                } else {
                    System.out.println("\nyou won");
                    player.score += 1;
                }

            }

            System.out.println("Your score is " + player.score);

            if (player.score > player.winStreak) {
                player.winStreak = player.score;
            }

            System.out.println("Your win streak is " + player.winStreak);

        }

        System.out.println("Want to play again? enter y/n");
        String playAgain = scan.next();

        if (playAgain.equalsIgnoreCase("y")) {
            Game.playHighLow(player);
        } else {
            System.out.println("Good Bye");
        }
    }

}
