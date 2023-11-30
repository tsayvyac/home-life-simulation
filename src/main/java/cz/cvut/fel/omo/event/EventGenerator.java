package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.Sensor;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.event.emergency.NeedToVacation;
import cz.cvut.fel.omo.event.sensor.FlameDetectorEvent;
import cz.cvut.fel.omo.event.sensor.TemperatureSensorEvent;
import cz.cvut.fel.omo.exception.EventErrorException;
import cz.cvut.fel.omo.report.EventReporter;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PERSON;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_SENSOR;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PET;

/**
 * Class that generates random events
 */
@Slf4j(topic = "Event Generator")
public class EventGenerator {

    /**
     * Singleton instance of Home
     */
    private static final Home home = Home.getInstance();

    /**
     * List of all person events
     */
    private static final List<Class<? extends Event>> personEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_PERSON);

    /**
     * List of all sensor events
     */
    private static final List<Class<? extends Event>> sensorEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_SENSOR);

    /**
     * List of all pet events
     */
    private static final List<Class<? extends Event>> petEvents =
            EventLoader.loadEventsFromPackage(PACKAGE_NAME_PET);

    /**
     * Private constructor for EventGenerator
     */
    private EventGenerator() {
    }

    /**
     * Generates random event
     *
     * @param tick certain tick needs for generating events for each category
     */
    public static void generateRandomEvent(int tick) {
        if (tick % 3 == 0)
            generate(personEvents, true);
        else if (tick % 8 == 0)
            generate(petEvents, true);
        else if (tick % 505 == 0)
            generateVacation();

        home.getAllExecutors().forEach(Executor::executeFirstInQueue);
    }

    /**
     * Generates random event
     *
     * @param events        list of events
     * @param isLivingEvent true if event is living event
     */
    private static void generate(List<Class<? extends Event>> events, boolean isLivingEvent) {
        int rnd = Helper.getRandomInt(events.size());
        try {
            Event event = events.get(rnd)
                    .getDeclaredConstructor(
                            String.class,
                            isLivingEvent ? Executor.class : Appliance.class
                    )
                    .newInstance(events.get(rnd).getSimpleName(), null);

            if (isLivingEvent)
                randomExecutor(event);
            else if (event instanceof FlameDetectorEvent)
                setSensor(event);
        } catch (Exception e) {
            throw new EventErrorException("Event execution error. Please check " +
                    "constructor access modifier of event you want to add. It must be public! " +
                    "Or constructor must have only 2 parameters. 3rd you define manually");
        }
    }

    /**
     * Generates vacation event
     */
    public static void generateVacation() {
        List<Executor> executors = Home.getInstance().getAllExecutors()
                .stream()
                .filter(executor -> executor.getRole().getType().contains(Type.PERSON))
                .toList();
        Event vacationEvent = new NeedToVacation(NeedToVacation.class.getSimpleName(), executors);
        home.addEvent(vacationEvent);
        vacationEvent.executeForAll();
        EventReporter.addEvent(vacationEvent);
    }

    /**
     * Generates random executor
     *
     * @param event event
     */
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
            EventReporter.addEvent(event);
        }

        generateSensorEvent();
    }

    /**
     * Generates sensor event
     */
    private static void generateSensorEvent() {
        if (Helper.getRandomInt(30) == 2) {
            TemperatureSensorEvent event = new TemperatureSensorEvent(TemperatureSensorEvent.class.getSimpleName(), Home.getInstance().getTemperatureSensor());
            EventReporter.addEvent(event);
        } else if (Helper.getRandomInt(280) == 1)
            generate(sensorEvents, false);
    }

    /**
     * Sets sensor
     *
     * @param event event
     */
    private static void setSensor(Event event) {
        List<Appliance> appliances = Home.getInstance().getAllAppliances().stream()
                .filter(Sensor.class::isInstance)
                .toList();

        if (!appliances.isEmpty()) {
            event.setAppliance(appliances.get(Helper.getRandomInt(appliances.size())));
            event.setExecutorList(Home.getInstance().getAllExecutors());
            home.addEvent(event);
            event.executeForSensor();
            EventReporter.addEvent(event);
        }
    }
}
