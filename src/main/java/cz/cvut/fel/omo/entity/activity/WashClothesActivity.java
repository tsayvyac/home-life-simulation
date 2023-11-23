package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class WashClothesActivity extends Activity {

    public WashClothesActivity() {
        super(RoomType.BATHROOM, 2, "Wash in washing machine");
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.WASHING_MACHINE)){
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
    }
}
