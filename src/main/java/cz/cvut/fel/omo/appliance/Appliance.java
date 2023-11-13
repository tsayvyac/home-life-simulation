package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.appliance.state.State;

public interface Appliance {
    void turnOn();
    void turnOff();
    void breakThis();
    void pause();
    State getState();
    String collectData();
    void use(Executor executor);
    double getConsumption();
    void setConsumption(double consumption);
    Room getRoom();
    void setRoom(Room room);
    ApplianceType getType();
    String getName();
    BrokennessLevel getBrokennessLevel();
    void setBrokennessLevel();
    void setCurrentState(State state);
}
