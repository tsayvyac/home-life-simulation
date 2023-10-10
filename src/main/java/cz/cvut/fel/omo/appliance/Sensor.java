package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.room.Room;

public abstract class Sensor extends HomeAppliance {
    public Sensor(ApplianceType type, String name, double consumption, Room room) {
        super(type, name, consumption, room);
    }
}
