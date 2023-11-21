package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.SchoolActivity;
import cz.cvut.fel.omo.entity.activity.WalkActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

public class NeedToSchool extends Event {
    public NeedToSchool(String name, Executor executor) {
        super(name, executor, Type.KID);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new WalkActivity(),
                new SchoolActivity()
        );
    }
}
