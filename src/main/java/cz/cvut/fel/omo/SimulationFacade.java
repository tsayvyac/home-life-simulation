package cz.cvut.fel.omo;

import cz.cvut.fel.omo.io.UserInput;
import cz.cvut.fel.omo.smarthome.home.HomeDirector;
import cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder;
import cz.cvut.fel.omo.smarthome.room.StandardRoomBuilder;

public final class SimulationFacade {
    /**
     * Singleton (eager initialization)
     */
    public static final SimulationFacade INSTANCE = new SimulationFacade();
    private static final HomeDirector homeDirector = HomeDirector.INSTANCE;

    private SimulationFacade() {}

    public void simulate(boolean useBigConfig) {
        if (useBigConfig)
            useBigConfig();
        else
            useSmallConfig();
        Simulation.startSimulation(UserInput.getNumberOfDays());
    }

    private void useBigConfig() {
        homeDirector.buildBigHouse(StandardHomeBuilder.INSTANCE, StandardRoomBuilder.INSTANCE);
    }

    private void useSmallConfig() {
        homeDirector.buildSmallHouse(StandardHomeBuilder.INSTANCE, StandardRoomBuilder.INSTANCE);
    }
}
