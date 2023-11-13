package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.activity.marker.KidActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.person.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolActivity extends Activity implements KidActivity {

    protected SchoolActivity(int ticksToSolve) {
        super(ticksToSolve);
    }

    @Override
    protected void solve(Executor executor) {
        Person person = (Person) executor;
        log.info("{} is studying in room {}", person.getName(), person.getRoom().getRoomType());
    }
}
