package TableTopGames;

import java.util.ArrayList;

public class YahtzeePlayer extends Player {
    int[] scoreSheet;

    public YahtzeePlayer(String name, String color, int scoreAmount) {
        super(name, color);
        this.score=0;
        this.scoreSheet = new int[scoreAmount];
        this.dice = new ArrayList<>();
    }
}
