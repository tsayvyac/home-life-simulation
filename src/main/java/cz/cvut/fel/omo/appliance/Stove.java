package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_DURABILITY;

/**
 * Class representing Stove appliance
 */
public class Stove extends HomeAppliance {

    /**
     * Constructor for Stove
     *
     * @param type type of source
     * @param name name of appliance
     */
    public Stove(SourceType type, ApplianceType name) {
        super(type, name, STOVE_IDLE, STOVE_RUNNING, STOVE_DURABILITY);
    }
}
