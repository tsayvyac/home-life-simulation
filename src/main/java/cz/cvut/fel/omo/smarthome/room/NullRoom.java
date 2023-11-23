package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.nullable.Nullable;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.NullFloor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NullRoom implements NullableRoom {
    public static final NullRoom INSTANCE = new NullRoom();

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

    @Override
    public void addExecutor(Executor executor) {
        // nullRoom have no logic of this method
    }

    @Override
    public void removeExecutor(Executor executor) {
        // nullRoom have no logic of this method
    }

    @Override
    public List<Appliance> getApplianceList() {
        return Collections.emptyList();
    }

    @Override
    public List<Item> getItemList() {
        return Collections.emptyList();
    }

    @Override
    public List<Window> getWindows() {
        return Collections.emptyList();
    }

}
