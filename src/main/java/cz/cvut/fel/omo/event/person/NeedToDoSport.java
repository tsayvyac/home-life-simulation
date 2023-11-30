package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.DoSportActivity;
import cz.cvut.fel.omo.entity.activity.TakeShowerActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when person needs to do sport
 */
public class NeedToDoSport extends Event {

    /**
     * Constructor for NeedToDoSport
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToDoSport(String name, Executor executor) {
        super(name, executor, Type.PERSON);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new DoSportActivity(),
                new TakeShowerActivity()
        );
    }
}
