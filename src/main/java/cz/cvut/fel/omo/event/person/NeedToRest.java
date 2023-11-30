package cz.cvut.fel.omo.event.person;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.*;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;

import java.util.List;

/**
 * Event that is created when person needs to rest
 */
public class NeedToRest extends Event {

    /**
     * Constructor for NeedToRest
     *
     * @param name     name of the event
     * @param executor executor of the event
     */
    public NeedToRest(String name, Executor executor) {
        super(name, executor, Type.PERSON);
    }

    @Override
    protected List<Activity> init() {
        return List.of(
                new PlayComputerActivity(),
                new PlayPlaystationActivity(),
                new CloseBlindsActivity(),
                new SleepActivity(),
                new OpenBlindsActivity()
        );
    }
}
