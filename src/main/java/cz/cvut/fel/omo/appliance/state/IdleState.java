package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

public class IdleState implements State {
    HomeAppliance appliance;
    private final StateType state;

    public IdleState(HomeAppliance appliance) {
        this.appliance = appliance;
        this.state = StateType.IDLE;
    }

    @Override
    public StateType getStateType() {
        return state;
    }
}
