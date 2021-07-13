package TableTopGames;

public class Display {
    public static void dice(Player player){
        for (int i = 0; i < 5; i++) {
            System.out.println(player.dice[i].number);
        }
    }
}
