package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.smarthome.home.Floor;

public final class StandardRoomBuilder implements RoomBuilder {
    public static final StandardRoomBuilder INSTANCE = new StandardRoomBuilder();
    private  Room room;

    private StandardRoomBuilder() {}

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
}
