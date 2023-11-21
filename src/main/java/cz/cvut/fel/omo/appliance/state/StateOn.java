package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateOn extends State {

    public StateOn(HomeAppliance appliance) {
        super(appliance);
        appliance.setRunningConsumption();
    }

    @Override
    public void switchOn() {
        // Does not work in this state
    }

    @Override
    public void switchOff() {
        appliance.setState(new StateOff(appliance));
    }

    @Override
    public void switchIdle() {
        appliance.setState(new StateIdle(appliance));
    }

    @Override
    public void breakThis() {
        setBrokennessLevel();
        appliance.setState(new StateBroken(appliance));
    }
}

