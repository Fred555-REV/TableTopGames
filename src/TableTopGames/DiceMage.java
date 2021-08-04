package TableTopGames;

import java.util.*;

public class DiceMage extends Player {
    public int health;
    public int powerLevel;
    public int mana;
    public boolean isAlive;
    public boolean hasSecret;
    public Map<Integer, Integer> companions = new HashMap<>();
    public List<Die> companionDice = new ArrayList<>();

    public DiceMage(String name, String color) {
        super(name, color);
        health = 6;
        powerLevel = 6;
        mana = 2;
        isAlive = true;
        hasSecret = false;
    }

    public void rollAll() {
        for (Die die : dice) {
            die.roll();
        }
        for (Die die : companionDice) {
            die.roll();
        }
    }

    public void stats() {
        System.out.println(Color.getColor(this) + color + " Mage " + name + Color.RESET);
        System.out.printf("%sHealth: %s%s\t%sPower Level: %s%s\t%sMana: %s%s\n", Color.RED, health, Color.RESET, Color.GREEN, powerLevel, Color.RESET, Color.BLUE, mana, Color.RESET);
    }
//        System.out.printf("Health: %s%s||||||||%s\tPower Level: %s%s|||||||| %s\tMana: %s%s|||||||%s\n", Color.BLACK, Color.RED_BACKGROUND, Color.RESET, Color.BLACK, Color.GREEN_BACKGROUND, Color.RESET, Color.BLACK, Color.BLUE_BACKGROUND, Color.RESET);

    public void addCompanionDice(int companionStrength) {
        companionDice.add(new Die(companionStrength));
    }

    public void addMana() {
        Map<Integer, Integer> freqOfDieMap = new HashMap<>();

        for (Die die : dice) {
            if (freqOfDieMap.containsKey(die.value)) {
                int frequency = freqOfDieMap.get(die.value);
                frequency++;
                freqOfDieMap.put(die.value, frequency);
            } else {
                freqOfDieMap.put(die.value, 1);
            }
        }
        // map(key=die.value,value = frequency of die)
        int netGain = 1;

        for (int i = 1; i <= 6; i++) {
            if (freqOfDieMap.containsKey(i)) {
                for (int j = 3; j <= freqOfDieMap.get(i); j++) {
                    netGain++;
                }
            }
        }

        mana += netGain;
        if (netGain < 2) {
            System.out.println(Color.getColor(this) + name + Color.BLUE + " feels a tiny mana pulse." + Color.RESET);
        } else if (netGain < 5) {
            System.out.println(Color.getColor(this) + name + Color.BLUE + " feels mana flowing in the air." + Color.RESET);
        } else if (netGain < 9) {
            System.out.println(Color.getColor(this) + name + Color.BLUE + " feels mana surrounding them." + Color.RESET);
        } else if (netGain >= 10) {
            System.out.println(Color.getColor(this) + name + Color.BLUE + " feels mana coursing through their veins" + Color.RESET);
        }
        Display.dice(this.dice);
        System.out.println(Color.getColor(this) + name + Color.BLUE + " pulled " + netGain + " mana, they now have " + mana + " total mana." + Color.RESET);
    }

    public void takeAction() {
        Scanner scan = new Scanner(System.in);
        Display.availableActions(this);
        int index = scan.nextInt();
        scan.nextLine();
        switch (index) {
            case 1:
                int powerUpCost;
                if (dice.size() > 6) {
                    powerUpCost = 4 + (dice.size() - 6);
                } else {
                    powerUpCost = 4;
                }
                if (mana >= powerUpCost) {
                    powerUP();
                }
//                takeAction();
                break;
            case 2:
                if (mana >= 7) {
                    addCompanion();
                }
                break;
            case 3:
                if (companionDice.size() > 0) {
                    attackWithCompanions();
                }
                break;
            case 4:
                if (Turn.players.size() > 0) {
                    for (Player player : Turn.players) {
                        DiceMage mage = (DiceMage) player;
                        mage.stats();
                        Display.den(mage);
                        System.out.println("----------");
                    }
                } else {
                    stats();
                    Display.den(this);
                    System.out.println("----------");
                }
                System.out.println("done?");
                String ready = scan.nextLine();
                if (ready.equals("EXIT")) {
                    System.out.println("ok");
                    Game.isRunning = false;
                }
                takeAction();
                break;
            case 5:
                break;
            default:
                System.out.println("ERR enter number between 1-5");
                takeAction();
                break;
        }
    }

    public void powerUP() {
        int powerUpCost;
        if (dice.size() > 6) {
            powerUpCost = 4 + (dice.size() - 6);
        } else {
            powerUpCost = 4;
        }
        mana -= powerUpCost;
        addDice(1);
        powerLevel = dice.size();
        health++;
        stats();
    }

    public void addCompanion() {
        Scanner scan = new Scanner(System.in);
        Display.availableCompanions(this);
        int secret = 0;
        if (!hasSecret) {

            if (health < 3) {
                secret = (int) Math.floor(Math.random() * 20) + 1;
            } else if (dice.size() > 7) {
                secret = (int) Math.floor(Math.random() * 50) + 1;
            } else {
                secret = (int) Math.floor(Math.random() * 400) + 1;
            }

            switch (secret) {
                case 5:
                    System.out.println("Secret 1d4    \tcost: 5 mana\tindex: 0");
                    break;
                case 10:
                    System.out.println("Secret 1d6    \tcost: 6 mana\tindex: 0");
                    break;
                case 15:
                    System.out.println("Secret 1d8    \tcost: 1 die \tindex: 0");
                    break;
                case 20:
                    System.out.println("Secret 1d20   \tcost: 3 die \tindex: 0");
                    break;
            }

        }

        System.out.println("Choose companion");
        int index = scan.nextInt();
        scan.nextLine();
        int companionStrength = 0;
        switch (index) {
            case 0:
                switch (secret) {
                    case 5:
                        companionStrength = 4;
                        mana -= 5;
                        break;
                    case 10:
                        companionStrength = 6;
                        mana -= 6;
                        break;
                    case 15:
                        companionStrength = 8;
                        dice.remove(0);
                        powerLevel--;
                        break;
                    case 20:
                        companionStrength = 20;
                        for (int i = 0; i < 3; i++) {
                            dice.remove(0);
                            powerLevel--;
                        }
                        break;
                }
                hasSecret = true;
                break;
            case 1:
                companionStrength = 3;
                mana -= 7;
                break;
            case 2:
                companionStrength = 4;
                mana -= 8;
                break;
            case 3:
                companionStrength = 6;
                mana -= 9;
                break;
            case 4:
                companionStrength = 8;
                mana -= 10;
                break;
            case 5:
                companionStrength = 20;
                for (int i = 0; i < 5; i++) {
                    dice.remove(0);
                    powerLevel--;
                }
                break;
        }


        if (companions.containsKey(companionStrength)) {
            int value = companions.get(companionStrength);
            value++;
            companions.put(companionStrength, value);
            addCompanionDice(companionStrength);
        } else {
            companions.put(companionStrength, 1);
            addCompanionDice(companionStrength);
        }
    }

    public void attackWithCompanions() {
        Scanner scan = new Scanner(System.in);

        DiceMage defender = null;
        for (Player player : Turn.players) {
            DiceMage mage = (DiceMage) player;
            if (mage != this) {
                defender = mage;
            }
            if (mage.companionDice.size() > 0) {
                mage.rollAll();
            }
        }

        if (defender != null) {
            System.out.println(Color.getColor(this) + color + " Mage " + name + "'s companion strength" + Color.RESET);
            Display.dice(companionDice);
            System.out.println(Color.getColor(defender) + defender.color + " Mage " + defender.name + "'s companion strength" + Color.RESET);
            Display.dice(defender.companionDice);

            //loop through all dice if defender has companionDice
            if (defender.companionDice.size() > 0) {
                List<Die> deadAttackers = new ArrayList<>();
                List<Die> deadDefenders = new ArrayList<>();
                for (int i = 0; i < companionDice.size(); i++) {
                    int attack = 0;
                    int defense = 0;
                    if (i < defender.companionDice.size()) {
                        attack = companionDice.get(i).value;
                        defense = defender.companionDice.get(i).value;
                    } else {
                        System.out.printf("No more defending companions %s Mage %s hit.\n", defender.color, defender.name);
                        defender.health--;
                        break;
                    }

                    if (attack > defense) {
                        System.out.println(Color.getColor(this) + "Attack stronger, defender dies" + Color.RESET);
                        deadDefenders.add(defender.companionDice.get(i));
                    } else if (defense > attack) {
                        System.out.println(Color.getColor(defender) + "Defense stronger, attacker dies" + Color.RESET);
                        deadAttackers.add(companionDice.get(i));
                    } else {
                        System.out.println("Attack and defense equal, both die.");
                        deadDefenders.add(defender.companionDice.get(i));
                        deadAttackers.add(companionDice.get(i));
                    }
                    System.out.println("Enter");
                    scan.nextLine();
                }
                companionDice.removeAll(deadAttackers);
                defender.companionDice.removeAll(deadDefenders);
                for (int i = 0; i < deadAttackers.size(); i++) {
                    int strength = deadAttackers.get(i).numOfSides;
                    if (companions.containsKey(strength)) {
                        int num = companions.get(deadAttackers.get(i).numOfSides);
                        num--;
                        companions.put(strength, num);
                    }
                }
                for (int j = 0; j < deadDefenders.size(); j++) {
                    int strength = deadDefenders.get(j).numOfSides;
                    if (defender.companions.containsKey(strength)) {
                        int num = defender.companions.get(deadDefenders.get(j).numOfSides);
                        num--;
                        defender.companions.put(strength, num);
                    }
                }
            } else {
                System.out.printf("No defender %s%s Mage %s%s hit.\n", Color.getColor(defender), defender.color, defender.name, Color.RESET);
                defender.health--;
            }
        }
    }
}
//            int attack;
//            int defense;
//            if (attack > defense) {
//                System.out.println("Attacker Stronger");
//                for (Die die : companionDice) {
//
//                }
//            } else {
//                System.out.println("Defender Stronger");
//            }
