package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.RepairActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Event that is created when appliance is broken and needs to be repaired
 */
@Slf4j
public class NeedToRepairAppliance extends Event {

    /**
     * Constructor for NeedToRepairAppliance
     *
     * @param name      name of the event
     * @param executor  executor of the event
     * @param appliance appliance that needs to be repaired
     */
    public NeedToRepairAppliance(String name, Executor executor, Appliance appliance) {
        super(name, executor, Type.ADULT, appliance);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new RepairActivity(this.getAppliance())
        );
    }
}
