package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.io.UserInput;
import cz.cvut.fel.omo.smarthome.home.HomeBuilder;
import cz.cvut.fel.omo.smarthome.home.HomeDirector;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;

public final class SimulationFacade {
    private static final HomeDirector homeDirector = HomeDirector.INSTANCE;
    private final HomeBuilder homeBuilder;
    private final RoomBuilder roomBuilder;
    private final ApplianceFactory applianceFactory;

    public SimulationFacade(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        this.homeBuilder = homeBuilder;
        this.roomBuilder = roomBuilder;
        this.applianceFactory = applianceFactory;
    }

    public void simulate(boolean useBigConfig) {
        if (useBigConfig)
            useBigConfig();
        else
            useSmallConfig();
        Simulation.startSimulation(UserInput.getNumberOfDays() * 24);
    }

    private void useBigConfig() {
        homeDirector.buildBigHouse(homeBuilder, roomBuilder, applianceFactory);
    }

    private void useSmallConfig() {
        homeDirector.buildSmallHouse(homeBuilder, roomBuilder, applianceFactory);
    }
}
