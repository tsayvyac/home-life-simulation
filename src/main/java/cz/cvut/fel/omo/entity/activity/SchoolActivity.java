package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolActivity extends Activity {

    public SchoolActivity(RoomType roomType, int ticksToSolve) {
        super(roomType, ticksToSolve, "STUDY IN SCHOOL");
    }

    @Override
    protected void solve(Executor executor) {

    }
}