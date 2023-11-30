package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

public class SchoolActivity extends Activity {

    public SchoolActivity() {
        super(9, "Study in school activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
