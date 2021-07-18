package TableTopGames;

public class Test {
    public static void main(String[] args) {

        System.out.println("player 1\n");
        Player player1 = new Player("player 1", "red");
        Player.getDice(player1);
        player1.dice[0].number = 5;
        player1.dice[1].number = 5;
        player1.dice[2].number = 5;
        player1.dice[3].number = 5;
        player1.dice[4].number = 5;
        Display.dice(player1);
        Score.add(player1);
        Display.score(player1);

        player1.dice[0].number = 6;
        player1.dice[1].number = 6;
        player1.dice[2].number = 6;
        player1.dice[3].number = 6;
        player1.dice[4].number = 6;
        Display.dice(player1);
        Score.add(player1);
        Display.score(player1);

        player1.dice[0].number = 4;
        player1.dice[1].number = 4;
        player1.dice[2].number = 4;
        player1.dice[3].number = 4;
        player1.dice[4].number = 4;
        Display.dice(player1);
        Score.add(player1);
        Display.score(player1);

        player1.dice[0].number = 3;
        player1.dice[1].number = 3;
        player1.dice[2].number = 3;
        player1.dice[3].number = 3;
        player1.dice[4].number = 3;
        Display.dice(player1);
        Score.add(player1);
        Display.score(player1);



//        System.out.println("\nplayer 2\n");
//        Player player2 = new Player("player 2", "blue");
//        Player.getDice(player2);
//        player2.dice[0].number = 6;
//        player2.dice[1].number = 6;
//        player2.dice[2].number = 5;
//        player2.dice[3].number = 5;
//        player2.dice[4].number = 6;
//        Display.dice(player2);
//        Display.possibleScores(player2);
    }
}
