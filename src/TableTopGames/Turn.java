package TableTopGames;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Turn {
    public static int turnCounter = 0;
    public static List<Player> players = new ArrayList<>();
    public static final int MAX_PLAYERS = 6;
    public static final int MIN_PLAYERS = 1;
    public static int turnMax = 0;

    public static void createPlayers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players will there be?");
        int playerNum;
        do {
            playerNum = scan.nextInt();
            scan.nextLine();
        } while (playerNum < MIN_PLAYERS || playerNum > MAX_PLAYERS);

        while (players.size() < playerNum) {

            System.out.println("Enter name");
            String name = scan.next().trim();
            System.out.println("Enter color");
            String color = scan.next().trim();

            Player player = new Player(name, color);
            Turn.addPlayer(player);
        }
    }

    public static void createPlayers(int scoreAmount, int diceAmount, int numOfSides) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players will there be?");
        int playerNum;
        do {
            playerNum = scan.nextInt();
            scan.nextLine();
        } while (playerNum < MIN_PLAYERS || playerNum > MAX_PLAYERS);

        while (players.size() < playerNum) {

            System.out.println("Enter name");
            String name = scan.next().trim();
            System.out.println("Enter color");
            String color = scan.next().trim();

            Player player = new Player(name, color, scoreAmount);
            Turn.addPlayer(player);
            player.getDice(diceAmount, numOfSides);
        }
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static Player getActivePlayer() {
        return Turn.players.get(Turn.turnCounter);
    }

    public static void setTurns(int maxTurns) {
        turnMax = maxTurns * players.size();
    }

    public static void turnPass() {
        if (turnCounter == players.size() - 1) {
            turnCounter = 0;
        } else {
            turnCounter++;
        }
        turnMax--;
    }

    public static void turnBack() {
        turnCounter--;
        turnMax++;//for accidents
    }

    public static void displayTurn() {
        System.out.println(getActivePlayer().name + "'s or " + getActivePlayer().color + "'s turn ");
    }

    public static void displayTurnsLeft() {
        System.out.println(turnMax + " turns left in game");
    }
}
