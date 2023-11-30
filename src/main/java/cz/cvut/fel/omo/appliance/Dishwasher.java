package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.DISHWASHER_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.DISHWASHER_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.DISHWASHER_DURABILITY;

/**
 * Class representing dishwasher
 */
public class Dishwasher extends HomeAppliance {

    /**
     * Constructor for dishwasher
     *
     * @param type source type
     * @param name appliance type
     */
    public Dishwasher(SourceType type, ApplianceType name) {
        super(type, name, DISHWASHER_IDLE, DISHWASHER_RUNNING, DISHWASHER_DURABILITY);
    }
}
