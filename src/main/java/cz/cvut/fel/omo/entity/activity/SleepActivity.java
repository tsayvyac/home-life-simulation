package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class SleepActivity extends Activity {

    public SleepActivity() {
        super(8, "Sleep activity", RoomType.BEDROOM, RoomType.LIVINGROOM);
    }

    @Override
    protected void solve() {
        this.executor.setStatus(ExecutorStatus.SLEEP);
    }
}
