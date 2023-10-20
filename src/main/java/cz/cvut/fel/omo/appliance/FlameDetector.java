package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.room.Room;

public class FlameDetector extends Sensor {

    public FlameDetector(ApplianceType type, String name, double consumption, Room room) {
        super(type, name, consumption, room);
    }
}
