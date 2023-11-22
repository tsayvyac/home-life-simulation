package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.event.emergency.NeedToRepairAppliance;
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
        if (tick % 3 == 0)
            generate(personEvents, true);
        else if (tick % 8 == 0)
            generate(petEvents, true);
        else if (tick % 101 == 0)
            generate(applianceEvents, false);

        home.getAllExecutors().forEach(Executor::executeFirstInQueue);
    }

    private static void generate(List<Class<? extends Event>> events, boolean isLivingEvent) {
        int rnd = Helper.getRandomInt(events.size());
        try {
            Event event = events.get(rnd)
                    .getDeclaredConstructor(
                            String.class,
                            isLivingEvent? Executor.class : Appliance.class
                    )
                    .newInstance(events.get(rnd).getSimpleName(), null);

            if (isLivingEvent)
                randomExecutor(event);
            else
                randomAppliance(event);
        } catch (Exception e) {
            throw new EventErrorException("Event execution error. Please check " +
                    "constructor access modifier of event you want to add. It must be public!" +
                    "Or constructor must have only 2 parameters. 3rd you define manually");
        }
    }

    private static void randomExecutor(Event event) {
        List<Executor> executors = Home.getInstance().getAllExecutors()
                .stream()
                .filter(executor ->
                        executor.getRole().getType().contains(event.getType())
                                && executor.getStatus() == ExecutorStatus.FREE
                )
                .toList();
        if (!executors.isEmpty()) {
            event.setExecutor(executors.get(Helper.getRandomInt(executors.size())));
            home.addEvent(event);
            event.executeForExecutor();
        }
    }

    private static void randomAppliance(Event event) {
        List<Appliance> appliances = Home.getInstance().getAllAppliances();
        if (!appliances.isEmpty()) {
            event.setAppliance(appliances.get(Helper.getRandomInt(appliances.size())));
            home.addEvent(event);
            event.executeForAppliance();
        }
    }
}
