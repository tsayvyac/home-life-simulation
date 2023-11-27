package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.VacationActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

public class NeedToVacation extends Event {

    public NeedToVacation(String name, List<Executor> all) {
        super(name, Type.PERSON, all);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new VacationActivity()
        );
    }
}
