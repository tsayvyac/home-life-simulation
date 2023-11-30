package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Fridge;
import cz.cvut.fel.omo.entity.item.Food;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

import java.util.Optional;

/**
 * Activity of eating food from fridge.
 */
public class EatActivity extends Activity {

    /**
     * Constructor for EatActivity.
     */
    public EatActivity() {
        super(2, "Eat food activity", RoomType.KITCHEN);
    }

    @Override
    protected void solve() {
        Optional<Appliance> appliance = this.executor.getRoom().getApplianceList().stream()
                .filter(app -> app.getName() == ApplianceType.FRIDGE)
                .findFirst();

        if (appliance.isPresent()) {
            Food food = ((Fridge) appliance.get()).getFood();
            if (food == null)
                ActivityAndUsageReporter.add(this.executor.getRole() + ": Nothing to eat.");
            else
                ActivityAndUsageReporter.add(this.executor.getRole() + ": Eating " + food.name());

            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), ApplianceType.FRIDGE));
        }
    }
}
