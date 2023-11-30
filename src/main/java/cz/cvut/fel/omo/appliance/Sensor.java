package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.state.StateIdle;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_RUNNING;

/**
 * Class representing Sensor appliance
 */
public abstract class Sensor extends HomeAppliance {

    /**
     * Constructor for Sensor
     *
     * @param type type of source
     * @param name name of appliance
     */
    protected Sensor(SourceType type, ApplianceType name) {
        super(type, name, SENSOR_IDLE, SENSOR_RUNNING, 10_000);
        this.state = new StateIdle(this);
    }
}
