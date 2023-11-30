package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;

/**
 * StateBroken represents a state of a home appliance when it is broken.
 * It is not possible to switch on, off or idle the appliance in this state.
 * The appliance is not consuming any energy in this state.
 */
public class StateBroken extends State {

    /**
     * Constructor for StateBroken.
     *
     * @param appliance Home appliance which is in this state.
     */
    public StateBroken(HomeAppliance appliance) {
        super(appliance);
        appliance.setZeroConsumption();
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
