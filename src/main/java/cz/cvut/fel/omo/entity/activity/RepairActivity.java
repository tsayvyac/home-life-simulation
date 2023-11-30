package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;

public class RepairActivity extends Activity {

    public RepairActivity(Appliance appliance) {
        super(4, "Find manual and repair appliance activity", appliance, appliance.getRoom().getRoomType());
    }

    @Override
    protected void solve() {
        this.appliance.repair(this.executor);
    }
}
