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

@Getter
public abstract class Activity {
    protected final RoomType[] roomType;
    protected final int ticksToSolve;
    protected final String name;
    protected Appliance appliance;
    protected Item item;
    protected Executor executor;

    protected Activity(int ticksToSolve, String name, RoomType ...roomType) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
    }

    protected Activity(int ticksToSolve, String name, Appliance appliance, RoomType ...roomType) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
        this.appliance = appliance;
    }

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

    protected void relocateToOutside() {
        changeRoom(this.executor, RoomType.OUTSIDE);
    }

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

    protected abstract void solve();

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
