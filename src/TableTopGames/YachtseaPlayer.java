package TableTopGames;

import java.util.ArrayList;
import java.util.Scanner;

public class YachtseaPlayer extends Player {
    public int[] scoreSheet;

    public YachtseaPlayer(String name, String color, int scoreAmount) {
        super(name, color);
        this.score = 0;
        this.scoreSheet = new int[scoreAmount];
        this.dice = new ArrayList<>();
    }

    public void ones() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 1) {
                total++;
            }
        }
        if (total != 0) {
            System.out.println("Ones = " + total);
            score += total;
            bonus += total;
        }
    }

    public void twos() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 2) {
                total += 2;
            }
        }
        if (total != 0) {
            System.out.println("Twos = " + total);
            score += total;
            bonus += total;
        }
    }

    public void threes() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 3) {
                total += 3;
            }
        }
        if (total != 0) {
            System.out.println("Threes = " + total);
            score += total;
            bonus += total;
        }
    }

    public void fours() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 4) {
                total += 4;
            }
        }
        if (total != 0) {
            System.out.println("Fours = " + total);
            score += total;
            bonus += total;
        }
    }

    public void fives() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 5) {
                total += 5;
            }
        }
        if (total != 0) {
            System.out.println("Fives = " + total);
            score += total;
            bonus += total;
        }
    }

    public void sixes() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            if (dice.get(i).value == 6) {
                total += 6;
            }
        }
        if (total != 0) {
            System.out.println("Sixes = " + total);
            score += total;
            bonus += total;
        }
    }

    public void threeOAK() {
        for (int i = 0; i < dice.size(); i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < dice.size(); j++) {
                if (dice.get(i).value == dice.get(j).value) {
                    count++;
                    total += dice.get(i).value;
                }
            }
//            System.out.println("count " + count);
            if (count == 3) {
                System.out.println("Three of a Kind = " + total);
                score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public void fourOAK() {
        for (int i = 0; i < dice.size(); i++) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < dice.size(); j++) {
                if (dice.get(i).value == dice.get(j).value) {
                    count++;
                    total += dice.get(i).value;
                }
            }
//            System.out.println("count " + count);
            if (count == 4) {
                System.out.println("Four of a Kind = " + total);
                score += total;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public void smStraight() {
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < dice.size(); i++) {
            for (int j = 0; j < dice.size(); j++) {
//                System.out.println("j " + j + " i " + i);

//                System.out.println("dupe " + duplicateCount + " count " + count);
                if (dice.get(i).value == dice.get(j).value && j != i) {
                    duplicateCount++;
                }
                if (dice.get(i).value == dice.get(j).value + 1) {
                    count++;
                }
            }
        }
        if (count == 3 && duplicateCount == 0) {
            System.out.println("Small Straight = 30");
            score += 30;
        } else if (count == 4 && duplicateCount == 2) {
            System.out.println("Small Straight = 30");
            score += 30;
        }
    }

    public void lgStraight() {
//        Arrays.sort(player.dice);
        int count = 0;
        int duplicateCount = 0;
        for (int i = 0; i < dice.size(); i++) {
            for (int j = 0; j < dice.size(); j++) {
                if (dice.get(i).value == dice.get(j).value && j != i) {
                    duplicateCount++;
                }
                if (dice.get(i).value == dice.get(j).value + 1) {
                    count++;
                }
            }
        }
        if (count == 4 && duplicateCount == 0) {
            System.out.println("Large Straight = 40");
            score += 40;
        }
    }

    public void fullHouse() {
        boolean isDone = false;
        for (int i = 0; i < dice.size(); i++) {
            int count1 = 0;
            int count2;
            int threeOAK = 0;
            for (int j = 0; j < dice.size(); j++) {
                if (dice.get(i).value == dice.get(j).value) {
                    count1++;
                }
            }
            if (count1 == 3) {
                threeOAK = dice.get(i).value;
            }

            for (int k = 0; k < dice.size(); k++) {
                count2 = 0;
                for (int l = 0; l < dice.size(); l++) {
                    if (dice.get(k).value != threeOAK && dice.get(k).value == dice.get(l).value) {
                        count2++;
                    }
                }
                if (count2 % 2 == 0 && threeOAK != 0 && count2 != 0) {
                    System.out.println("Full House = 25");
                    score += 25;
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

    public void fiveOAK() {
        for (int i = 0; i < dice.size(); i++) {
            int count = 0;
            for (int j = 0; j < dice.size(); j++) {
                if (dice.get(i).value == dice.get(j).value) {
                    count++;
                }
            }
//            System.out.println("count " + count);
            if (count == 5) {
                if (scoreSheet[11] != 5) {
                    System.out.println("Yachtsea! = 50");
                } else {
                    System.out.println("Bonus Yachtsea!!! extra turn.");
                }
                score += 50;
                break;
            }
//            System.out.println("i " + i);

        }
    }

    public void chance() {
        int total = 0;
        for (int i = 0; i < dice.size(); i++) {
            total += dice.get(i).value;
        }
        System.out.println("Chance = " + total);
        score += total;
    }


    public void bonus() {
        if (bonus >= 63 && scoreSheet[13] != 5) {
            scoreSheet[13] = 5;
            score += 35;
            System.out.println("You got the bonus " + bonus + "/" + 63 + " +35 points");
        } else if (scoreSheet[13] != 5) {
            System.out.println("Bonus: " + bonus + "/" + 63);
        }
    }

    public void addScore() {
        Scanner scan = new Scanner(System.in);
        DisplayYachtsea.possibleScores(this);
        System.out.println(Color.getColor(this) + "When done looking at possible scores enter \"done\".");
        String nice = scan.next().trim();
        if (nice.equalsIgnoreCase("nice")) {
            System.out.println(nice);
        }
        System.out.println("These are available scores to add or erase");
        DisplayYachtsea.scoreSheet(this);
        System.out.println("Which score would you like to add? enter index or -1 if bonus Yachtsea");
        int index = scan.nextInt();
        scan.nextLine();
        if (scoreSheet[index] != 5) {
            switch (index) {
                case 0:
                    this.ones();
                    break;
                case 1:
                    this.twos();
                    break;
                case 2:
                    this.threes();
                    break;
                case 3:
                    this.fours();
                    break;
                case 4:
                    this.fives();
                    break;
                case 5:
                    this.sixes();
                    break;
                case 6:
                    this.threeOAK();
                    break;
                case 7:
                    this.fourOAK();
                    break;
                case 8:
                    this.fullHouse();
                    break;
                case 9:
                    this.smStraight();
                    break;
                case 10:
                    this.lgStraight();
                    break;
                case 11:
                    this.fiveOAK();
                    break;
                case 12:
                    this.chance();
                    break;
                default:
                    addScore();
            }
            scoreSheet[index] = 5;
            this.bonus();
        } else {
            fiveOAK();
            addScore();
        }
        System.out.print(Color.RESET);
//        scan.close();
    }
}
