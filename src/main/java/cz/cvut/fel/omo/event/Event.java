package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Abstract class representing event
 */
@Getter
@Setter
public abstract class Event {

    /**
     * Executor of the event
     */
    private Executor executor;

    /**
     * List of executors of the event
     */
    private List<Executor> executorList;

    /**
     * Name of the event
     */
    private final String name;

    /**
     * Type of the event
     */
    private final List<Activity> solveChain;

    /**
     * Type of the event
     */
    private Type type;

    /**
     * Appliance of the event
     */
    protected Appliance appliance;

    /**
     * Constructor for Event when we know which executor will manipulate with appliance
     *
     * @param name      name of the event
     * @param executor  executor of the event
     * @param type      type of the event
     * @param appliance appliance of the event
     */
    protected Event(String name, Executor executor, Type type, Appliance appliance) {
        this.name = name;
        this.executor = executor;
        this.type = type;
        this.appliance = appliance;
        this.solveChain = init();
    }

    /**
     * Constructor for Event when we don't know with which appliance will executor manipulate
     *
     * @param name     name of the event
     * @param executor executor of the event
     * @param type     type of the event
     */
    protected Event(String name, Executor executor, Type type) {
        this.name = name;
        this.executor = executor;
        this.type = type;
        this.solveChain = init();
    }

    /**
     * Constructor for Event for emergency events (e.g. fire)
     *
     * @param name      name of the event
     * @param appliance appliance of the event
     * @param all       list of executors of the event
     */
    protected Event(String name, Appliance appliance, List<Executor> all) {
        this.name = name;
        this.appliance = appliance;
        this.executorList = all;
        this.solveChain = init();
    }

    /**
     * Constructor for Event when we need to execute event for all executors (e.g. vacation)
     *
     * @param name name of the event
     * @param type type of the event
     * @param all  list of executors of the event
     */
    protected Event(String name, Type type, List<Executor> all) {
        this.name = name;
        this.type = type;
        this.executorList = all;
        this.solveChain = init();
    }

    /**
     * Constructor for Event which automatically executes event
     *
     * @param name      name of the event
     * @param appliance appliance of the event
     */
    protected Event(String name, Appliance appliance) {
        this.name = name;
        this.appliance = appliance;
        this.solveChain = init();
    }

    /**
     * Executes event for executor
     */
    public void executeForExecutor() {
        this.executor.addActivityToQueue(this.solveChain);
    }

    /**
     * Executes event for all executors
     */
    public void executeForAll() {
        this.executorList.forEach(e -> {
            e.immediatelyStopAndClearQueue();
            e.addActivityToQueue(this.solveChain);
        });
        Home.getInstance().turnOffAll();
    }

    /**
     * Executes event for sensor
     */
    public void executeForSensor() {
        executeForAll();
    }

    /**
     * Initializes event
     *
     * @return list of activities
     */
    protected abstract List<Activity> init();
}
