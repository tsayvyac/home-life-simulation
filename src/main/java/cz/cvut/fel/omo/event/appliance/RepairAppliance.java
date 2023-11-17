package cz.cvut.fel.omo.event.appliance;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.Collections;
import java.util.List;

public class RepairAppliance extends Event {

    public RepairAppliance(String name, Executor executor) {
        super(name, executor, Type.ADULT);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
