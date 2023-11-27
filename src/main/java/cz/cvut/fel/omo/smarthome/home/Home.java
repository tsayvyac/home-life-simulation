package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.CircuitBreaker;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.updatable.Updatable;
import cz.cvut.fel.omo.util.Helper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Home implements Updatable {
    private static Home instance;
    private List<Floor> floorList = new ArrayList<>();
    private List<Executor> allExecutors = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private CircuitBreaker circuitBreaker;

    private Home() {
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public <T extends Executor> void addExecutor(T o) {
        int floorIndex = Helper.getRandomInt(floorList.size());
        floorList
                .get(floorIndex)
                .getRoomList()
                .get(Helper.getRandomInt(floorList.get(floorIndex).getRoomList().size()))
                .addExecutor(o);
        allExecutors.add(o);
    }

    public List<NullableRoom> getAllRooms() {
        List<NullableRoom> rooms = new ArrayList<>();
        floorList.forEach(floor ->
                rooms.addAll(floor.getRoomList())
        );
        Collections.shuffle(rooms);
        return rooms;
    }

    public List<Appliance> getAllAppliances() {
        return floorList.stream()
                .flatMap(floor -> floor.getRoomList().stream())
                .flatMap(room -> room.getApplianceList().stream())
                .toList();
    }

    public List<Item> getAllItems() {
        return floorList.stream()
                .flatMap(floor -> floor.getRoomList().stream())
                .flatMap(room -> room.getItemList().stream())
                .toList();
    }

    public void turnOffAll() {
        this.circuitBreaker.turnOffAll();
    }

    public void sensorToIdle() {
        this.circuitBreaker.toIdleSensors();
    }

    public static Home getInstance() {
        if (instance == null)
            instance = new Home();
        return instance;
    }

    @Override
    public void update() {
        this.circuitBreaker.update();
        floorList.forEach(Updatable::update);
    }
}
