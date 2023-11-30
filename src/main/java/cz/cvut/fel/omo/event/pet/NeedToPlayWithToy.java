package cz.cvut.fel.omo.event.pet;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.PlayToyActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when pet needs to play with toy
 */
public class NeedToPlayWithToy extends Event {

    /**
     * Constructor for NeedToPlayWithToy
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToPlayWithToy(String name, Executor executor) {
        super(name, executor, Type.PET);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new PlayToyActivity()
        );
    }
}
