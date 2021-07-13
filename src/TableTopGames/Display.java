package TableTopGames;

public class Display {
    public static void dice(Player player) {
        for (int i = 0; i < 5; i++) {
            System.out.println(player.dice[i].number);
        }
    }

    public static void possibleScores(Player player) {
        Display.ones(player);
        Display.twos(player);
        Display.threes(player);
        Display.fours(player);
        Display.fives(player);
        Display.sixes(player);
        Display.threeOAK(player);
        Display.fourOAK(player);
        Display.fullHouse(player);
        Display.smStraight(player);
        Display.lgStraight(player);
        Display.fiveOAK(player);
        Display.chance(player);
    }

    public static void ones(Player player) {

    }

    public static void twos(Player player) {

    }

    public static void threes(Player player) {

    }

    public static void fours(Player player) {

    }

    public static void fives(Player player) {

    }

    public static void sixes(Player player) {

    }

    public static void threeOAK(Player player) {

    }

    public static void fourOAK(Player player) {

    }

    public static void fullHouse(Player player) {

    }

    public static void smStraight(Player player) {

    }

    public static void lgStraight(Player player) {

    }

    public static void fiveOAK(Player player) {

    }

    public static void chance(Player player) {

    }
}
