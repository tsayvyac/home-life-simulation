package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_DURABILITY;

/**
 * Class representing TV appliance
 */
public class TV extends HomeAppliance {

    /**
     * Constructor for TV
     *
     * @param type type of source
     * @param name name of appliance
     */
    public TV(SourceType type, ApplianceType name) {
        super(type, name, TV_IDLE, TV_RUNNING, TV_DURABILITY);
    }
}
