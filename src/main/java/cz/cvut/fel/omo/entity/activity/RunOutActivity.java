package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.room.RoomType;
public class RunOutActivity extends Activity {

    public RunOutActivity() {
        super(4, "All executors run out of house activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        if (this.executor.getRole().getType().contains(Type.PERSON))
            ActivityAndUsageReporter.add("FIREFIGHTERS! HELP US!");
    }
}
