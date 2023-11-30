package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.CookActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when person needs to cook
 */
public class NeedToCook extends Event {

    /**
     * Constructor for NeedToCook
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToCook(String name, Executor executor) {
        super(name, executor, Type.ADULT);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new CookActivity()
        );
    }
}
