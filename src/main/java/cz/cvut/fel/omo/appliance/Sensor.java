package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.state.StateIdle;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_RUNNING;

public abstract class Sensor extends HomeAppliance {

    protected Sensor(SourceType type, ApplianceType name) {
        super(type, name, SENSOR_IDLE, SENSOR_RUNNING, 10_000);
        this.state = new StateIdle(this);
    }
}
