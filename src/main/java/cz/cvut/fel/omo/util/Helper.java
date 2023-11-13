package cz.cvut.fel.omo.util;

import java.util.Random;

public class Helper {
    private static final Random RAND = new Random();

    private Helper() {}

    public static int getRandomInt(int maxBound) {
        return RAND.nextInt(maxBound);
    }
}
