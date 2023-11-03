package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.smarthome.home.Floor;

public interface RoomBuilder {
    RoomBuilder reset();
    RoomBuilder setFloor(Floor floor);
    RoomBuilder setRoomType(RoomType roomType);
    RoomBuilder addAppliance(Appliance appliance);
    RoomBuilder addItem(Item item);
}
