package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateOff extends State {

    public StateOff(HomeAppliance appliance) {
        super(appliance);
        appliance.setZeroConsumption();
    }

    @Override
    public void switchOn() {
        appliance.setState(new StateOn(appliance));
    }

    @Override
    public void switchOff() {
        // Does not work in this state
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
