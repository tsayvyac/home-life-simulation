package cz.cvut.fel.omo.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class StateON implements State{

    HomeAppliance appliance;
    private final StateType state;

    public StateON(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.ON;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
