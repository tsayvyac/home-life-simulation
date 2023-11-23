package cz.cvut.fel.omo.event.sensor;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.event.Event;

import java.util.Collections;
import java.util.List;

public class ForTest extends Event {
    public ForTest(String name, Appliance appliance) {
        super(name, appliance);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
