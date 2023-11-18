package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.appliance.state.StateOff;
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class HomeAppliance implements Appliance {
    protected final ApplianceType type;
    protected String name;
    protected Room room;
    protected double consumption;
    protected State state;
    protected BrokennessLevel brokennessLevel;
    private final Random random = new Random();

    public HomeAppliance(ApplianceType type, String name, double consumption) {
        this.type = type;
        this.name = name;
        this.consumption = consumption;
        this.state = new StateOff(this);
    }

    @Override
    public String collectData() {
        return null;
    }



}
