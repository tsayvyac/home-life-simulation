package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;

/**
 * Activity of repairing appliance
 */
public class RepairActivity extends Activity {

    /**
     * Constructor for RepairActivity
     * @param appliance appliance to be repaired
     */
    public RepairActivity(Appliance appliance) {
        super(4, "Find manual and repair appliance activity", appliance, appliance.getRoom().getRoomType());
    }

    @Override
    protected void solve() {
        this.appliance.repair(this.executor);
    }
}
