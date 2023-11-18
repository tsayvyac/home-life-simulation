package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.state.StateIdle;

public abstract class Sensor extends HomeAppliance {

    protected Sensor(ApplianceType type, String name, double consumption) {
        super(type, name, consumption);
        this.state = new StateIdle(this);
    }
}
