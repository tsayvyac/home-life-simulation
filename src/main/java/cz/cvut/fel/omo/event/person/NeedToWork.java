package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.WalkActivity;
import cz.cvut.fel.omo.entity.activity.WorkActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when adult needs to go to work
 */
public class NeedToWork extends Event {

    /**
     * Constructor for NeedToWork
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToWork(String name, Executor executor) {
        super(name, executor, Type.ADULT);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new WalkActivity(),
                new WorkActivity()
        );
    }
}
