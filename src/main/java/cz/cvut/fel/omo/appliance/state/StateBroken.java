package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateBroken extends State {

    public StateBroken(HomeAppliance appliance) {
        super(appliance);
    }

    @Override
    public void switchOn() {
        // Does not work in this state
    }

    @Override
    public void switchOff() {
        // Does not work in this state
    }

    @Override
    public void switchIdle() {
        // Does not work in this state
    }

    @Override
    public void breakThis() {
        // Does not work in this state
    }
}
