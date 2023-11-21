package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.updatable.Updatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Room implements NullableRoom, Updatable {
    private Floor floor;
    private RoomType roomType;
    private List<Appliance> applianceList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<Executor> executorList = new ArrayList<>();
    private List<Window> windows = new ArrayList<>();

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

    @Override
    public void addExecutor(Executor executor) {
        executor.setRoom(this);
        executorList.add(executor);
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    @Override
    public void removeExecutor(Executor executor) {
        executor.setRoom(NullRoom.INSTANCE);
        executorList.remove(executor);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public void update() {
        Iterator<Executor> iterator = this.executorList.iterator();
        while (iterator.hasNext()) {
            Executor executor = iterator.next();
            executor.update();
        }

        for (var appliance: this.applianceList)
            appliance.update();
    }
}
