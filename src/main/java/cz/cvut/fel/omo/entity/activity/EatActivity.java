package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class EatActivity extends Activity {

    public EatActivity() {
        super(RoomType.KITCHEN, 2, "EAT FOOD PERSON");
    }

    @Override
    protected void solve() {
        Optional<Appliance> appliance = this.executor.getRoom().getApplianceList().stream()
                .filter(app -> app.getName() == ApplianceType.FRIDGE)
                .findFirst();

        if (appliance.isPresent()) {
            Food food = ((Fridge) appliance.get()).getFood();
            if (food == null)
                log.info("{} Nothing to eat.",this.executor.getRole());
            else
                log.info("{} Eating {}", this.executor.getRole(), food.name());
        }
    }
}
