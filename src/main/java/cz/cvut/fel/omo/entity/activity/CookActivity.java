package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

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
        super(RoomType.KITCHEN, 4, "COOK FOOD ACTIVITY");
    }

    @Override
    protected void solve() {
        var applianceList = this.executor.getRoom().getApplianceList();
        Optional<Appliance> fridge = applianceList.stream()
                .filter(app -> app.getName() == ApplianceType.FRIDGE)
                .filter(app -> !(app.getState() instanceof StateBroken))
                .findFirst();

        // TODO: Add oven (?)
        if (fridge.isPresent() && findAppliance(ApplianceType.STOVE)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ((Fridge) fridge.get()).addFood(
                    new Food(FOOD_NAMES_ARRAY[Helper.getRandomInt(FOOD_NAMES_ARRAY.length)])
            );
            log.info("Fridge contains: {}", ((Fridge) fridge.get()).getFridgeContent());
        }
    }
}
