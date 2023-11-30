package cz.cvut.fel.omo.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

@Slf4j(topic = "User input")
public final class UserInput {
    private static final Scanner sc = new Scanner(System.in);

    private UserInput() {
    }

    public static boolean getConfiguration() {
        return userInput(USER_CONFIG_CHOICE, USER_CONFIG_CHOICE_ERR);
    }

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

    private static void deleteReports() {
        File[] filesInReports = new File("reports/").listFiles();
        File[] filesInManual = new File("manual/").listFiles();
        if ((filesInReports != null && filesInManual != null) && (filesInReports.length != 0 || filesInManual.length != 0)) {
            boolean isDelete = userInput(USER_DELETE_REPORT, USER_DELETE_REPORT_ERR);
            if (isDelete) {
                delete(filesInReports, filesInManual);
                log.info("All previous files was deleted successfully.");
            }
        }
    }

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

    private static void delete(File[] reports, File[] manuals) {
        for (File report : reports) {
            report.delete();
        }
        for (File manual : manuals) {
            manual.delete();
        }
    }
}
