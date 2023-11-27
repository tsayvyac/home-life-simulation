package cz.cvut.fel.omo.event.sensor;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.smarthome.home.Home;

import java.util.Collections;
import java.util.List;

public class TempratureSensorEvent extends Event {

    public TempratureSensorEvent(String name, Appliance appliance) {
        super(name, appliance);
    }

    @Override
    protected List<Activity> init() {
        Home.getInstance().activateTemperatureSensor();
        return Collections.emptyList();
    }
}
