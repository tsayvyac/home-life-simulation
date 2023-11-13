package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.activity.marker.AdultActivity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkActivity extends Activity implements AdultActivity {

    protected WorkActivity(int tickToSolve) {
        super(tickToSolve);
    }

    @Override
    protected void solve(Executor executor) {
        Person person = (Person) executor;
        log.info("{} is working in room {}", person.getName(), person.getRoom().getRoomType());
    }
}
