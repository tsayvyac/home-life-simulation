package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

/**
 * StateOn represents a state of a home appliance when it is on.
 * The appliance is consuming running energy in this state.
 */
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
}

