package TableTopGames;

import java.util.ArrayList;

public class YachtseaPlayer extends Player {
    int[] scoreSheet;

    public YachtseaPlayer(String name, String color, int scoreAmount) {
        super(name, color);
        this.score=0;
        this.scoreSheet = new int[scoreAmount];
        this.dice = new ArrayList<>();
    }
}
