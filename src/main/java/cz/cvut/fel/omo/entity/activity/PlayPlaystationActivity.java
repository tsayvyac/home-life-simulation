package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of playing playstation
 */
public class PlayPlaystationActivity extends Activity {

    /**
     * Constructor for PlayPlaystationActivity
     */
    public PlayPlaystationActivity() {
        super(2, "Play playstation activity", RoomType.LIVINGROOM, RoomType.CHILDRENROOM);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.PLAYSTATION)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + " is playing PLAYSTATION");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
