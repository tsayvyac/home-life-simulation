package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkActivity extends Activity {

    public WorkActivity(RoomType roomType, int tickToSolve) {
        super(roomType, tickToSolve, "WORK IN OFFICE");
    }

    @Override
    protected void solve(Executor executor) {

    }
}