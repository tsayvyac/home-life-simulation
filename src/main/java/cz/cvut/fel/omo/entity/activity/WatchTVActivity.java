package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of watching TV
 */
public class WatchTVActivity extends Activity {

    /**
     * Constructor for WatchTVActivity
     */
    public WatchTVActivity() {
        super(3, "Watching TV activity", RoomType.LIVINGROOM, RoomType.CHILDRENROOM, RoomType.BEDROOM, RoomType.WORKROOM);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.TV)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + " is watching TV");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
