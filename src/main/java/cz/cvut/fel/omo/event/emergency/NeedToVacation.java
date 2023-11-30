package cz.cvut.fel.omo.event.emergency;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.activity.VacationActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when person needs to go on vacation
 */
public class NeedToVacation extends Event {

    /**
     * Constructor for NeedToVacation
     *
     * @param name name of the event
     * @param all  list of all executors
     */
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
