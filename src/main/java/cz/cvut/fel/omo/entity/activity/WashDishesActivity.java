package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class WashDishesActivity extends Activity {

    public WashDishesActivity() {
        super(RoomType.KITCHEN, 1, "Wash dish");
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.DISHWASHER)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
    }
}
