package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FridgeEmptyEvent extends Event {
    public FridgeEmptyEvent(String name, Executor executor, Type type) {
        super(name, executor, type);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
