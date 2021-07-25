package TableTopGames;

import java.util.*;

public class DiceMage extends Player {
    public int health;
    public int powerLevel;
    public int mana;
    public boolean isAlive;
    public boolean hasSecret;
    public Map<Integer, Integer> companions = new HashMap<>();
    public int companionAmount;
    public List<Die> companionList = new ArrayList<>();

    public DiceMage(String name, String color) {
        super(name, color);
        health = 5;
        powerLevel = 6;
        mana = 0;
        isAlive = true;
        hasSecret = false;
        companionAmount = 0;
    }

    public void stats() {
        System.out.println(color + " Mage " + name);
        System.out.printf("Health: %s\tPower Level: %s\tMana: %s\n", health, powerLevel, mana);
    }

    public void addCompanionDice(int companionStrength) {
        companionList.add(new Die(companionStrength));
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
            System.out.println(name + " feels a tiny mana pulse.");
        } else if (netGain < 5) {
            System.out.println(name + " feels mana flowing in the air.");
        } else if (netGain < 9) {
            System.out.println(name + " feels mana surrounding them.");
        } else if (netGain >= 10) {
            System.out.println(name + " feels mana coursing through their veins");
        }
        Display.dice(this.dice);
        System.out.println(name + " pulled " + netGain + " mana, they now have " + mana + " total mana.");
    }

    public void takeAction() {
        Scanner scan = new Scanner(System.in);
        Display.availableActions(this);
        int index = scan.nextInt();
        scan.nextLine();
        switch (index) {
            case 1:
                powerUP();
                break;
            case 2:
                addCompanion();
                break;
            case 3:
                attackWithCompanion();
                break;
            case 4:
                if (Turn.players.size() > 0) {
                    for (Player player : Turn.players) {
                        DiceMage mage = (DiceMage) player;
                        mage.stats();
                        Display.companions(mage);
                        System.out.println("----------");
                    }
                } else {
                    stats();
                    Display.companions(this);
                    System.out.println("----------");
                }
                System.out.println("done?");
                String ready = scan.nextLine();
                if (ready.equals("EXIT")) {
                    System.out.println("ok");
                    Game.isRunning = false;
                }
                break;
            case 5:
                break;
        }
    }

    public void powerUP() {
        int powerUpCost;
        if (dice.size() > 6) {
            powerUpCost = 4 + (dice.size() - 6);//+companion amount
        } else {
            powerUpCost = 4;//+companion amount
        }
        mana -= powerUpCost;
        addDice(1);
        powerLevel = dice.size();
        stats();
        takeAction();
    }

    public void addCompanion() {
        Scanner scan = new Scanner(System.in);
        Display.availableCompanions(this);
        int secret = 0;
        if (!hasSecret) {

            if (dice.size() > 7) {
                secret = (int) Math.floor(Math.random() * 100) + 1;
            } else {
                secret = (int) Math.floor(Math.random() * 400) + 1;
            }

            switch (secret) {
                case 25:
                    System.out.println("Secret 1d4      \tcost: 5 mana\tindex: 0");
                    break;
                case 50:
                    System.out.println("Secret 1d6      \tcost: 6 mana\tindex: 0");
                    break;
                case 75:
                    System.out.println("Secret 1d8      \tcost: 1 die \tindex: 0");
                    break;
                case 100:
                    System.out.println("Secret 1d20     \tcost: 3 die \tindex: 0");
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
                    case 25:
                        companionStrength = 4;
                        mana -= 5;
                        break;
                    case 50:
                        companionStrength = 6;
                        mana -= 6;
                        break;
                    case 75:
                        companionStrength = 8;
                        dice.remove(0);
                        powerLevel--;
                        break;
                    case 100:
                        companionStrength = 12;
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
                mana -= 6;
                break;
            case 2:
                companionStrength = 4;
                mana -= 7;
                break;
            case 3:
                companionStrength = 6;
                mana -= 8;
                break;
            case 4:
                companionStrength = 8;
                mana -= 9;
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
            companionAmount++;
            addCompanionDice(companionStrength);
        } else {
            companions.put(companionStrength, 1);
            companionAmount++;
            addCompanionDice(companionStrength);
        }
    }

    public void attackWithCompanion() {
        for (Player player : Turn.players) {
            DiceMage mage = (DiceMage) player;
            System.out.println(mage.name + "'s companion power");
            Display.dice(mage.companionList);
        }
    }
}
