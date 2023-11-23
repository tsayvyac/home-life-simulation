package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

public class PetEatActivity extends Activity {

    public PetEatActivity() {
        super(RoomType.KITCHEN, 2, "PET IS EATING");
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
