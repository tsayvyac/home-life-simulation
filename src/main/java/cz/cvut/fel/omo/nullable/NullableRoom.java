package cz.cvut.fel.omo.nullable;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.smarthome.room.Window;

import java.util.List;

public interface NullableRoom extends Nullable {
    Nullable getFloor();
    RoomType getRoomType();
    void addExecutor(Executor executor);
    void removeExecutor(Executor executor);
    List<Window> getWindows();
    List<Appliance> getApplianceList();
    List<Item> getItemList();
}
