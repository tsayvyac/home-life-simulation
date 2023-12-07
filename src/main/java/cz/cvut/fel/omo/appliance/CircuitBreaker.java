package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;

import java.util.List;

/**
 * Circuit breaker is a sensor that can turn off all appliances in the house (except fridges and other sensors).
 */
public class CircuitBreaker extends Sensor {

    /**
     * List of all appliances in the house (except fridges and other sensors).
     */
    private final List<Appliance> appliances = Home.getInstance().getAllAppliances().stream()
            .filter(appliance -> !(appliance instanceof Sensor))
            .filter(appliance -> !(appliance instanceof Fridge))
            .toList();

    /**
     * List of all rooms in the house.
     */
    private final List<Room> rooms = Home.getInstance().getAllRooms();

    /**
     * Constructor of the circuit breaker.
     *
     * @param type type of the circuit breaker
     * @param name name of the circuit breaker
     */
    public CircuitBreaker(SourceType type, ApplianceType name) {
        super(type, name);
    }

    /**
     * Turns off all appliances in the house (except fridges and other sensors).
     */
    public void turnOffAll() {
        appliances.forEach(Appliance::turnOff);
        rooms.stream()
                .flatMap(r -> r.getWindows().stream())
                .forEach(window -> {
                    window.close();
                    if (window.getBlind() != null)
                        window.getBlind().close();
                });
    }
}
