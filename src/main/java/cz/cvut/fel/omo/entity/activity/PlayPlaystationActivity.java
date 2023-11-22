package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayPlaystationActivity extends Activity{

    public PlayPlaystationActivity() {
        super(RoomType.LIVINGROOM, 2, "PLAY PLAYSTATION");
    }
    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.PLAYSTATION)){
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
        log.info("{} is playing PLAYSTATION", this.executor.getRole());
    }
}
