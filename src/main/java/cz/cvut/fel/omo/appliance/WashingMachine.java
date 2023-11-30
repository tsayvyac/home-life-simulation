package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_DURABILITY;

/**
 * Class representing WashingMachine appliance
 */
public class WashingMachine extends HomeAppliance {

    /**
     * Constructor for WashingMachine
     *
     * @param type type of source
     * @param name name of appliance
     */
    public WashingMachine(SourceType type, ApplianceType name) {
        super(type, name, WASHING_MACHINE_IDLE, WASHING_MACHINE_RUNNING, WASHING_MACHINE_DURABILITY);
    }
}
