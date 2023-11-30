package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.SchoolActivity;
import cz.cvut.fel.omo.entity.activity.WalkActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when kid needs to go to school
 */
public class NeedToSchool extends Event {

    /**
     * Constructor for NeedToSchool
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
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
