package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class Activity {
    protected final RoomType roomType;
    protected final int ticksToSolve;
    protected final String name;
    protected final Type activityType;

    protected Activity(RoomType roomType, int ticksToSolve, String name, Type activityType) {
        this.roomType = roomType;
        this.ticksToSolve = ticksToSolve;
        this.name = name;
        this.activityType = activityType;
    }

    public void execute(Executor executor) {
        executor.setStatus(ExecutorStatus.BUSY);
        executor.setTicks(this.ticksToSolve);
        if (executor.getRoom().getRoomType() != this.roomType)
            changeRoom(executor, this.roomType);
        solve(executor);
    }

    public void changeRoom(Executor executor, RoomType roomType) {
        NullableRoom toRoom = Home.getInstance().getAllRooms().stream()
                .filter(room -> room.getRoomType() == roomType)
                .findFirst()
                .orElse(NullRoom.INSTANCE);

        if (roomType != RoomType.OUTSIDE)
            executor.getRoom().removeExecutor(executor);
        toRoom.addExecutor(executor);
        executor.setRoom(toRoom);
    }

    protected abstract void solve(Executor executor);
}
