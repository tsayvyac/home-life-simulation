package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class PlayActivity extends Activity {

    public PlayActivity(RoomType roomType, int ticksToSolve) {
        super(roomType, ticksToSolve, "PLAY");
    }

    @Override
    protected void solve() {

    }
}
