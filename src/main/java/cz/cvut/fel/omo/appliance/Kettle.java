package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.KETTLE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.KETTLE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.KETTLE_DURABILITY;

public class Kettle extends HomeAppliance {

    public Kettle(SourceType type, ApplianceType name) {
        super(type, name, KETTLE_IDLE, KETTLE_RUNNING, KETTLE_DURABILITY);
    }
}
