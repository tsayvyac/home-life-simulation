package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.emergency.FridgeEmptyEvent;

import java.util.LinkedList;
import java.util.Queue;

public class Fridge extends HomeAppliance {

    private final Queue<Food> food = new LinkedList<>();
    public Fridge(ApplianceType type, String name, double consumption) {
        super(type, name, consumption);
    }

    public void notify(Event event) {
        observer.notifyListener(event, Type.ADULT);
    }

    public void addFood(Food food) {
        this.food.add(food);
    }

    public Food getFood() {
        if (food.isEmpty()) {
            notify(new FridgeEmptyEvent(FridgeEmptyEvent.class.getSimpleName(), null, Type.ADULT));
        }
        return food.poll();
    }
}
