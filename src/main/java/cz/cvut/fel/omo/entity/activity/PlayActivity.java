package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.activity.marker.PersonActivity;
import cz.cvut.fel.omo.entity.living.Executor;

public class PlayActivity extends Activity implements PersonActivity {

    protected PlayActivity(int ticksToSolve) {
        super(ticksToSolve);
    }

    @Override
    protected void solve(Executor executor) {

    }
}
