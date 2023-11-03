package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.nullable.Nullable;
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor implements Nullable {
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
}
