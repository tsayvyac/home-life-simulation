package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateOn implements State {
    HomeAppliance appliance;
    private final StateType state;

    public StateOn(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.ON;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
