package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.smarthome.Floor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    private Floor floor;
    private RoomType roomType;
    private List<Appliance> applianceList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    public Room(Floor floor, RoomType roomType) {
        this.floor = floor;
        this.roomType = roomType;
    }

    public void addAppliance(Appliance appliance) {
        applianceList.add(appliance);
        appliance.setRoom(this);
    }

    public void addItem(Item item) {
        itemList.add(item);
    }
}
