package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

public class WalkActivity extends Activity {

    public WalkActivity() {
        super(3, "Walk activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
