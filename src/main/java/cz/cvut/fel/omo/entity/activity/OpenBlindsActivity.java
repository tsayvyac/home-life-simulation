package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.Blind;
import cz.cvut.fel.omo.smarthome.room.Window;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j(topic = "Open blinds activity")
public class OpenBlindsActivity extends Activity {

    public OpenBlindsActivity() {
        super(null, 1, "OPEN BLINDS");
    }

    @Override
    protected void solve() {
        List<Blind> blinds = this.executor.getRoom().getWindows().stream()
                .map(Window::getBlind)
                .filter(blind -> !blind.isClosed())
                .toList();

        if (!blinds.isEmpty()) {
            for (var blind : blinds)
                blind.open();
        }
        log.info("Blinds opened");
    }
}
