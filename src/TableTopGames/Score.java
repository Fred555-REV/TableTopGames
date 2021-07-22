package TableTopGames;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Score {
    public static void add(Player player) {
        Scanner scan = new Scanner(System.in);
        Display.possibleScores(player);
        System.out.println("When done looking at possible scores enter \"done\".");
        String nice = scan.next().trim();
        if (nice.equalsIgnoreCase("nice")) {
            System.out.println(nice);
        }
        System.out.println("These are available scores to add or erase");
        Display.availableScores(player);
        System.out.println("Which score would you like to add? enter index");
        int index = scan.nextInt();
        scan.nextLine();
        if (player.scoreSheet[index] != 5) {
            player.scoreSheet[index] = 5;
            switch (index) {
                case 0:
                    Score.ones(player);
                    Score.bonus(player);
                    break;
                case 1:
                    Score.twos(player);
                    Score.bonus(player);
                    break;
                case 2:
                    Score.threes(player);
                    Score.bonus(player);
                    break;
                case 3:
                    Score.fours(player);
                    Score.bonus(player);
                    break;
                case 4:
                    Score.fives(player);
                    Score.bonus(player);
                    break;
                case 5:
                    Score.sixes(player);
                    Score.bonus(player);
                    break;
                case 6:
                    Score.threeOAK(player);
                    Score.bonus(player);
                    break;
                case 7:
                    Score.fourOAK(player);
                    Score.bonus(player);
                    break;
                case 8:
                    Score.fullHouse(player);
                    Score.bonus(player);
                    break;
                case 9:
                    Score.smStraight(player);
                    Score.bonus(player);
                    break;
                case 10:
                    Score.lgStraight(player);
                    Score.bonus(player);
                    break;
                case 11:
                    Score.fiveOAK(player);
                    Score.bonus(player);
                    break;
                case 12:
                    Score.chance(player);
                    Score.bonus(player);
                    break;
            }
        } else {
            Score.add(player);
        }
//        scan.close();
    }

    public static void bonus(Player player) {
        if (player.bonus >= 63 && player.scoreSheet[13] != 5) {
            player.scoreSheet[13] = 5;
            player.score += 35;
            System.out.println("You got the bonus " + player.bonus + "/" + 63 + " +35 points");
        } else if (player.scoreSheet[13] != 5) {
            System.out.println("Bonus: " + player.bonus + "/" + 63);
        }
    }

    public static void ones(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 1) {
                total++;
            }
        }
        if (total != 0) {
            System.out.println("Ones = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void twos(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 2) {
                total += 2;
            }
        }
        if (total != 0) {
            System.out.println("Twos = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void threes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 3) {
                total += 3;
            }
        }
        if (total != 0) {
            System.out.println("Threes = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void fours(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 4) {
                total += 4;
            }
        }
        if (total != 0) {
            System.out.println("Fours = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void fives(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 5) {
                total += 5;
            }
        }
        if (total != 0) {
            System.out.println("Fives = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void sixes(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            if (player.dice.get(i).number == 6) {
                total += 6;
            }
        }
        if (total != 0) {
            System.out.println("Sixes = " + total);
            player.score += total;
            player.bonus += total;
        }
    }

    public static void threeOAK(Player player) {
        for (int i = 0; i < player.dice.size(); i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < player.dice.size(); j++) {
                if (player.dice.get(i).number == player.dice.get(j).number) {
                    count++;
                    total += player.dice.get(i).number;
                }
            }
//            System.out.println("count " + count);
            if (count == 3) {
                System.out.println("Three of a Kind = " + total);
                player.score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fourOAK(Player player) {
        for (int i = 0; i < player.dice.size(); i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < player.dice.size(); j++) {
                if (player.dice.get(i).number == player.dice.get(j).number) {
                    count++;
                    total += player.dice.get(i).number;
                }
            }
//            System.out.println("count " + count);
            if (count == 4) {
                System.out.println("Four of a Kind = " + total);
                player.score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void fullHouse(Player player) {
        boolean isDone = false;
        for (int i = 0; i < player.dice.size(); i++) {
            int count1 = 0;
            int count2;
            int threeOAK = 0;
            for (int j = 0; j < player.dice.size(); j++) {
                if (player.dice.get(i).number == player.dice.get(j).number) {
                    count1++;
                }
            }
            if (count1 == 3) {
                threeOAK = player.dice.get(i).number;
            }

            for (int k = 0; k < player.dice.size(); k++) {
                count2 = 0;
                for (int l = 0; l < player.dice.size(); l++) {
                    if (player.dice.get(k).number != threeOAK && player.dice.get(k).number == player.dice.get(l).number) {
                        count2++;
                    }
                }
                if (count2 % 2 == 0 && threeOAK != 0 && count2 != 0) {
                    System.out.println("Full House = 25");
                    player.score += 25;
                    isDone = true;
                }
                if (isDone) {
                    break;
                }
            }
            if (isDone) {
                break;
            }


        }
    }

    public static void smStraight(Player player) {
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            for (int j = 0; j < player.dice.size(); j++) {
//                System.out.println("j " + j + " i " + i);

//                System.out.println("dupe " + duplicateCount + " count " + count);
                if (player.dice.get(i).number == player.dice.get(j).number && j != i) {
                    duplicateCount++;
                }
                if (player.dice.get(i).number == player.dice.get(j).number + 1) {
                    count++;
                }
            }
        }
        if (count == 3 && duplicateCount == 0) {
            System.out.println("Small Straight = 30");
            player.score += 30;
        } else if (count == 4 && duplicateCount == 2) {
            System.out.println("Small Straight = 30");
            player.score += 30;
        }
    }

    public static void lgStraight(Player player) {
//        Arrays.sort(player.dice);
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            for (int j = 0; j < player.dice.size(); j++) {
                if (player.dice.get(i).number == player.dice.get(j).number && j != i) {
                    duplicateCount++;
                }
                if (player.dice.get(i).number == player.dice.get(j).number + 1) {
                    count++;
                }
            }
        }
        if (count == 4 && duplicateCount == 0) {
            System.out.println("Large Straight = 40");
            player.score += 40;
        }
    }

    public static void fiveOAK(Player player) {
        for (int i = 0; i < player.dice.size(); i++) {
            int count = 0;
            for (int j = 0; j < player.dice.size(); j++) {
                if (player.dice.get(i).number == player.dice.get(j).number) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 5) {
                System.out.println("Yahtzee! = 50");
                player.score += 50;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void chance(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            total += player.dice.get(i).number;
        }
        System.out.println("Chance = " + total);
        player.score += total;
    }
}
