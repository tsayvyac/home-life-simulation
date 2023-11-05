package cz.cvut.fel.omo.io;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

@Slf4j(topic = "USER INPUT")
public final class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    private UserInput() {}

    public static boolean getConfiguration() {
        log.info(USER_CONFIG_CHOICE);
        boolean isCorrectInput = false;
        boolean isBigConfig = false;
        while (!isCorrectInput) {
            switch (sc.nextLine()) {
                case "T", "t" -> {
                    isBigConfig = true;
                    isCorrectInput = true;
                }
                case "F", "f" -> isCorrectInput = true;
                default -> log.warn(USER_CONFIG_CHOICE_ERR);
            }
        }
        return isBigConfig;
    }

    public static int getNumberOfDays() {
        log.info(USER_NUMBER_OF_DAYS);
        boolean isCorrectInput = false;
        int numberOfDays = 0;
        while (!isCorrectInput) {
            numberOfDays = sc.nextInt();
            if (numberOfDays > 30 && numberOfDays < 365)
                isCorrectInput = true;
            else
                log.warn(USER_NUMBER_OF_DAYS_ERR);
        }
        return numberOfDays;
    }
}
