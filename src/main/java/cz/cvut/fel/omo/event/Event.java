package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public abstract class Event {
    @Setter
    private Executor executor;
    private final String name;
    private final List<Activity> solveChain;
    private Appliance appliance;
    private Type type;

    protected Event(String name, Executor executor, Type type) {
        this.name = name;
        this.executor = executor;
        this.solveChain = init();
        this.type = type;
    }

    protected Event(String name, Appliance appliance) {
        this.name = name;
        this.appliance = appliance;
        this.solveChain = init();
    }

    public void execute() {
        executor.addActivityToQueue(solveChain);
    }

    protected abstract List<Activity> init();
}
