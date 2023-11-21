package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.PLAYSTATION_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.PLAYSTATION_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.PLAYSTATION_DURABILITY;

public class Playstation extends HomeAppliance {

    public Playstation(SourceType type, ApplianceType name) {
        super(type, name, PLAYSTATION_IDLE, PLAYSTATION_RUNNING, PLAYSTATION_DURABILITY);
    }
}
