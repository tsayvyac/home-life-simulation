package cz.cvut.fel.omo.event.sensor;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.RunOutActivity;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when flame detector detects fire
 */
public class FlameDetectorEvent extends Event {

    /**
     * Constructor for FlameDetectorEvent
     *
     * @param name      name of the event
     * @param appliance appliance of the event
     */
    public FlameDetectorEvent(String name, Appliance appliance) {
        super(name, appliance, null);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new RunOutActivity()
        );
    }
}
