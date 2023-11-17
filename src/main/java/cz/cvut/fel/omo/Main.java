package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import cz.cvut.fel.omo.io.UserInput;
import cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder;
import cz.cvut.fel.omo.smarthome.room.StandardRoomBuilder;
import cz.cvut.fel.omo.util.ReportGenerator;

public class Main {

    /**
     * Starts simulation with user configuration.
     */
    public static void main(String[] args) {
        new SimulationFacade(
                StandardHomeBuilder.INSTANCE,
                StandardRoomBuilder.INSTANCE,
                HomeApplianceFactory.INSTANCE
        ).simulate(UserInput.getConfiguration());

        // TODO: refactor
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generate();
    }
}
