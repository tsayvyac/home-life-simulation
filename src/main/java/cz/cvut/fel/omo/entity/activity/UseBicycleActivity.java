package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class UseBicycleActivity extends Activity {
    public UseBicycleActivity() {
        super(RoomType.OUTSIDE, 1, "Use bicycle");
    }

    @Override
    protected void solve(Executor executor) {

    }
}
