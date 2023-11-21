package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EatActivity extends Activity {

    public EatActivity() {
        super(RoomType.KITCHEN, 2, "EAT FOOD PERSON");
    }

    @Override
    protected void solve(Executor executor) {
        executor.getRoom().getApplianceList().forEach(appliance -> {
            if (appliance.getName() == ApplianceType.FRIDGE) {
                Food food = ((Fridge) appliance).getFood();
                if (food == null)
                    log.info("{} Nothing to eat.",executor.getRole());
                else
                    log.info("{} Eating {}", executor.getRole(), food.name());
            }
        });
    }
}
