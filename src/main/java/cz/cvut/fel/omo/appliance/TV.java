package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.TV_DURABILITY;

public class TV extends HomeAppliance {

    public TV(SourceType type, ApplianceType name) {
        super(type, name, TV_IDLE, TV_RUNNING, TV_DURABILITY);
    }
}
