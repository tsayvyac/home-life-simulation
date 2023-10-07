package cz.cvut.fel.omo;

import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.home.HomeDirector;
import cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder;
import cz.cvut.fel.omo.smarthome.room.StandardRoomBuilder;

public class SimulationFacade {
    /**
     * Singleton (eager initialization)
     */
    public static final SimulationFacade INSTANCE = new SimulationFacade();
    private final HomeDirector homeDirector = HomeDirector.INSTANCE;

    private SimulationFacade() {}

    public void simulate(boolean useBigConfig) {
        if (useBigConfig)
            useBigConfig();
        else
            useSmallConfig();
//        Simulation.startSimulation();
    }

    private void useBigConfig() {
        homeDirector.buildBigHouse(StandardHomeBuilder.INSTANCE, StandardRoomBuilder.INSTANCE);
    }

    private void useSmallConfig() {
        homeDirector.buildSmallHouse(StandardHomeBuilder.INSTANCE, StandardRoomBuilder.INSTANCE);
    }
}
