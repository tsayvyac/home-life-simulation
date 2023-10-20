package cz.cvut.fel.omo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Simulation {

    private Simulation() {}

    public static void startSimulation(int numberOfDays) {
        log.info("Simulation is started with days: {}", numberOfDays);
    }
}
