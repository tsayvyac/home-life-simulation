package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.STOVE_DURABILITY;

public class Stove extends HomeAppliance {

    public Stove(SourceType type, ApplianceType name) {
        super(type, name, STOVE_IDLE, STOVE_RUNNING, STOVE_DURABILITY);
    }
}
