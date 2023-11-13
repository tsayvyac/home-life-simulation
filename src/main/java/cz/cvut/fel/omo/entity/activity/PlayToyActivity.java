package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.activity.marker.PetActivity;
import cz.cvut.fel.omo.entity.living.Executor;

public class PlayToyActivity extends Activity implements PetActivity {
    protected PlayToyActivity(int ticksToSolve) {
        super(ticksToSolve);
    }

    @Override
    protected void solve(Executor executor) {

    }
}
