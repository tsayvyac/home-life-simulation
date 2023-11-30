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

/**
 * Fridge is an appliance that stores food.
 */
public class Fridge extends HomeAppliance {

    /**
     * Queue of food that is stored in fridge.
     */
    private final Queue<Food> foodQueue = new LinkedList<>();

    /**
     * Constructor of Fridge.
     *
     * @param type type of source
     * @param name name of appliance
     */
    public Fridge(SourceType type, ApplianceType name) {
        super(type, name, FRIDGE_IDLE, FRIDGE_RUNNING, FRIDGE_DURABILITY);
    }

    /**
     * Adds food to fridge.
     *
     * @param food food to be added
     */
    public void addFood(Food... food) {
        this.foodQueue.addAll(List.of(food));
    }

    /**
     * Removes first food in queue from fridge.
     */
    public Food getFood() {
        if (foodQueue.isEmpty()) {
            notify(new NeedToCook(NeedToCook.class.getSimpleName(), null), Type.ADULT);
        }
        return foodQueue.poll();
    }

    /**
     * Returns queue of food in fridge.
     *
     * @return queue of food in fridge
     */
    public Queue<Food> getFridgeContent() {
        return foodQueue;
    }
}
