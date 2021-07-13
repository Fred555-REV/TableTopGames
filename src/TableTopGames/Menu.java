package TableTopGames;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        // write your code here
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
            Turn.players.add(player);
            Player.getDice(player);
        }
        while (scan.hasNext()) {
            Turn.displayTurn();
        }
    }
}
