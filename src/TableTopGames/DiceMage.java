package TableTopGames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceMage extends Player {
    int health;
    int powerLevel;
    int mana;
    boolean isAlive;

    public DiceMage(String name, String color) {
        super(name, color);
        health = 5;
        powerLevel = 6;
        mana = 0;
        isAlive = true;
    }

    public void stats() {
        System.out.println(color + " Mage " + name);
        System.out.printf("Health: %s\tPower Level: %s\tMana: %s\n", health, powerLevel, mana);
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
        Display.dice(this);
        System.out.println(name + " pulled " + netGain + " mana, they now have " + mana + " total mana.");
    }

    public void takeAction(int index) {
        switch (index) {
            case 1:
                addCompanion();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                for (Player mage : Turn.players) {
                    ((DiceMage) mage).stats();
                    System.out.println("----------");
                }
                break;
            case 5:
                break;
        }
    }

    public void addCompanion() {

    }
}
