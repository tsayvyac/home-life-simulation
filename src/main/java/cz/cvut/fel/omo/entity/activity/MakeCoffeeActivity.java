package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Make coffee activity")
public class MakeCoffeeActivity extends Activity{

    public MakeCoffeeActivity() {
        super(RoomType.KITCHEN, 1, "MAKE COFFEE");
    }

    @Override
    protected void solve() {
        if (findAppliance(ApplianceType.KETTLE)) {
            this.executor.setAppliance(this.appliance);
            this.executor.turnOnAppliance();
        }
        log.info("{}: Coffee is ready", this.executor.getRole());
    }
}
