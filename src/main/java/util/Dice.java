package util;

import java.util.Random;

public class Dice {

    private static Random random = new Random();

    public static int roll(int numSides) {
        return random.nextInt(numSides) + 1;
    }

    public static int rollAdvantage(int numSides) {
        return Math.max(roll(numSides), roll(numSides));
    }

    public static int rollDisadvantage(int numSides) {
        return Math.min(roll(numSides), roll(numSides));
    }

}
