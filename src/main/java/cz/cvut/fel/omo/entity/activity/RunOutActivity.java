package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunOutActivity extends Activity {

    public RunOutActivity() {
        super(RoomType.OUTSIDE, 4, "RUN OUT OF THE HOUSE");
    }

    @Override
    protected void solve() {
        if (this.executor.getRole().getType().contains(Type.PERSON))
            log.info("FIREFIGHTERS, HELP US!!!");
    }
}
