package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;

import java.util.List;

/**
 * Class representing TemperatureSensor appliance
 */
public class TemperatureSensor extends Sensor {

    /**
     * Constructor for TemperatureSensor
     *
     * @param type type of source
     * @param name name of appliance
     */
    public TemperatureSensor(SourceType type, ApplianceType name) {
        super(type, name);
    }

    /**
     * Method for closing or opening windows
     *
     * @param isCold boolean representing if it is cold
     */
    public void closeOrOpenWindows(boolean isCold) {
        List<Room> rooms = Home.getInstance().getAllRooms();
        if (isCold) {
            rooms.stream()
                    .flatMap(r -> r.getWindows().stream())
                    .forEach(window -> {
                        window.close();
                        if (window.getBlind() != null)
                            window.getBlind().close();
                    });
        } else {
            rooms.stream()
                    .flatMap(r -> r.getWindows().stream())
                    .forEach(window -> {
                        window.close();
                        if (window.getBlind() != null)
                            window.getBlind().open();
                    });
        }
    }
}
