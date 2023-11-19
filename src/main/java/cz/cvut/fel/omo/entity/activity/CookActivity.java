package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CookActivity extends Activity {
    private static final String[] FOOD_NAMES_ARRAY = {
            "Goulash with dumplings",
            "Roast chicken with potatoes",
            "Pizza peperoni",
            "Tonkotsu Ramen",
            "Crab cake",
            "Teriyaki chicken",
            "Beef Stroganoff",
            "Apple pie",
            "Chicken masala"
    };

    public CookActivity() {
        super(RoomType.KITCHEN, 3, "COOK FOOD ACTIVITY");
    }

    @Override
    protected void solve(Executor executor) {
        executor.getRoom().getApplianceList().forEach(appliance -> {
            if (appliance.getName().equals("Fridge") && !(appliance.getState() instanceof StateBroken)) {
                appliance.getState().switchOn();
                ((Fridge) appliance).addFood(
                        new Food(FOOD_NAMES_ARRAY[Helper.getRandomInt(FOOD_NAMES_ARRAY.length)])
                );
                log.info("Fridge contains: {}", ((Fridge) appliance).getFridgeContent());
            }
        });
    }
}
