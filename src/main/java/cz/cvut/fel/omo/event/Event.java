package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Event {
    private Executor executor;
    private List<Executor> executorList;
    private final String name;
    private final List<Activity> solveChain;
    private Type type;
    protected Appliance appliance;

    protected Event(String name, Executor executor, Type type, Appliance appliance) {
        this.name = name;
        this.executor = executor;
        this.type = type;
        this.appliance = appliance;
        this.solveChain = init();
    }

    protected Event(String name, Executor executor, Type type) {
        this.name = name;
        this.executor = executor;
        this.type = type;
        this.solveChain = init();
    }

    protected Event(String name, Appliance appliance, List<Executor> all) {
        this.name = name;
        this.appliance = appliance;
        this.executorList = all;
        this.solveChain = init();
    }

    protected Event(String name, Type type, List<Executor> all) {
        this.name = name;
        this.type = type;
        this.executorList = all;
        this.solveChain = init();
    }

    protected Event(String name, Appliance appliance) {
        this.name = name;
        this.appliance = appliance;
        this.solveChain = init();
    }

    public void executeForExecutor() {
        this.executor.addActivityToQueue(this.solveChain);
    }

    public void executeForAll() {
        this.executorList.forEach(e -> {
            e.immediatelyStopAndClearQueue();
            e.addActivityToQueue(this.solveChain);
        });
        Home.getInstance().turnOffAll();
    }

    public void executeForSensor() {
        executeForAll();
    }

    protected abstract List<Activity> init();
}
