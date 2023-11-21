package cz.cvut.fel.omo.appliance;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.COMPUTER_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.COMPUTER_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.COMPUTER_DURABILITY;

public class Computer extends HomeAppliance {

    public Computer(SourceType type, ApplianceType name) {
        super(type, name, COMPUTER_IDLE, COMPUTER_RUNNING, COMPUTER_DURABILITY);
    }

}
