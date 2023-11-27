package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;

public class RepairActivity extends Activity {

    public RepairActivity(Appliance appliance) {
        super(appliance.getRoom().getRoomType(), 4, "Repair appliance", appliance);
    }

    @Override
    protected void solve() {
        this.appliance.repair(this.executor);
    }
}
