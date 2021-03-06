package TableTopGames;

import java.util.*;

public class Mage extends Player {
    public int health;
    public int powerLevel;
    public int mana;
    public boolean isAlive;
    public boolean hasSecret;
    public Map<Integer, Integer> companions = new HashMap<>();
    public List<Die> companionDice = new ArrayList<>();

    public Mage(String name, String color) {
        super(name, color);
        health = 5;
        powerLevel = 6;
        mana = 3;
        isAlive = true;
        hasSecret = false;
    }

    public void stats() {
        System.out.println(Color.getColor(this) + color + " Mage " + name + Color.RESET);
        System.out.printf("%sHealth: %s%s\t%sPower Level: %s%s\t%sMana: %s%s\n", Color.RED, health, Color.RESET, Color.GREEN, powerLevel, Color.RESET, Color.BLUE, mana, Color.RESET);
    }

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
boolean bloodMana = false;
        for (int i = 1; i <= 6; i++) {
            if (freqOfDieMap.containsKey(i)) {
                for (int j = 3; j <= freqOfDieMap.get(i); j++) {
                    netGain++;
                    if (health < 4 && !bloodMana) {
                        netGain += 2;
                        bloodMana = true;
                    }
                }
            }
        }

        if(bloodMana){
            System.out.println(Color.getColor(this) + name + Color.BLUE + "'s blood awakens mana reserves.");
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
        dice.sort(Die::compareTo);
        System.out.print(Color.getColor(this));
        Display.dice(this.dice);
        System.out.println(Color.getColor(this) + name + Color.BLUE + " pulled " + netGain + " mana, they now have " + mana + " total mana." + Color.RESET);
    }

    public void takeAction() {
        Scanner scan = new Scanner(System.in);
        Display.availableActions(this);
//        int index = scan.nextInt();
        int index = Validator.validateInputInt("");
//        scan.nextLine();
        switch (index) {
            case 1:
                int powerUpCost;
                if (dice.size() > 6) {
                    powerUpCost = 4 + (dice.size() - 6) + (companionDice.size() * 2);
                } else {
                    powerUpCost = 4 + companionDice.size();
                }
                if (mana >= powerUpCost) {
                    powerUP(powerUpCost);
                } else {
                    System.out.println("action not available");
                    takeAction();
                }
                break;
            case 2:
                if (mana >= 7 || dice.size() >= 10) {
                    addCompanion();
                } else {
                    System.out.println("action not available");
                    takeAction();
                }
                break;
            case 3:
                if (companionDice.size() > 0) {
                    attackWithCompanions();
                } else {
                    System.out.println("action not available");
                    takeAction();
                }
                break;
            case 4:
                if (Turn.players.size() > 0) {
                    for (Player player : Turn.players) {
                        Mage mage = (Mage) player;
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
                } else if (ready.toUpperCase(Locale.ROOT).equals("CHICKEN") && this.name.toLowerCase(Locale.ROOT).equals("freddy")) {
                    health += 10;
                    mana += 10;
                }
                takeAction();
                break;
            case 5:
                break;
            default:
                System.out.println("Enter available number between 1-5");
                takeAction();
                break;
        }
    }

    public void powerUP(int powerUpCost) {
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
        if (!hasSecret || companionDice.size() < 1) {
            if (health < 4) {
                secret = (int) Math.floor(Math.random() * 20) + 1;
            } else if (dice.size() > 7 || companionDice.size() < 1) {
                secret = (int) Math.floor(Math.random() * 50) + 1;
            } else {
                secret = (int) Math.floor(Math.random() * 400) + 1;
            }
            System.out.print(Color.BLACK_BOLD);
            switch (secret) {
                case 5:
                    System.out.println("Secret 1d5  \tcost: 5 mana\tindex: 0");
                    break;
                case 10:
                    System.out.println("Secret 1d7  \tcost: 7 mana\tindex: 0");
                    break;
                case 15:
                    System.out.println("Secret 1d9  \tcost: 1 die \tindex: 0");
                    break;
                case 20:
                    System.out.println("Secret 2d11  \tcost: 3 die \tindex: 0");
                    break;
            }
            System.out.print(Color.RESET);


        }

        int index = Validator.validateInputInt("\nChoose companion");
        int companionStrength = 0;
        switch (index) {
            case -1:
                break;
            case 0:
                switch (secret) {
                    case 5:
                        companionStrength = 5;
                        mana -= 5;
                        break;
                    case 10:
                        companionStrength = 7;
                        mana -= 7;
                        break;
                    case 15:
                        companionStrength = 9;
                        dice.remove(0);
                        powerLevel--;
                        break;
                    case 20:
                        companionStrength = 11;
                        for (int i = 0; i < 3; i++) {
                            dice.remove(0);
                            powerLevel--;
                        }
                        break;
                    default:
                        System.out.println("Companion not available");
                        addCompanion();
                        break;
                }
                hasSecret = true;
                break;
            case 1:
                companionStrength = Validator.validateCompanion(this, 7, 3);
                break;
            case 2:
                companionStrength = Validator.validateCompanion(this, 8, 4);
                break;
            case 3:
                companionStrength = Validator.validateCompanion(this, 9, 6);
                break;
            case 4:
                companionStrength = Validator.validateCompanion(this, 10, 8);
                break;
            case 5:
                if (dice.size() >= 10) {
                    companionStrength = 20;
                    for (int i = 0; i < 5; i++) {
                        dice.remove(0);
                        powerLevel--;
                    }
                } else {
                    System.out.println("Companion not available");
                    addCompanion();
                }
                break;
            default:
                System.out.println("Enter number between 1-5");
                addCompanion();
                break;
        }

        if (companionStrength > 0) {
            if (companions.containsKey(companionStrength)) {
                int value = companions.get(companionStrength);
                value++;
                if (companionStrength == 11) {
                    value++;
                    addCompanionDice(companionStrength);
                }
                companions.put(companionStrength, value);
                addCompanionDice(companionStrength);
            } else {
                if (companionStrength == 11) {
                    companions.put(companionStrength, 2);
                    addCompanionDice(companionStrength);
                } else {
                    companions.put(companionStrength, 1);
                }
                addCompanionDice(companionStrength);
            }
        }
    }

    public void attackWithCompanions() {
        Scanner scan = new Scanner(System.in);
        Mage defender = null;
        //later on make it so there is a choice of who to attack
        //and add display of all available players to attack
        for (Player player : Turn.players) {
            Mage mage = (Mage) player;
            if (mage != this) {
                defender = mage;
            }
            mage.rollAll();
        }
        if (defender != null) {
            System.out.println(Color.getColor(this) + color + " Mage " + name + "'s companion strength");
            Display.dice(companionDice);
            System.out.println(Color.getColor(defender) + defender.color + " Mage " + defender.name + "'s companion strength");
            Display.dice(defender.companionDice);
            //loop through all dice if defender has companionDice
            if (defender.companionDice.size() > 0) {
                List<Die> deadAttackers = new ArrayList<>();
                List<Die> deadDefenders = new ArrayList<>();
                //all combat
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
                //Removal of dead companions
                companionDice.removeAll(deadAttackers);
                defender.companionDice.removeAll(deadDefenders);
                for (Die deadAttacker : deadAttackers) {
                    int strength = deadAttacker.numOfSides;
                    if (companions.containsKey(strength)) {
                        int num = companions.get(deadAttacker.numOfSides);
                        num--;
                        companions.put(strength, num);
                    }
                }
                for (Die deadDefender : deadDefenders) {
                    int strength = deadDefender.numOfSides;
                    if (defender.companions.containsKey(strength)) {
                        int num = defender.companions.get(deadDefender.numOfSides);
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

    public void rollAll() {
        for (Die die : dice) {
            die.roll();
        }
        for (Die die : companionDice) {
            die.roll();
        }
    }
}