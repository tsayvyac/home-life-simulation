package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.smarthome.room.Room;

public interface Appliance {
    String collectData();
    State getState();
    void setRoom(Room room);
    ApplianceType getType();
    String getName();
    double getConsumption();
}
