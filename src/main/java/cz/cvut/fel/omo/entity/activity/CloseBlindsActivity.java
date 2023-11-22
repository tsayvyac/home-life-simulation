package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.Blind;
import cz.cvut.fel.omo.smarthome.room.Window;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j(topic = "Close blinds activity")
public class CloseBlindsActivity extends Activity{

    public CloseBlindsActivity() {
        super(null, 1, "CLOSE BLINDS");
    }

    @Override
    protected void solve() {
        List<Blind> blinds = this.executor.getRoom().getWindows().stream()
                .map(Window::getBlind)
                .filter(blind -> !blind.isClosed())
                .toList();

        if (!blinds.isEmpty()) {
            for (var blind : blinds) {
                blind.close();
            }
        }
        log.info("Blinds closed");
    }
}
