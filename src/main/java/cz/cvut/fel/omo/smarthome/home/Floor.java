package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.nullable.Nullable;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.component.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing floor in the home
 */
@Getter
@Setter
public class Floor implements Nullable, Component {

    /**
     * Floor number
     */
    private Integer floorNumber;

    /**
     * List of rooms in the floor
     */
    private List<Room> roomList = new ArrayList<>();

    /**
     * Constructor for floor
     *
     * @param floorNumber floor number
     */
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * Add room to the floor
     *
     * @param room room to be added
     */
    public void addRoom(Room room) {
        roomList.add(room);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitFloor(this);
    }

    @Override
    public void update() {
        roomList.forEach(Component::update);
    }
}
