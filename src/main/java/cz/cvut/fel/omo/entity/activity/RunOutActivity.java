package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of running out of house
 */
public class RunOutActivity extends Activity {

    /**
     * Constructor for RunOutActivity
     */
    public RunOutActivity() {
        super(4, "All executors run out of house activity", RoomType.OUTSIDE);
    }

    /**
     * Constructor for RunOutActivity
     */
    @Override
    protected void solve() {
        if (this.executor.getRole().getType().contains(Type.PERSON))
            ActivityAndUsageReporter.add("FIREFIGHTERS! HELP US!");
    }
}
