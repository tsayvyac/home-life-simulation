package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class WalkActivity extends Activity {

    public WalkActivity() {
        super(RoomType.OUTSIDE, 3, "WALK ACTIVITY");
    }

    @Override
    protected void solve() {

    }
}
