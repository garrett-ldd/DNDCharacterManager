package util;

import java.util.Random;

public class Dice {

    private static Random random = new Random();

    public static int roll(int numSides) {
        return random.nextInt(numSides) + 1;
    }
}
