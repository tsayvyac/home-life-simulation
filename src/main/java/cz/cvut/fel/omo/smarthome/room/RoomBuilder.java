package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.smarthome.home.Floor;

/**
 * Interface defines the contract for building rooms in a building.
 * Implementing classes should provide methods for configuring and constructing rooms
 * with various attributes, such as room type, appliances, and items.
 */
public interface RoomBuilder {
    /**
     * Reset the builder to create a new {@link Room} instance.
     * @return The {@link RoomBuilder} instance for method chaining.
     */
    RoomBuilder reset();
    /**
     * Set the floor for the {@link Room} being constructed and add the room to the floor.
     * @param floor The {@link Floor} object to set for the {@link Room}.
     * @return The {@link RoomBuilder} instance for method chaining.
     */
    RoomBuilder setFloor(Floor floor);
    /**
     * Set the room type for the {@link Room} being constructed.
     * @param roomType The {@link RoomType} to set for the {@link Room}.
     * @return The {@link RoomBuilder} instance for method chaining.
     */
    RoomBuilder setRoomType(RoomType roomType);
    /**
     * Add an appliance to the {@link Room} being constructed.
     * @param appliance The {@link Appliance} to add to the {@link Room}.
     * @return The {@link RoomBuilder} instance for method chaining.
     */
    RoomBuilder addAppliance(Appliance appliance);
    /**
     * Add an item to the {@link Room} being constructed.
     * @param item The {@link Item} to add to the {@link Room}.
     * @return The {@link RoomBuilder} instance for method chaining.
     */
    RoomBuilder addItem(Item item);
}
