package cz.cvut.fel.omo.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

/**
 * Class that handles user input
 */
@Slf4j(topic = "User input")
public final class UserInput {

    /**
     * Scanner for user input
     */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Private constructor for UserInput
     */
    private UserInput() {
    }

    /**
     * Gets parameters for simulation from user
     *
     * @return true if user wants big configuration, false otherwise
     */
    public static boolean getConfiguration() {
        return userInput(USER_CONFIG_CHOICE, USER_CONFIG_CHOICE_ERR);
    }

    /**
     * Gets user input for number of days
     *
     * @return number of days
     */
    public static int getNumberOfDays() {
        log.info(USER_NUMBER_OF_DAYS);
        boolean isCorrectInput = false;
        int numberOfDays = 0;
        while (!isCorrectInput) {
            numberOfDays = sc.nextInt();
            if (numberOfDays > 29 && numberOfDays < 366)
                isCorrectInput = true;
            else
                log.warn(USER_NUMBER_OF_DAYS_ERR);
        }
        sc.nextLine();
        deleteReports();
        return numberOfDays;
    }

    /**
     * Deletes all previous reports if user wants
     */
    private static void deleteReports() {
        File[] filesInReports = new File("reports/").listFiles();
        File[] filesInManual = new File("manual/").listFiles();
        if (filesInReports != null && filesInReports.length != 0) {
            boolean isDelete = userInput(USER_DELETE_REPORT, USER_DELETE_REPORT_ERR);
            if (isDelete) {
                if (filesInManual != null && filesInManual.length != 0)
                    delete(filesInReports, filesInManual);
                else
                    delete(filesInReports);
                log.info("All previous files was deleted successfully.");
            }
        }
    }

    /**
     * Gets user input
     *
     * @param info  info for user
     * @param error error for user
     * @return true if user input is true, false otherwise
     */
    private static boolean userInput(String info, String error) {
        log.info(info);
        boolean isCorrectInput = false;
        boolean toReturn = false;
        while (!isCorrectInput) {
            switch (sc.nextLine()) {
                case "T", "t" -> {
                    toReturn = true;
                    isCorrectInput = true;
                }
                case "F", "f" -> isCorrectInput = true;
                default -> log.warn(error);
            }
        }
        return toReturn;
    }

    /**
     * Deletes all previous reports
     *
     * @param reports list of reports
     * @param manuals list of manuals
     */
    private static void delete(File[] reports, File[] manuals) {
        for (File report : reports)
            report.delete();

        for (File manual : manuals)
            manual.delete();
    }

    /**
     * Deletes all previous reports
     *
     * @param reports list of reports
     */
    private static void delete(File[] reports) {
        for (File report : reports)
            report.delete();
    }
}
