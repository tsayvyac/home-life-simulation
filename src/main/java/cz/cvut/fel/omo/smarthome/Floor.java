package cz.cvut.fel.omo.smarthome;

import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor {
    private Integer floorNumber;
    private List<Room> roomList = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }
}
