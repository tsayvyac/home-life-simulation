package cz.cvut.fel.omo.nullable;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import cz.cvut.fel.omo.smarthome.room.Window;

import java.util.List;

/**
 * Interface for nullable room
 */
public interface NullableRoom extends Nullable {

    /**
     * Gets floor of the room
     *
     * @return floor
     */
    Nullable getFloor();

    /**
     * Gets room type
     *
     * @return room type
     */
    RoomType getRoomType();

    /**
     * Add executor to the room
     *
     * @param executor executor to be added
     */
    void addExecutor(Executor executor);

    /**
     * Remove executor from the room
     *
     * @param executor executor to be removed
     */
    void removeExecutor(Executor executor);

    /**
     * Gets list of windows in the room
     *
     * @return list of windows
     */
    List<Window> getWindows();

    /**
     * Gets list of appliances in the room
     *
     * @return list of appliances
     */
    List<Appliance> getApplianceList();

    /**
     * Gets list of items in the room
     *
     * @return list of items
     */
    List<Item> getItemList();
}
