package cz.cvut.fel.omo;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "SIMULATION")
class Simulation {

    private Simulation() {}

    public static void startSimulation(int hours) {
        log.info("Simulation is started with days: {}", hours / 24);

        for (int i = 0; i < hours; i++) {
            int dayOfWeek = i / 24;
            if (dayOfWeek % 7 < 5) {
                log.info("--- Generated workday activities {}", i);
            } else {
                log.info("+++ Generated weekend activities {}", i);
            }
        }
    }
}
