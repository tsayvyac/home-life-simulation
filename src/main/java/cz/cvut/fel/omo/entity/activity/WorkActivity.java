package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of working in an office
 */
public class WorkActivity extends Activity {

    /**
     * Constructor for WorkActivity
     */
    public WorkActivity() {
        super(9, "Work in an office activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
