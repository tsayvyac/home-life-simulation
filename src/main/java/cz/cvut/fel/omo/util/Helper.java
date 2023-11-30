package cz.cvut.fel.omo.util;

import java.util.Random;

public class Helper {
    private static final Random RAND = new Random();

    private Helper() {
    }

    public static int getRandomInt(int maxBound) {
        return RAND.nextInt(maxBound);
    }

    public static double round2Places(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
