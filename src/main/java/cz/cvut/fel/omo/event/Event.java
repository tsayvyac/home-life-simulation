package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;

import java.util.List;

public final class Event {
    private final String name;
    private final Type executorType;
    private final List<Activity> solveChain;

    public Event(String name, Type executorType, List<Activity> solveChain) {
        this.name = name;
        this.executorType = executorType;
        this.solveChain = solveChain;
    }
}
