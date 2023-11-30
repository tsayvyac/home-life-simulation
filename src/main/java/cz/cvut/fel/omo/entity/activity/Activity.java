package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.appliance.state.StateOn;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.util.Helper;
import lombok.Getter;

import java.util.Optional;

/**
 * Abstract class for all activities
 */
@Getter
public abstract class Activity {
    protected final RoomType[] roomType;
    protected final int ticksToSolve;
    protected final String name;
    protected Appliance appliance;
    protected Item item;
    protected Executor executor;

    /**
     * Constructor for Activity
     *
     * @param ticksToSolve number of ticks needed to solve the activity
     * @param name         name of the activity
     * @param roomType     type of room where the activity can be executed
     */
    protected Activity(int ticksToSolve, String name, RoomType... roomType) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
    }

    /**
     * Constructor for Activity
     *
     * @param ticksToSolve number of ticks needed to solve the activity
     * @param name         name of the activity
     * @param appliance    appliance needed for the activity
     * @param roomType     type of room where the activity can be executed
     */
    protected Activity(int ticksToSolve, String name, Appliance appliance, RoomType... roomType) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
        this.appliance = appliance;
    }

    /**
     * Execute the activity
     *
     * @param executor executor who will execute the activity
     */
    public void execute(Executor executor) {
        executor.setStatus(ExecutorStatus.BUSY, this);
        executor.setTicks(this.ticksToSolve);
        if (this.roomType.length != 0) {
            RoomType rndType = this.roomType[Helper.getRandomInt(this.roomType.length)];
            if (executor.getRoom().getRoomType() != rndType)
                changeRoom(executor, rndType);
        }

        this.executor = executor;
        solve();
    }

    /**
     * Relocate the executor to outside
     */
    protected void relocateToOutside() {
        changeRoom(this.executor, RoomType.OUTSIDE);
    }

    /**
     * Find the appliance in the room
     *
     * @param applianceType type of appliance
     * @return true if the appliance was found, false otherwise
     */
    protected boolean findAppliance(ApplianceType applianceType) {
        Optional<Appliance> app = executor.getRoom().getApplianceList().stream()
                .filter(a -> a.getName() == applianceType)
                .filter(a -> !(a.getState() instanceof StateBroken))
                .filter(a -> !(a.getState() instanceof StateOn))
                .findFirst();

        if (app.isPresent()) {
            this.appliance = app.get();
            return true;
        } else return false;
    }

    /**
     * Abstract method for solving the activity
     */
    protected abstract void solve();

    /**
     * Change the room of the executor
     *
     * @param executor executor who will change the room
     * @param roomType type of room where the executor will be relocated
     */
    private void changeRoom(Executor executor, RoomType roomType) {
        NullableRoom toRoom = Home.getInstance().getAllRooms().stream()
                .filter(room -> room.getRoomType() == roomType)
                .findAny()
                .orElse(NullRoom.INSTANCE);

        NullableRoom room = executor.getRoom();
        if (roomType != RoomType.OUTSIDE) {
            room.removeExecutor(executor);
            toRoom.addExecutor(executor);
        }
        ActivityAndUsageReporter.add(executor.getRole() + " changed room from " + room.getRoomType() + " to " + toRoom.getRoomType());
    }
}
