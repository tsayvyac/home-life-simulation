package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.manual.BrokennessLevel;
import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.component.Component;

/**
 * Interface for all appliances
 */
public interface Appliance extends Component {

    /**
     * @return current state of the appliance
     */
    State getState();

    /**
     * Sets the room of the appliance
     *
     * @param room room to be set
     */
    void setRoom(Room room);

    /**
     * @return source type of the appliance
     */
    SourceType getSourceType();

    /**
     * @return name of the appliance
     */
    ApplianceType getName();

    /**
     * @return total consumption of the appliance
     */
    double getTotalConsumption();

    /**
     * Breaks the appliance, changes its state to broken
     */
    void breakYourself();

    /**
     * Sets the consumption of the appliance to idle consumption
     */
    void setIdleConsumption();

    /**
     * Sets the consumption of the appliance to running consumption
     */
    void setRunningConsumption();

    /**
     * Sets the consumption of the appliance to zero
     */
    void setZeroConsumption();

    /**
     * Repairs the appliance
     *
     * @param executor executor that repairs the appliance
     */
    void repair(Executor executor);

    /**
     * Turns on the appliance, changes its state to on
     */
    void turnOn();

    /**
     * Turns off the appliance, changes its state to off
     */
    void turnOff();

    /**
     * Sets the appliance to idle state
     */
    void idle();

    /**
     * @return room of the appliance
     */
    Room getRoom();

    /**
     * Decreases the durability of the appliance
     */
    void decreaseDurability();

    /**
     * @return brokenness level of the appliance
     */
    BrokennessLevel getBrokennessLevel();
}
