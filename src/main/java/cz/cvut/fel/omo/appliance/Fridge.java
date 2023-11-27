package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.event.person.NeedToCook;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.FRIDGE_IDLE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.FRIDGE_RUNNING;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.FRIDGE_DURABILITY;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fridge extends HomeAppliance {
    private final Queue<Food> foodQueue = new LinkedList<>();

    public Fridge(SourceType type, ApplianceType name) {
        super(type, name, FRIDGE_IDLE, FRIDGE_RUNNING, FRIDGE_DURABILITY);
    }

    public void addFood(Food... food) {
        this.foodQueue.addAll(List.of(food));
    }

    public Food getFood() {
        if (foodQueue.isEmpty()) {
            notify(new NeedToCook(NeedToCook.class.getSimpleName(), null), Type.ADULT);
        }
        return foodQueue.poll();
    }

    public Queue<Food> getFridgeContent() {
        return foodQueue;
    }
}
