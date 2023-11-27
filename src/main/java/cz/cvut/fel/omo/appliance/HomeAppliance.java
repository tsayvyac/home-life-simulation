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
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public abstract class HomeAppliance implements Appliance {
    protected final SourceType sourceType;
    protected ApplianceType name;
    @Setter protected Room room;
    protected double totalConsumption;
    protected double currentConsumption;
    protected double idleConsumption;
    protected double runningConsumption;
    protected int initialDurability;
    @Setter protected int durability;
    protected Manual manual;
    @Setter protected State state;
    @Setter protected BrokennessLevel brokennessLevel;
    protected final Observer observer = new Observer();
    protected double count = 0;

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
    public String collectData() {
        return null;
    }

    @Override
    public void decreaseDurability() {
        if (this.durability != 0) {
            this.durability--;
            log.info("{}: Durability {}", this.name, this.durability);
            if (this.durability == 0)
                breakYourself();
        }
    }

    @Override
    public void breakYourself() {
        this.state.breakThis();
        log.info("{} is broken. Please repair!", this.name);
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
        log.info("{} repaired by {}", this.name, executor.getRole());
    }

    @Override
    public void update() {
        this.totalConsumption += this.currentConsumption;
    }
}
