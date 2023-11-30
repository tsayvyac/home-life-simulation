package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class MakeCoffeeActivity extends Activity {

    public MakeCoffeeActivity() {
        super(1, "Make coffee activity", RoomType.KITCHEN);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.KETTLE)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + ": Coffee is ready");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
