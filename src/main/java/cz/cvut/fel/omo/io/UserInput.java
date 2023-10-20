package cz.cvut.fel.omo.io;

import java.util.Scanner;
import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

public final class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    private UserInput() {}

    public static boolean getConfiguration() {
        System.out.println(USER_CONFIG_CHOICE);
        boolean isCorrectInput = false;
        boolean isBigConfig = false;
        while (!isCorrectInput) {
            switch (sc.nextLine()) {
                case "T", "t" -> {
                    isBigConfig = true;
                    isCorrectInput = true;
                }
                case "F", "f" -> isCorrectInput = true;
                default -> System.err.println(USER_CONFIG_CHOICE_ERR);
            }
        }
        return isBigConfig;
    }

    public static int getNumberOfDays() {
        System.out.println(USER_NUMBER_OF_DAYS);
        boolean isCorrectInput = false;
        int numberOfDays = 0;
        while (!isCorrectInput) {
            numberOfDays = sc.nextInt();
            if (numberOfDays > 6 && numberOfDays < 1000)
                isCorrectInput = true;
            else
                System.err.println(USER_NUMBER_OF_DAYS_ERR);
        }
        return numberOfDays;
    }
}