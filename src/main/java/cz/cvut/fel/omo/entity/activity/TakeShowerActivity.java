package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

public class TakeShowerActivity extends Activity {

    public TakeShowerActivity() {
        super(RoomType.BATHROOM, 1, "Take shower");
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
