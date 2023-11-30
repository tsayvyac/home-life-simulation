package cz.cvut.fel.omo.event.sensor;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.smarthome.home.Home;

import java.util.Collections;
import java.util.List;

/**
 * Event that is created when temperature sensor detects temperature change
 */
public class TemperatureSensorEvent extends Event {

    /**
     * Constructor for TemperatureSensorEvent
     *
     * @param name      name of the event
     * @param appliance appliance of the event
     */
    public TemperatureSensorEvent(String name, Appliance appliance) {
        super(name, appliance);
    }

    @Override
    protected List<Activity> init() {
        Home.getInstance().activateTemperatureSensor();
        return Collections.emptyList();
    }
}
