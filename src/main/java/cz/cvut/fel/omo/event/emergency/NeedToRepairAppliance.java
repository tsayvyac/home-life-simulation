package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.Collections;
import java.util.List;

public class NeedToRepairAppliance extends Event {

    public NeedToRepairAppliance(String name, Executor executor) {
        super(name, executor, Type.ADULT);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
