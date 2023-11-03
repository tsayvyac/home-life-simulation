package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.nullable.Nullable;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.NullFloor;

public class NullRoom implements NullableRoom {

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Nullable getFloor() {
        return new NullFloor();
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.OUTSIDE;
    }
}
