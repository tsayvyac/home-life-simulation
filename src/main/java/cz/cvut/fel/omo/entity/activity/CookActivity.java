package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.appliance.Stove;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.appliance.state.StateOff;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.util.Helper;

import java.util.Optional;

import static cz.cvut.fel.omo.util.Constant.FOOD_IN_OVEN;
import static cz.cvut.fel.omo.util.Constant.FOOD_ON_STOVE;

public class CookActivity extends Activity {

    public CookActivity() {
        super(4, "Cook food activity", RoomType.KITCHEN);
    }

    @Override
    protected void solve() {
        var applianceList = this.executor.getRoom().getApplianceList();
        Optional<Appliance> fridge = applianceList.stream()
                .filter(app -> app.getName() == ApplianceType.FRIDGE)
                .filter(app -> !(app.getState() instanceof StateBroken))
                .findFirst();

        boolean applianceForCook = Helper.getRandomInt(3) == 0 ?
                findAppliance(ApplianceType.OVEN) : findAppliance(ApplianceType.STOVE);
        if (fridge.isPresent() && applianceForCook) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            if (fridge.get().getState() instanceof StateOff)
                fridge.get().getState().switchIdle();

            Food food;
            if (this.appliance instanceof Stove) {
                food = new Food(FOOD_ON_STOVE[Helper.getRandomInt(FOOD_ON_STOVE.length)]);
                ((Fridge) fridge.get()).addFood(food);
            } else {
                food = new Food(FOOD_IN_OVEN[Helper.getRandomInt(FOOD_IN_OVEN.length)]);
                ((Fridge) fridge.get()).addFood(food);
            }

            ActivityAndUsageReporter.add(food.name() + " is added to the fridge by " + this.executor.getRole());
            ActivityAndUsageReporter.add("Fridge contains: " + ((Fridge) fridge.get()).getFridgeContent());
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), ApplianceType.FRIDGE));
        }
    }
}
