package TableTopGames;


import java.util.Arrays;

public class Display {
    public static void dice(Player player) {
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("/¯¯¯\\");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("|" + " " + player.dice[i].number + " " + "|");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("\\___/");
        }
        System.out.println();
    }

    public static void possibleScores(Player player) {

        Display.ones(player);
        Display.twos(player);
        Display.threes(player);
        Display.fours(player);
        Display.fives(player);
        Display.sixes(player);
        //^ ^ ^ ^ upper ^ ^ ^ ^
        //v v v v lower v v v v
        Display.threeOAK(player);   // of a kind
        Display.fourOAK(player);    // of a kind
        Display.fullHouse(player);
        Display.smStraight(player);
        Display.lgStraight(player);
        Display.fiveOAK(player);    // of a kind
        Display.chance(player);
    }

    public static void ones(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 1) {
                total++;
            }
        }
        if (total != 0) {
            System.out.println("Ones = " + total);
        }
    }

    public static void twos(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 2) {
                total += 2;
            }
        }
        if (total != 0) {
            System.out.println("Twos = " + total);
        }
    }

    public static void threes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 3) {
                total += 3;
            }
        }
        if (total != 0) {
            System.out.println("Threes = " + total);
        }
    }

    public static void fours(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 4) {
                total += 4;
            }
        }
        if (total != 0) {
            System.out.println("Fours = " + total);
        }
    }

    public static void fives(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 5) {
                total += 5;
            }
        }
        if (total != 0) {
            System.out.println("Fives = " + total);
        }
    }

    public static void sixes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            if (player.dice[i].number == 6) {
                total += 6;
            }
        }
        if (total != 0) {
            System.out.println("Sixes = " + total);
        }
    }

    public static void threeOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 3) {
                System.out.println("Three of a Kind = ");
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fourOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 4) {
                System.out.println("Four of a Kind = ");
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fullHouse(Player player) {
        int count1 = 0;
        int count2 = 0;
        int threeOAK = 0;
        for (int i = 0; i < player.dice.length; i++) {
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count1++;
                }
            }
            if (count1 == 3) {
                threeOAK = player.dice[i].number;
            }
//            System.out.println("count2 " + count2);

            for (int k = 0; k < player.dice.length; k++) {
                if (player.dice[i].number != threeOAK && player.dice[i].number == player.dice[k].number) {
                    count2++;
//                    System.out.println("count2 " + count2);
                }
            }
//            System.out.println("count2 " + count2);

            if (count2 == 2 && threeOAK != 0) {
                System.out.println("Full House = 25");
                break;
            }
        }
    }

    public static void smStraight(Player player) {
        int count = 0;
        for (int i = 0; i < player.dice.length; i++) {
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number + 1) {
                    count++;
                }
            }
        }
        if (count == 3) {
            System.out.println("Small Straight = 30");
        }
    }

    public static void lgStraight(Player player) {
//        Arrays.sort(player.dice);
        int count = 0;
        for (int i = 0; i < player.dice.length; i++) {
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number + 1) {
                    count++;
                }
            }
        }
        if (count == 4) {
            System.out.println("Large Straight = 40");
        }
    }

    public static void fiveOAK(Player player) {
        for (int i = 0; i < player.dice.length; i++) {
            int count = 0;
            for (int j = 0; j < player.dice.length; j++) {
                if (player.dice[i].number == player.dice[j].number) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 5) {
                System.out.println("Yahtzee! = 50");
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void chance(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.length; i++) {
            total += player.dice[i].number;
        }
        System.out.println("chance = " + total);
    }
}
