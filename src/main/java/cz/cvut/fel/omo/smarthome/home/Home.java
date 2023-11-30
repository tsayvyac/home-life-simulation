package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.CircuitBreaker;
import cz.cvut.fel.omo.appliance.TemperatureSensor;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.component.Component;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.util.Helper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing home
 */
@Getter
@Setter
public class Home implements Component {

    /**
     * Singleton instance
     */
    private static Home instance;

    /**
     * List of floors in the home
     */
    private List<Floor> floorList = new ArrayList<>();

    /**
     * List of all executors in the home
     */
    private List<Executor> allExecutors = new ArrayList<>();

    /**
     * List of all events in the home
     */
    private List<Event> events = new ArrayList<>();

    /**
     * Circuit breaker
     */
    private CircuitBreaker circuitBreaker;

    /**
     * Temperature sensor
     */
    private TemperatureSensor temperatureSensor;

    /**
     * Constructor for home
     */
    private Home() {
    }

    /**
     * Add event to the home
     *
     * @param event event to be added
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Add floor to the home
     *
     * @param floor floor to be added
     */
    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    /**
     * Add executor to the home
     */
    public <T extends Executor> void addExecutor(T executor) {
        int floorIndex = Helper.getRandomInt(floorList.size());
        floorList
                .get(floorIndex)
                .getRoomList()
                .get(Helper.getRandomInt(floorList.get(floorIndex).getRoomList().size()))
                .addExecutor(executor);
        allExecutors.add(executor);
    }

    /**
     * Gets all rooms in the home
     *
     * @return list of rooms
     */
    public List<NullableRoom> getAllRooms() {
        List<NullableRoom> rooms = new ArrayList<>();
        floorList.forEach(floor ->
                rooms.addAll(floor.getRoomList())
        );
        Collections.shuffle(rooms);
        return rooms;
    }

    /**
     * Gets all executors in the home
     *
     * @return list of executors
     */
    public List<Appliance> getAllAppliances() {
        return floorList.stream()
                .flatMap(floor -> floor.getRoomList().stream())
                .flatMap(room -> room.getApplianceList().stream())
                .toList();
    }

    /**
     * Activate temperature sensor
     */
    public void activateTemperatureSensor() {
        ActivityAndUsageReporter.add("Temperature sensor is activated!");
        this.temperatureSensor.closeOrOpenWindows(Helper.getRandomInt(2) == 1);
    }

    /**
     * Call circuit breaker to turn off all appliances
     */
    public void turnOffAll() {
        this.circuitBreaker.turnOffAll();
    }

    /**
     * Gets instance of home
     *
     * @return instance
     */
    public static Home getInstance() {
        if (instance == null)
            instance = new Home();
        return instance;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitHome(this);
    }

    @Override
    public void update() {
        this.circuitBreaker.update();
        floorList.forEach(Component::update);
    }
}
