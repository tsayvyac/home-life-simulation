package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.state.StateBroken;
import cz.cvut.fel.omo.appliance.state.StateOn;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Getter
public abstract class Activity {
    protected final RoomType roomType;
    protected final int ticksToSolve;
    protected final String name;
    protected Appliance appliance;
    protected Item item;
    protected Executor executor;

    protected Activity(RoomType roomType, int ticksToSolve, String name) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
    }

    protected Activity(RoomType roomType, int ticksToSolve, String name, Appliance appliance) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
        this.appliance = appliance;
    }

    protected Activity(RoomType roomType, int ticksToSolve, String name, Item item) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
        this.item = item;
    }

    public void execute(Executor executor) {
        executor.setStatus(ExecutorStatus.BUSY, this);
        executor.setTicks(this.ticksToSolve);
        // TODO: Change room by floor or address in memory if appliance != null and by roomType
        if (this.roomType != null && executor.getRoom().getRoomType() != this.roomType)
            changeRoom(executor, this.roomType);

        this.executor = executor;
        solve();
    }

    private void changeRoom(Executor executor, RoomType roomType) {
        NullableRoom toRoom = Home.getInstance().getAllRooms().stream()
                .filter(room -> room.getRoomType() == roomType)
                .findFirst()
                .orElse(NullRoom.INSTANCE);

        NullableRoom room = executor.getRoom();
        if (roomType != RoomType.OUTSIDE) {
            room.removeExecutor(executor);
            toRoom.addExecutor(executor);
        }
        log.info("{} changed room from {} to {}", executor.getRole(), room.getRoomType(), toRoom.getRoomType());
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
}
