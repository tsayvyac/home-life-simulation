package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of taking shower
 */
public class TakeShowerActivity extends Activity {

    /**
     * Constructor for TakeShowerActivity
     */
    public TakeShowerActivity() {
        super(1, "Take shower activity", RoomType.BATHROOM);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
