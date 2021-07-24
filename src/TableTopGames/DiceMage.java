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
        System.out.printf("Health: %s\tPower Level: %s\tMana: %s", health, powerLevel, mana);
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
        System.out.println(color + " mage " + name + " pulled " + netGain + " mana, they now have " + mana + " total mana.");
    }
}
