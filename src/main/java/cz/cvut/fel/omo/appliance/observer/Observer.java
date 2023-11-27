package cz.cvut.fel.omo.appliance.observer;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.util.Helper;

import java.util.List;

public class Observer {
    private final List<Executor> listeners = Home.getInstance().getAllExecutors();

    public void notifyRandomListener(Event event, Type type) {
        if (!listeners.isEmpty()) {
            List<Executor> adults = listeners.stream()
                    .filter(e -> e.getRole().getType().contains(type))
                    .toList();
            Executor executor = adults.get(Helper.getRandomInt(adults.size()));
            event.setExecutor(executor);
            executor.addActivityToQueue(event.getSolveChain());
            Home.getInstance().addEvent(event);
        }
    }
}
