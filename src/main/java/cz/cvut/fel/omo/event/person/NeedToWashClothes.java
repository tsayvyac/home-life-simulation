package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.WashClothesActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

public class NeedToWashClothes extends Event {

    public NeedToWashClothes(String name, Executor executor) {
        super(name, executor, Type.ADULT);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new WashClothesActivity()
        );
    }
}
