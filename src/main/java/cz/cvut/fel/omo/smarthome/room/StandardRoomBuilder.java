package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.smarthome.home.Floor;

/**
 * Standard implementation of the {@link RoomBuilder} interface.
 * This class follows the Singleton pattern and offers a single instance of this class.
 */
public final class StandardRoomBuilder implements RoomBuilder {
    /**
     * The single instance of the {@link StandardRoomBuilder} class.
     */
    public static final StandardRoomBuilder INSTANCE = new StandardRoomBuilder();
    /**
     * The {@link Room} object being constructed.
     */
    private Room room;

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private StandardRoomBuilder() {
    }

    @Override
    public RoomBuilder reset() {
        room = new Room();
        return this;
    }

    @Override
    public RoomBuilder setFloor(Floor floor) {
        room.setFloor(floor);
        floor.addRoom(room);
        return this;
    }

    @Override
    public RoomBuilder setRoomType(RoomType roomType) {
        room.setRoomType(roomType);
        return this;
    }

    @Override
    public RoomBuilder addAppliance(Appliance appliance) {
        room.addAppliance(appliance);
        return this;
    }

    @Override
    public RoomBuilder addItem(Item item) {
        room.addItem(item);
        return this;
    }


    @Override
    public RoomBuilder addWindow(Window window) {
        room.addWindow(window);
        return this;
    }
}
