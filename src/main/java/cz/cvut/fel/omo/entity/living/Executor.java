package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.updatable.Updatable;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
public abstract class Executor implements Updatable {
    protected NullableRoom room = new NullRoom();
    protected ExecutorStatus status = ExecutorStatus.FREE;
    protected Queue<Activity> emergencyActivities = new LinkedList<>();
    private int ticks;

    public void execute(Activity activity) {
        activity.execute(this);
    }

    @Override
    public void update() {
        ticks--;
        if (ticks <= 0) {
            ticks = 0;
            status = ExecutorStatus.FREE;

            Activity emergency = emergencyActivities.poll();
            if (emergency != null) {
                execute(emergency);
            }
        }
    }
}
