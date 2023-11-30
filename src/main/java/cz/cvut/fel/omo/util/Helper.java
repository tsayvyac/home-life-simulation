package cz.cvut.fel.omo.util;

import java.util.Random;

/**
 * Helper class
 */
public class Helper {

    /**
     * Random generator
     */
    private static final Random RAND = new Random();

    /**
     * Private constructor
     */
    private Helper() {
    }

    /**
     * Get random int
     *
     * @param maxBound max bound
     * @return random int
     */
    public static int getRandomInt(int maxBound) {
        return RAND.nextInt(maxBound);
    }

    /**
     * Round double to 2 places
     */
    public static double round2Places(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
