package cz.cvut.fel.omo.event.pet;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.Collections;
import java.util.List;

public class NeedToWalkPet extends Event {

    public NeedToWalkPet(String name, Executor executor) {
        super(name, executor, Type.PET);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
