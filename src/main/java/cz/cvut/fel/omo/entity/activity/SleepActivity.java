package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Sleep activity")
public class SleepActivity extends Activity{

    public SleepActivity() {
        super(RoomType.BEDROOM, 8, "SLEEP");
    }

    @Override
    protected void solve() {
        this.executor.setStatus(ExecutorStatus.SLEEP);
    }
}
