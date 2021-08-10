package TableTopGames;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int validateInputInt(String prompt) {
        if (!prompt.equals("")) {
            System.out.println(prompt);
        }
        Scanner scan = new Scanner(System.in);
        boolean validOption = true;
        int input = -1;
        try {

            input = scan.nextInt();

        } catch (ClassCastException | InputMismatchException cce) {
            System.out.println("Your input is invalid, please try again");
            validOption = false;
        }
        if (!validOption) {
            validateInputInt(prompt);
        }
        return input;
    }

    static int validateCompanion(Mage mage, int manaCost, int companionStrength) {
        if (mage.mana >= manaCost) {
            mage.mana -= manaCost;
        } else {
            System.out.println("Companion not available");
            companionStrength = 0;
            mage.addCompanion();
        }
        return companionStrength;
    }
}
