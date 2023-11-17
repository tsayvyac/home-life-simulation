package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.updatable.Updatable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
@Getter
@Setter
public abstract class Executor implements Updatable {
    protected NullableRoom room = NullRoom.INSTANCE;
    protected ExecutorStatus status = ExecutorStatus.FREE;
    protected Queue<Activity> activityQueue = new LinkedList<>();
    protected Role role;
    private int ticks;

    protected Executor(Role role) {
        this.role = role;
    }

    public void addActivityToQueue(List<Activity> activities) {
        activityQueue.addAll(activities);
        executeFirstInQueue();
    }

    @Override
    public void update() {
        if (ticks > 0) {
            log.info("UPDATE");
            ticks--;
            if (ticks == 0) {
                // TODO: Delete this. ONLY FOR TESTING
                log.info("{}: I'M FREE!", this.getRole());
                if (!activityQueue.isEmpty()) {
                    Activity activity = activityQueue.poll();
                    execute(activity);
                } else status = ExecutorStatus.FREE;
            }
        }
    }

    private void executeFirstInQueue() {
        if (!activityQueue.isEmpty())
            execute(activityQueue.poll());
    }

    private void execute(Activity activity) {
        activity.execute(this);
    }

    // TODO: Delete this. ONLY FOR TESTING
    public void setStatus(ExecutorStatus status) {
        this.status = status;
        log.info("{}: I'M BUSY!", this.getRole());
    }
}
