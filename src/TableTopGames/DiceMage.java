package TableTopGames;

public class DiceMage extends Player {
    int health;
    int powerLevel;
    int mana;

    public DiceMage(String name, String color) {
        super(name, color);
        health = 5;
        powerLevel = 6;
        mana = 0;
    }
}