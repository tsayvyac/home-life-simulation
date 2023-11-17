package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.exception.EventErrorException;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PERSON;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_APPLIANCE;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PET;

@Slf4j(topic = "Event Generator")
public class EventGenerator {
    private static final Home home = Home.getInstance();
    private static final List<Class<? extends Event>> personEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_PERSON);
    private static final List<Class<? extends Event>> applianceEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_APPLIANCE);
    private static final List<Class<? extends Event>> petEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_PET);

    private EventGenerator() {}

    public static void generateRandomEvent(int tick) {
        Event event;
        if (tick % 2 == 0)
            event = generate(personEvents);
        else if (tick % 5 == 0)
            event = generate(petEvents);
        else if (tick % 23 == 0)
            event = generate(applianceEvents);
        else
            event = new NullEvent();
        event.setExecutor(getRandomExecutor(event));
        home.addEvent(event);

        event.execute();
    }

    private static Event generate(List<Class<? extends Event>> events) {
        int rnd = Helper.getRandomInt(events.size());
        try {
            return events.get(rnd)
                    .getDeclaredConstructor(String.class, Executor.class)
                    .newInstance(events.get(rnd).getSimpleName(), null);
        } catch (Exception e) {
            throw new EventErrorException("Event execution error. Please check " +
                    "constructor access modifier of event you want to add. It must be public!" +
                    "Or constructor must have only 2 parameters. 3rd you define manually");
        }
    }

    // TODO: Change implementation
    private static Executor getRandomExecutor(Event event) {
        List<Executor> executors = Home.getInstance().getAllExecutors()
                .stream()
                .filter(executor ->
                        executor.getRole().getType().contains(event.getType())
                                && executor.getStatus() == ExecutorStatus.FREE
                )
                .toList();
        return executors.get(Helper.getRandomInt(executors.size()));
    }
}
