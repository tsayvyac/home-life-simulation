package cz.cvut.fel.omo.event;

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
    private final Type type;

    protected Event(String name, Executor executor, Type type) {
        this.name = name;
        this.executor = executor;
        this.solveChain = init();
        this.type = type;
    }

    public void execute() {
        executor.addActivityToQueue(solveChain);
    }

    protected abstract List<Activity> init();
}
