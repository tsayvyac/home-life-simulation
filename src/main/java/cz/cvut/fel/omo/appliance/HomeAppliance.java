package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.manual.BrokennessLevel;
import cz.cvut.fel.omo.appliance.manual.Manual;
import cz.cvut.fel.omo.appliance.observer.Observer;
import cz.cvut.fel.omo.appliance.state.State;
import cz.cvut.fel.omo.appliance.state.StateOff;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.emergency.NeedToRepairAppliance;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

/**
 * HomeAppliance is an abstract class that represents an appliance in a smart home.
 */
@Getter
public abstract class HomeAppliance implements Appliance {

    /**
     * Type of source of appliance.
     */
    protected final SourceType sourceType;

    /**
     * Name of appliance.
     */
    protected ApplianceType name;

    /**
     * Room where appliance is located.
     */
    @Setter
    protected Room room;

    /**
     * Total consumption of appliance.
     */
    protected double totalConsumption;

    /**
     * Current consumption of appliance.
     */
    protected double currentConsumption;

    /**
     * Consumption of appliance when it is idle.
     */
    protected double idleConsumption;

    /**
     * Consumption of appliance when it is running.
     */
    protected double runningConsumption;

    /**
     * Initial durability of appliance.
     */
    protected int initialDurability;

    /**
     * Durability of appliance.
     */
    @Setter
    protected int durability;

    /**
     * Manual of appliance.
     */
    protected Manual manual;

    /**
     * State of appliance.
     */
    @Setter
    protected State state;

    /**
     * Brokenness level of appliance.
     */
    @Setter
    protected BrokennessLevel brokennessLevel;

    /**
     * Observer of appliance.
     */
    protected final Observer observer = new Observer();

    /**
     * Constructor of HomeAppliance.
     *
     * @param sourceType         type of source
     * @param name               name of appliance
     * @param idleConsumption    consumption of appliance when it is idle
     * @param runningConsumption consumption of appliance when it is running
     * @param initialDurability  initial durability of appliance
     */
    protected HomeAppliance(SourceType sourceType, ApplianceType name, double idleConsumption,
                            double runningConsumption, int initialDurability) {
        this.sourceType = sourceType;
        this.name = name;
        this.totalConsumption = 0;
        this.idleConsumption = idleConsumption;
        this.runningConsumption = runningConsumption;
        this.initialDurability = initialDurability;
        this.state = new StateOff(this);
        this.durability = initialDurability;
    }

    /**
     * Notifies observer of appliance.
     *
     * @param event event which will be executed
     * @param type  type of person to be notified
     */
    public void notify(Event event, Type type) {
        observer.notifyRandomListener(event, type);
    }

    @Override
    public void turnOn() {
        this.state.switchOn();
    }

    @Override
    public void turnOff() {
        this.state.switchOff();
    }

    @Override
    public void idle() {
        this.state.switchIdle();
    }

    @Override
    public void setIdleConsumption() {
        this.currentConsumption = this.idleConsumption;
    }

    @Override
    public void setRunningConsumption() {
        this.currentConsumption = this.runningConsumption;
    }

    @Override
    public void setZeroConsumption() {
        this.currentConsumption = 0;
    }

    @Override
    public void decreaseDurability() {
        if (this.durability != 0) {
            this.durability--;
            ActivityAndUsageReporter.add(this.name + ": Durability " + this.durability);
            if (this.durability == 0)
                breakYourself();
        }
    }

    @Override
    public void breakYourself() {
        this.state.breakThis();
        ActivityAndUsageReporter.add(this.name + " is broken. Please repair!");
        notify(
                new NeedToRepairAppliance(
                        NeedToRepairAppliance.class.getSimpleName(),
                        null,
                        this
                ),
                Type.ADULT
        );
    }

    @Override
    public void repair(Executor executor) {
        if (this.manual == null) {
            Manual mn = new Manual(this);
            mn.generateManual();
        }
        this.state = new StateOff(this);
        this.durability = this.initialDurability;
        ActivityAndUsageReporter.add(this.name + " repaired by " + executor.getRole());
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitAppliance(this);
    }

    @Override
    public void update() {
        this.totalConsumption += this.currentConsumption;
    }
}
