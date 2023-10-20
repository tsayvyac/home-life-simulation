package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class FixingState implements State {
    HomeAppliance appliance;
    private final StateType state;

    public FixingState(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.FIXING;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
