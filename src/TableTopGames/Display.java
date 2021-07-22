package TableTopGames;


import java.util.ArrayList;
import java.util.List;

public class Display {
    public static void dice(Player player) {
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("/¯¯¯\\");
        }
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("|" + " " + player.dice.get(i).value + " " + "|");
        }
        System.out.println();
        for (int i = 0; i < player.dice.size(); i++) {
            System.out.print("\\___/");
        }
        System.out.println();
    }

    public static void allGames() {
        System.out.println("Yahtzee, index: 1");
        System.out.println("HighLow, index: 2");
    }

    public static void score(Player player) {
        System.out.println("Score is " + player.score + " for " + player.name);
    }

    //    public static void scoreIndex() {
//        System.out.println("ones index = 0");
//        System.out.println("twos index = 1");
//        System.out.println("threes index = 2");
//        System.out.println("fours index = 3");
//        System.out.println("fives index = 4");
//        System.out.println("sixes index = 5");
//        System.out.println("three of a kind index = 6");
//        System.out.println("four of a kind index = 7");
//        System.out.println("full house index = 8");
//        System.out.println("small straight index = 9");
//        System.out.println("large straight index = 10");
//        System.out.println("five of a kind index = 11");
//        System.out.println("chancge index = 12");
//    }
    public static void winner() {
        Player winner = Turn.players.get(0);
        List<Player> winners = new ArrayList<>();
        List<Player> losers = new ArrayList<>();
        for (int i = 1; i < Turn.players.size(); i++) {
            if (Turn.players.get(i).score > winner.score) {
                losers.add(winner);
                winner = Turn.players.get(i);
            } else if (Turn.players.get(i).score == winner.score) {
                winners.add(Turn.players.get(i));
                winners.add(winner);
            } else {
                losers.add(Turn.players.get(i));
            }
        }
        if (winners.size() > 1) {
            System.out.println("The winners are");
            for (Player player : winners) {
                System.out.println(player.name + " with " + player.score + " points.");
            }
        } else {
            System.out.println("The winner is " + winner.name + " with " + winner.score + " points.");
        }
        System.out.println("The losers are");
        for (Player loser : losers) {
            System.out.println(loser.name + " with " + loser.score + " points.");
        }
    }

    public static void possibleYahtzeeScores(Player player) {

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

    public static void availableYahtzeeScores(Player player) {
        for (int i = 0; i < player.scoreSheet.length; i++) {
            if (player.scoreSheet[i] != 5) {
                switch (i) {
                    case 0:
                        System.out.println("ones index = 0");
                        break;
                    case 1:
                        System.out.println("twos index = 1");
                        break;
                    case 2:
                        System.out.println("threes index = 2");
                        break;
                    case 3:
                        System.out.println("fours index = 3");
                        break;
                    case 4:
                        System.out.println("fives index = 4");
                        break;
                    case 5:
                        System.out.println("sixes index = 5");
                        break;
                    case 6:
                        System.out.println("three of a kind index = 6");
                        break;
                    case 7:
                        System.out.println("four of a kind index = 7");
                        break;
                    case 8:
                        System.out.println("full house index = 8");
                        break;
                    case 9:
                        System.out.println("small straight index = 9");
                        break;
                    case 10:
                        System.out.println("large straight index = 10");
                        break;
                    case 11:
                        System.out.println("Yahtzee! index = 11");
                        break;
                    case 12:
                        System.out.println("chance index = 12");
                        break;
                }
            }
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
//                System.out.println("dupe " + duplicateCount + " count " + count);
            }
        }
        if (count == 3 && duplicateCount == 0) {
            System.out.println("Small Straight = 30");
        } else if (count == 4 && duplicateCount == 2) {
            System.out.println("Small Straight = 30");
        } else if (count == 5 && duplicateCount == 2) {
            System.out.println("Small Straight = 30");
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
                System.out.println("Yahtzee! = 50");
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
        System.out.println("chance = " + total);
    }
}
