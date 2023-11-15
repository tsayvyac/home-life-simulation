package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class EatActivity extends Activity {

    protected EatActivity(RoomType roomType, int ticksToSolve) {
        super(roomType, ticksToSolve, "EAT FOOD PERSON", Type.PERSON);
    }

    @Override
    protected void solve(Executor executor) {

    }
}
