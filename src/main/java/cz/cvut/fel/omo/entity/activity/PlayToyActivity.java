package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of playing toy
 */
public class PlayToyActivity extends Activity {
    public PlayToyActivity() {
        super(3, "Play with toy activity", RoomType.LIVINGROOM, RoomType.WORKROOM, RoomType.CHILDRENROOM);
    }

    @Override
    protected void solve() {
        ActivityAndUsageReporter.add(this.executor.getRole() + " is playing with toy");
    }
}
