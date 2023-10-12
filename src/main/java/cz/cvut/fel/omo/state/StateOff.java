package cz.cvut.fel.omo.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateOff implements State {


    HomeAppliance appliance;
    private final StateType state;

    public StateOff(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.OFF;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
