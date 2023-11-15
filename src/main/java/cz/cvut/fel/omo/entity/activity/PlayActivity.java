package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class PlayActivity extends Activity {

    protected PlayActivity(RoomType roomType, int ticksToSolve) {
        super(roomType, ticksToSolve, "PLAY", Type.KID);
    }

    @Override
    protected void solve(Executor executor) {

    }
}
