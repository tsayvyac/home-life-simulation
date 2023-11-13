package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.io.UserInput;
import cz.cvut.fel.omo.smarthome.home.HomeBuilder;
import cz.cvut.fel.omo.smarthome.home.HomeDirector;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;

import static cz.cvut.fel.omo.util.Constant.HOURS_IN_DAY;

/**
 * Facade for simple start of the simulation.
 */
public final class SimulationFacade {
    private static final HomeDirector homeDirector = HomeDirector.INSTANCE;
    private final HomeBuilder homeBuilder;
    private final RoomBuilder roomBuilder;
    private final ApplianceFactory applianceFactory;

    /**
     * Constructor.
     * @param homeBuilder builds {@link cz.cvut.fel.omo.smarthome.home.Home}.
     * @param roomBuilder builds {@link cz.cvut.fel.omo.smarthome.room.Room}.
     * @param applianceFactory appliance factory that creates {@link cz.cvut.fel.omo.appliance.Appliance}.
     */
    public SimulationFacade(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        this.homeBuilder = homeBuilder;
        this.roomBuilder = roomBuilder;
        this.applianceFactory = applianceFactory;
    }

    /**
     * Gets the configuration from user input.
     * @param useBigConfig given user house configuration (big/small).
     */
    public void simulate(boolean useBigConfig) {
        if (useBigConfig)
            useBigConfig();
        else
            useSmallConfig();
        Simulation.startSimulation(UserInput.getNumberOfDays() * HOURS_IN_DAY);
    }

    /**
     * Creates big configuration of {@link cz.cvut.fel.omo.smarthome.home.Home} using {@link HomeDirector}.
     */
    private void useBigConfig() {
        homeDirector.buildBigHouse(homeBuilder, roomBuilder, applianceFactory);
    }

    /**
     * Creates small configuration of {@link cz.cvut.fel.omo.smarthome.home.Home} using {@link HomeDirector}.
     */
    private void useSmallConfig() {
        homeDirector.buildSmallHouse(homeBuilder, roomBuilder, applianceFactory);
    }
}
