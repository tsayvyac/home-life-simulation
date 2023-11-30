package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Activity for pet eating
 */
public class PetEatActivity extends Activity {

    /**
     * Constructor for PetEatActivity
     */
    public PetEatActivity() {
        super(2, "Pet eat activity", RoomType.KITCHEN, RoomType.LIVINGROOM);
    }

    @Override
    protected void solve() {
        // Do nothing
    }
}
