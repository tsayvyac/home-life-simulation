package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity of studying in school
 */
public class SchoolActivity extends Activity {

    /**
     * Constructor for SchoolActivity
     */
    public SchoolActivity() {
        super(9, "Study in school activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
