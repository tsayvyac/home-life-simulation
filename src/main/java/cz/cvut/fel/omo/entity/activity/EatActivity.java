package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class EatActivity extends Activity {

    public EatActivity() {
        super(RoomType.KITCHEN, 2, "EAT FOOD PERSON");
    }

    @Override
    protected void solve(Executor executor) {

    }
}
