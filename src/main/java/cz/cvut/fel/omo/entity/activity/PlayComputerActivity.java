package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayComputerActivity extends Activity {

    public PlayComputerActivity() {
        super(RoomType.CHILDRENROOM, 2, "PlAY COMPUTER");
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.COMPUTER)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
        log.info("{} is playing COMPUTER", this.executor.getRole());
    }
}
