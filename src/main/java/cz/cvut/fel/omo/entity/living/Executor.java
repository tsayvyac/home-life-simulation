package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.component.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
public abstract class Executor implements Component {
    protected NullableRoom room = NullRoom.INSTANCE;
    protected ExecutorStatus status = ExecutorStatus.FREE;
    protected Queue<Activity> activityQueue = new LinkedList<>();
    protected Appliance appliance;
    protected Item item;
    protected Role role;
    private int ticks;

    protected Executor(Role role) {
        this.role = role;
    }

    public void addActivityToQueue(List<Activity> activities) {
        activityQueue.addAll(activities);
    }

    public void turnOnAppliance() {
        this.appliance.turnOn();
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitExecutor(this);
    }

    @Override
    public void update() {
        if (this.ticks >= 0) {
            this.ticks--;
            if (this.ticks <= 0) {
                release();
                ActivityAndUsageReporter.add(this.getRole() + ": I'M FREE!");
            }
        }
    }

    public void immediatelyStopAndClearQueue() {
        this.ticks = 0;
        this.activityQueue.clear();
        release();
    }

    private void release() {
        if (this.appliance != null) {
            this.appliance.idle();
            this.appliance.decreaseDurability();
            this.appliance = null;
        } else if (this.item != null) {
            this.item.setFree();
            this.item = null;
        }
        this.status = ExecutorStatus.FREE;
    }

    public void executeFirstInQueue() {
        if (this.status == ExecutorStatus.FREE && !activityQueue.isEmpty()) {
            Activity activity = activityQueue.poll();
            execute(activity);
        }
    }

    private void execute(Activity activity) {
        activity.execute(this);
    }

    public void setStatus(ExecutorStatus status, Activity activity) {
        this.status = status;

        ActivityAndUsageReporter.add(this.getRole() + ": I'M BUSY! " + activity.getName());
    }
}
