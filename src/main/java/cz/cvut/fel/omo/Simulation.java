package cz.cvut.fel.omo;

import cz.cvut.fel.omo.entity.activity.ActivityGenerator;
import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.extern.slf4j.Slf4j;

import static cz.cvut.fel.omo.util.Constant.HOURS_IN_DAY;

/**
 * Main simulation class that contains main simulation loop.
 */
@Slf4j(topic = "SIMULATION")
class Simulation {
    private static final Home home = Home.getInstance();

    private Simulation() {}

    /**
     * Starts main simulation loop with given number of hours.
     * @param hours is got from user input.
     */
    public static void startSimulation(int hours) {
        log.info("Simulation is started with days: {}", hours / HOURS_IN_DAY);

        for (int i = 0; i < hours; i++) {
            int dayOfWeek = i / HOURS_IN_DAY;
            if (dayOfWeek % 7 < 5) {
                generateWorkdayActivities();
                log.info("--- Generated workday activities {}", i);
            } else {
                generateWeekendActivities();
                log.info("+++ Generated weekend activities {}", i);
            }
            home.update();
        }
    }

    private static void generateWorkdayActivities() {
        ActivityGenerator.generateRandomActivity();
    }

    private static void generateWeekendActivities() {
        ActivityGenerator.generateRandomActivity();
    }

}
