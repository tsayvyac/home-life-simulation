package cz.cvut.fel.omo;

import cz.cvut.fel.omo.event.EventGenerator;
import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.extern.slf4j.Slf4j;

import static cz.cvut.fel.omo.util.Constant.HOURS_IN_DAY;

/**
 * Main simulation class that contains main simulation loop.
 */
@Slf4j(topic = "Simulation starter")
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
            EventGenerator.generateRandomEvent(i);
            log.info("UPDATE");
            home.update();
        }
    }
}
