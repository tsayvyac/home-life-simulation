package cz.cvut.fel.omo.nullable;

import cz.cvut.fel.omo.smarthome.room.RoomType;

public interface NullableRoom extends Nullable {
    Nullable getFloor();
    RoomType getRoomType();
}
