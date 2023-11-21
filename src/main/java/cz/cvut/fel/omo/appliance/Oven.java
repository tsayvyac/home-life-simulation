package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.OVEN_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.OVEN_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.OVEN_DURABILITY;

public class Oven extends HomeAppliance {

    public Oven(SourceType type, ApplianceType name) {
        super(type, name, OVEN_IDLE, OVEN_RUNNING, OVEN_DURABILITY);
    }
}
