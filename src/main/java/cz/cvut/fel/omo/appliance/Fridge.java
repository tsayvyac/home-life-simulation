package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.person.NeedToCook;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fridge extends HomeAppliance {
    private final Queue<Food> foodQueue = new LinkedList<>();
    public Fridge(ApplianceType type, String name, double consumption) {
        super(type, name, consumption);
    }

    public void notify(Event event) {
        observer.notifyRandomListener(event, Type.ADULT);
    }

    public void addFood(Food ...food) {
        this.foodQueue.addAll(List.of(food));
    }

    public Food getFood() {
        if (foodQueue.isEmpty()) {
            notify(new NeedToCook(NeedToCook.class.getSimpleName(), null));
        }
        return foodQueue.poll();
    }

    public Queue<Food> getFridgeContent() {
        return foodQueue;
    }
}
