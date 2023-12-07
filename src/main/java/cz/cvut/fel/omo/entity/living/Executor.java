package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.component.Component;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Executor is a class that represents a person that can execute activities.
 **/
@Getter
@Setter
public abstract class Executor implements Component {

    /**
     * Executor has a room in which he is located.
     */
    protected Room room;

    /**
     * Executor has a status that can be either FREE or BUSY.
     */
    protected ExecutorStatus status = ExecutorStatus.FREE;

    /**
     * Executor has a queue of activities that he can execute.
     */
    protected Queue<Activity> activityQueue = new LinkedList<>();

    /**
     * Executor has an appliance that he can use.
     */
    protected Appliance appliance;

    /**
     * Executor has an item that he can use.
     */
    protected Item item;

    /**
     * Role of the executor.
     */
    protected Role role;

    /**
     * Durability of the executor.
     */
    private int ticks;

    /**
     * Constructor of the executor.
     *
     * @param role Role of the executor.
     */
    protected Executor(Role role) {
        this.role = role;
    }

    /**
     * Method that adds an activity to the queue.
     *
     * @param activities List of activities that will be added to the queue.
     */
    public void addActivityToQueue(List<Activity> activities) {
        activityQueue.addAll(activities);
    }

    /**
     * Method that turns on the appliance.
     */
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

    /**
     * Method that immediately stops and clears the queue.
     */
    public void immediatelyStopAndClearQueue() {
        this.ticks = 0;
        this.activityQueue.clear();
        release();
    }

    /**
     * Method that releases the executor.
     */
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

    /**
     * Method that executes the first activity in the queue.
     */
    public void executeFirstInQueue() {
        if (this.status == ExecutorStatus.FREE && !activityQueue.isEmpty()) {
            Activity activity = activityQueue.poll();
            execute(activity);
        }
    }

    /**
     * Method that executes the activity.
     *
     * @param activity Activity that will be executed.
     */
    private void execute(Activity activity) {
        activity.execute(this);
    }

    /**
     * Method that sets the status of the executor.
     *
     * @param status   Status that will be set.
     * @param activity Activity that the executor is executing.
     */
    public void setStatus(ExecutorStatus status, Activity activity) {
        this.status = status;

        ActivityAndUsageReporter.add(this.getRole() + ": I'M BUSY! " + activity.getName());
    }
}
