package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.updatable.Updatable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
@Getter
@Setter
public abstract class Executor implements Updatable {
    protected NullableRoom room = NullRoom.INSTANCE;
    protected ExecutorStatus status = ExecutorStatus.FREE;
    protected Queue<Activity> emergencyActivities = new LinkedList<>();
    protected Role role;
    private int ticks;

    protected Executor(Role role) {
        this.role = role;
    }

    public void execute(Activity activity) {
        activity.execute(this);
    }

    @Override
    public void update() {
        if (ticks > 0) {
            log.info("UPDATE");
            ticks--;
            if (ticks == 0) {
                status = ExecutorStatus.FREE;

                // TODO: Delete this. ONLY FOR TESTING
                log.info("{}: I'M FREE!", this.getRole());

                Activity emergency = emergencyActivities.poll();
                if (emergency != null) {
                    ticks = 0;
                    execute(emergency);
                }
            }
        }
    }

    // TODO: Delete this. ONLY FOR TESTING
    public void setStatus(ExecutorStatus status) {
        this.status = status;
        log.info("{}: I'M BUSY!", this.getRole());
    }
}
