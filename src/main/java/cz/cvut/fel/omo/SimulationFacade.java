package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.io.UserInput;
import cz.cvut.fel.omo.report.HomeConfigurationVisitor;
import cz.cvut.fel.omo.smarthome.home.HomeBuilder;
import cz.cvut.fel.omo.smarthome.home.HomeDirector;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static cz.cvut.fel.omo.util.Constant.HOURS_IN_DAY;

/**
 * Facade for simple start of the simulation.
 */
@Slf4j(topic = "Simulation configuration")
public final class SimulationFacade {
    private static final HomeDirector homeDirector = HomeDirector.INSTANCE;
    private final HomeBuilder homeBuilder;
    private final RoomBuilder roomBuilder;
    private final ApplianceFactory applianceFactory;

    /**
     * Constructor.
     *
     * @param homeBuilder      builds {@link cz.cvut.fel.omo.smarthome.home.Home}.
     * @param roomBuilder      builds {@link cz.cvut.fel.omo.smarthome.room.Room}.
     * @param applianceFactory appliance factory that creates {@link cz.cvut.fel.omo.appliance.Appliance}.
     */
    public SimulationFacade(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        this.homeBuilder = homeBuilder;
        this.roomBuilder = roomBuilder;
        this.applianceFactory = applianceFactory;
    }

    /**
     * Gets the configuration from user input.
     *
     * @param useBigConfig given user house configuration (big/small).
     */
    public void simulate(boolean useBigConfig) {
        if (useBigConfig)
            useBigConfig();
        else
            useSmallConfig();
        generateHomeConfigReport();
        Simulation.startSimulation(UserInput.getNumberOfDays() * HOURS_IN_DAY);
    }

    /**
     * Creates big configuration of {@link cz.cvut.fel.omo.smarthome.home.Home} using {@link HomeDirector}.
     */
    private void useBigConfig() {
        log.info("Big configuration is used.");
        homeDirector.buildBigHouse(homeBuilder, roomBuilder, applianceFactory);
    }

    /**
     * Creates small configuration of {@link cz.cvut.fel.omo.smarthome.home.Home} using {@link HomeDirector}.
     */
    private void useSmallConfig() {
        homeDirector.buildSmallHouse(homeBuilder, roomBuilder, applianceFactory);
        log.info("Small configuration is used.");
    }

    private void generateHomeConfigReport() {
        try {
            new HomeConfigurationVisitor().generateReport();
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }
}
