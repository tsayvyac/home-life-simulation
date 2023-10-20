package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class BrokenState implements State {
    HomeAppliance appliance;
    private final StateType state;

    public BrokenState(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.BROKEN;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
