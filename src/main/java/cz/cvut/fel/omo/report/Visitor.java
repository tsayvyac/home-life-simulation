package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;

import java.time.format.DateTimeFormatter;

/**
 * Visitor interface for generating reports
 */
public interface Visitor {

    /**
     * Formatter for date and time
     */
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    /**
     * Visit home
     *
     * @param home home to visit
     * @return message that gonna be added to report
     */
    String visitHome(Home home);

    /**
     * Visit floor
     *
     * @param floor floor to visit
     * @return message that gonna be added to report
     */
    String visitFloor(Floor floor);

    /**
     * Visit room
     *
     * @param room room to visit
     * @return message that gonna be added to report
     */
    String visitRoom(Room room);

    /**
     * Visit executor
     *
     * @param executor executor to visit
     * @return message that gonna be added to report
     */
    String visitExecutor(Executor executor);

    /**
     * Visit appliance
     *
     * @param appliance appliance to visit
     * @return message that gonna be added to report
     */
    String visitAppliance(Appliance appliance);
}
