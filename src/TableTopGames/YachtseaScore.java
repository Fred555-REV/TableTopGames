package TableTopGames;

import java.util.Scanner;

public class YachtseaScore {

    public static void addYachtsea(YachtseaPlayer player) {
        Scanner scan = new Scanner(System.in);
        DisplayYachtsea.possibleYachtseaScores(player);
        System.out.println("When done looking at possible scores enter \"done\".");
        String nice = scan.next().trim();
        if (nice.equalsIgnoreCase("nice")) {
            System.out.println(nice);
        }
        System.out.println("These are available scores to add or erase");
        DisplayYachtsea.availableYachtseaScores(player);
        System.out.println("Which score would you like to add? enter index");
        int index = scan.nextInt();
        scan.nextLine();
        if (player.scoreSheet[index] != 5) {
            player.scoreSheet[index] = 5;
            switch (index) {
                case 0:
                    YachtseaScore.ones(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 1:
                    YachtseaScore.twos(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 2:
                    YachtseaScore.threes(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 3:
                    YachtseaScore.fours(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 4:
                    YachtseaScore.fives(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 5:
                    YachtseaScore.sixes(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 6:
                    YachtseaScore.threeOAK(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 7:
                    YachtseaScore.fourOAK(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 8:
                    YachtseaScore.fullHouse(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 9:
                    YachtseaScore.smStraight(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 10:
                    YachtseaScore.lgStraight(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 11:
                    YachtseaScore.fiveOAK(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
                case 12:
                    YachtseaScore.chance(player);
                    YachtseaScore.bonusYachtsea(player);
                    break;
            }
        } else {
            YachtseaScore.addYachtsea(player);
        }
//        scan.close();
    }

    public static void bonusYachtsea(YachtseaPlayer player) {
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
            if (player.dice.get(i).value == 1) {
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
            if (player.dice.get(i).value == 2) {
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
            if (player.dice.get(i).value == 3) {
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
            if (player.dice.get(i).value == 4) {
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
            if (player.dice.get(i).value == 5) {
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
            if (player.dice.get(i).value == 6) {
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
                if (player.dice.get(i).value == player.dice.get(j).value) {
                    count++;
                    total += player.dice.get(i).value;
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
                if (player.dice.get(i).value == player.dice.get(j).value) {
                    count++;
                    total += player.dice.get(i).value;
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
                if (player.dice.get(i).value == player.dice.get(j).value) {
                    count1++;
                }
            }
            if (count1 == 3) {
                threeOAK = player.dice.get(i).value;
            }

            for (int k = 0; k < player.dice.size(); k++) {
                count2 = 0;
                for (int l = 0; l < player.dice.size(); l++) {
                    if (player.dice.get(k).value != threeOAK && player.dice.get(k).value == player.dice.get(l).value) {
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
                if (player.dice.get(i).value == player.dice.get(j).value && j != i) {
                    duplicateCount++;
                }
                if (player.dice.get(i).value == player.dice.get(j).value + 1) {
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
                if (player.dice.get(i).value == player.dice.get(j).value && j != i) {
                    duplicateCount++;
                }
                if (player.dice.get(i).value == player.dice.get(j).value + 1) {
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
                if (player.dice.get(i).value == player.dice.get(j).value) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 5) {
                System.out.println("Yachtsea! = 50");
                player.score += 50;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public static void chance(Player player) {
        int total = 0;
        for (int i = 0; i < player.dice.size(); i++) {
            total += player.dice.get(i).value;
        }
        System.out.println("Chance = " + total);
        player.score += total;
    }
}
