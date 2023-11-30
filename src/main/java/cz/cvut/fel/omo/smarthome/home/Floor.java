package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.nullable.Nullable;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.component.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor implements Nullable, Component {
    private Integer floorNumber;
    private List<Room> roomList = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

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
