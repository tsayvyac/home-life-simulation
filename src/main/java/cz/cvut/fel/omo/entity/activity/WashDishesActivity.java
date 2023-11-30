package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of washing dishes in dishwasher
 */
public class WashDishesActivity extends Activity {

    /**
     * Constructor for WashDishesActivity
     */
    public WashDishesActivity() {
        super(1, "Wash dishes activity", RoomType.KITCHEN);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.DISHWASHER)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + " is using DISHWASHER");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
