package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class WatchTVActivity extends Activity {

    public WatchTVActivity() {
        super(RoomType.LIVINGROOM, 3, "Watching TV");
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.TV)){
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
    }
}
