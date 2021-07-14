package TableTopGames;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turn {
    public static int turnCounter = 0;
    public static List<Player> players = new ArrayList<>();

    public static int turnMax = 0;
    public static void createPlayers(){
        Scanner scan = new Scanner(System.in);


        System.out.println("How many players will play?");
        int playerNum = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < playerNum; i++) {

            System.out.println("Enter name");
            String name = scan.nextLine();
            System.out.println("Enter color");
            String color = scan.nextLine();

            Player player = new Player(name, color);
            Turn.addPlayer(player);
            Player.getDice(player);
        }
    }
    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void setTurns() {
        turnMax = 13 * players.size();
    }

    public static void turnPass() {
        if (turnCounter == players.size() - 1) {
            turnCounter = 0;
        } else {
            turnCounter++;
        }
        turnMax--;
        displayTurn();
    }

    public static void turnBack(Player player) {
        turnCounter--;//for accidents
    }

    public static void displayTurn() {
        System.out.println(players.get(turnCounter).name + "'s or " + players.get(turnCounter).color + "'s turn ");
    }
    public static void displayTurnsLeft() {
        System.out.println(turnMax+" turns left in game");
    }
}
