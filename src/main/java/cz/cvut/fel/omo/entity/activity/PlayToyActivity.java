package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class PlayToyActivity extends Activity {
    protected PlayToyActivity(RoomType roomType, int ticksToSolve) {
        super(roomType, ticksToSolve, "PLAY WITH TOY", Type.PET);
    }

    @Override
    protected void solve(Executor executor) {

    }
}
