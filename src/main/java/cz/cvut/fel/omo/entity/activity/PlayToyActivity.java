package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class PlayToyActivity extends Activity {
    public PlayToyActivity() {
        super(RoomType.LIVINGROOM, 3, "PLAY WITH TOY");
    }

    @Override
    protected void solve(Executor executor) {

    }
}
