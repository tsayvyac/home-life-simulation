package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

/**
 * StateIdle represents a state of a home appliance when it is idle.
 * The appliance is consuming idle energy in this state.
 */
public class StateIdle extends State {

    public StateIdle(HomeAppliance appliance) {
        super(appliance);
        appliance.setIdleConsumption();
    }

    @Override
    public void switchOn() {
        appliance.setState(new StateOn(appliance));
    }

    @Override
    public void switchOff() {
        appliance.setState(new StateOff(appliance));
    }

    @Override
    public void switchIdle() {
        // Does not work in this state
    }

    @Override
    public void breakThis() {
        setBrokennessLevel();
        appliance.setState(new StateBroken(appliance));
    }
}
