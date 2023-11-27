package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.WatchTVActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

public class NeedToWatchTV extends Event {

    public NeedToWatchTV(String name, Executor executor) {
        super(name, executor, Type.PERSON);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new WatchTVActivity()
        );
    }
}
