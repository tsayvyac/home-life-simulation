package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.component.Component;

public interface Appliance extends Component {
    String collectData();

    State getState();

    void setRoom(Room room);

    SourceType getSourceType();

    ApplianceType getName();

    double getTotalConsumption();

    void breakYourself();

    void setIdleConsumption();

    void setRunningConsumption();

    void setZeroConsumption();

    void repair(Executor executor);

    void turnOn();

    void turnOff();

    void idle();

    Room getRoom();

    int getDurability();

    void decreaseDurability();
}
