package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.KeyWrapper;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of playing computer
 */
public class PlayComputerActivity extends Activity {

    /**
     * Constructor for PlayComputerActivity
     */
    public PlayComputerActivity() {
        super(2, "Play computer activity", RoomType.CHILDRENROOM, RoomType.WORKROOM);
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.COMPUTER)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();

            ActivityAndUsageReporter.add(this.executor.getRole() + " is playing COMPUTER");
            ActivityAndUsageReporter.put(new KeyWrapper(this.executor.getRole(), this.appliance.getName()));
        }
    }
}
