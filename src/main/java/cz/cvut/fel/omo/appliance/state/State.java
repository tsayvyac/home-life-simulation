package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.appliance.manual.BrokennessLevel;
import cz.cvut.fel.omo.util.Helper;

/**
 * Abstract class representing state of the appliance.
 * <p>
 * Each state has a reference to the appliance it belongs to.
 * <p>
 * Each state has a method to set the brokenness level of the appliance.
 * <p>
 * Each state has abstract methods to switch the appliance on, off, to idle and to break it.
 */
public abstract class State {

    /**
     * Reference to the appliance this state belongs to.
     */
    HomeAppliance appliance;

    /**
     * Constructor of the state.
     *
     * @param appliance appliance this state belongs to
     */
    protected State(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    /**
     * Sets the brokenness level of the appliance.
     * <p>
     * The brokenness level is set randomly.
     */
    protected void setBrokennessLevel() {
        BrokennessLevel[] levels = BrokennessLevel.values();
        int randomIndex = Helper.getRandomInt(levels.length);
        appliance.setBrokennessLevel(levels[randomIndex]);
    }

    /**
     * Abstract methods to switch the appliance on, off, to idle and to break it.
     */
    public abstract void switchOn();

    /**
     * Abstract methods to switch the appliance on, off, to idle and to break it.
     */
    public abstract void switchOff();

    /**
     * Abstract methods to switch the appliance on, off, to idle and to break it.
     */
    public abstract void switchIdle();

    /**
     * Abstract methods to switch the appliance to break it.
     */
    public abstract void breakThis();
}
