package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;

public interface Appliance {
    void turnOn();
    void turnOff();
    void breakThis();
    void pause();
    String collectData();
    void use(Executor executor);
    void setBrokennessLevel();
}
