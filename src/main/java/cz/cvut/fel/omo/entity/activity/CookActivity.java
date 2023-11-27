package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.appliance.Stove;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.appliance.state.StateOff;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static cz.cvut.fel.omo.util.Constant.FOOD_ON_STOVE;
import static cz.cvut.fel.omo.util.Constant.FOOD_IN_OVEN;

@Slf4j
public class CookActivity extends Activity {

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

        boolean applianceForCook = Helper.getRandomInt(3) == 0 ?
                findAppliance(ApplianceType.OVEN) : findAppliance(ApplianceType.STOVE);
        if (fridge.isPresent() && applianceForCook) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            if (fridge.get().getState() instanceof StateOff)
                fridge.get().getState().switchIdle();

            if (this.appliance instanceof Stove)
                ((Fridge) fridge.get()).addFood(
                        new Food(FOOD_ON_STOVE[Helper.getRandomInt(FOOD_ON_STOVE.length)]));
            else
                ((Fridge) fridge.get()).addFood(
                        new Food(FOOD_IN_OVEN[Helper.getRandomInt(FOOD_IN_OVEN.length)]));
            log.info("Fridge contains: {}", ((Fridge) fridge.get()).getFridgeContent());
        }
    }
}
