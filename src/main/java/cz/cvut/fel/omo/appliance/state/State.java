package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.util.Helper;

public abstract class State {
    HomeAppliance appliance;

    protected State(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    protected void setBrokennessLevel() {
        BrokennessLevel[] levels = BrokennessLevel.values();
        int randomIndex = Helper.getRandomInt(levels.length);
        appliance.setBrokennessLevel(levels[randomIndex]);
    }

    public abstract void switchOn();
    public abstract void switchOff();
    public abstract void switchIdle();
    public abstract void breakThis();
}
