package cz.cvut.fel.omo.event.pet;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.WalkActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when pet needs to walk
 */
public class NeedToWalkPet extends Event {

    /**
     * Constructor for NeedToWalkPet
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToWalkPet(String name, Executor executor) {
        super(name, executor, Type.PET);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new WalkActivity()
        );
    }
}
