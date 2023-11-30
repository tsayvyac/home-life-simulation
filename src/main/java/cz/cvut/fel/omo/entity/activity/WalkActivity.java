package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of walking
 */
public class WalkActivity extends Activity {

    /**
     * Constructor for WalkActivity
     */
    public WalkActivity() {
        super(3, "Walk activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
