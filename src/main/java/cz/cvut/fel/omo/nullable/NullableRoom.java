package cz.cvut.fel.omo.nullable;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public interface NullableRoom extends Nullable {
    Nullable getFloor();
    RoomType getRoomType();
    void addExecutor(Executor executor);
    void removeExecutor(Executor executor);
}
