package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.RepairActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class NeedToRepairAppliance extends Event {

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
