package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.room.Blind;
import cz.cvut.fel.omo.smarthome.room.Window;

import java.util.List;

public class CloseBlindsActivity extends Activity {

    public CloseBlindsActivity() {
        super(1, "Close blinds activity");
    }

    @Override
    protected void solve() {
        List<Blind> blinds = this.executor.getRoom().getWindows().stream()
                .map(Window::getBlind)
                .filter(blind -> !blind.isClosed())
                .toList();

        if (!blinds.isEmpty()) {
            for (var blind : blinds)
                blind.close();
        }
        ActivityAndUsageReporter.add("Blinds are closed");
    }
}
