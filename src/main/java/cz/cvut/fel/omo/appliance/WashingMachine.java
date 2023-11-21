package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.WASHING_MACHINE_DURABILITY;

public class WashingMachine extends HomeAppliance {

    public WashingMachine(SourceType type, ApplianceType name) {
        super(type, name, WASHING_MACHINE_IDLE, WASHING_MACHINE_RUNNING, WASHING_MACHINE_DURABILITY);
    }
}
