package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of washing clothes in washing machine
 */
public class WashClothesActivity extends Activity {

    /**
     * Constructor for WashClothesActivity
     */
    public WashClothesActivity() {
        super(2, "Wash clothes in washing machine activity", RoomType.BATHROOM);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.WASHING_MACHINE)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + " is using WASHING MACHINE");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
