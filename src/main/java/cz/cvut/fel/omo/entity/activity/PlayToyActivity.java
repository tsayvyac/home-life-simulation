package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayToyActivity extends Activity {
    public PlayToyActivity() {
        super(RoomType.LIVINGROOM, 3, "PLAY WITH TOY");
    }

    @Override
    protected void solve() {
        log.info("{} is playing with toy", this.executor.getRole());
    }
}
