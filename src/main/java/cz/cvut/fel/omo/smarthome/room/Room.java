package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.report.Visitor;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.component.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing room in the home
 */
@Getter
@Setter
@NoArgsConstructor
public class Room implements NullableRoom, Component {

    /**
     * Floor where the room is
     */
    private Floor floor;

    /**
     * Type of the room
     */
    private RoomType roomType;

    /**
     * List of appliances in the room
     */
    private List<Appliance> applianceList = new ArrayList<>();

    /**
     * List of items in the room
     */
    private List<Item> itemList = new ArrayList<>();

    /**
     * List of executors in the room
     */
    private List<Executor> executorList = new ArrayList<>();

    /**
     * List of windows in the room
     */
    private List<Window> windows = new ArrayList<>();

    /**
     * Constructor for room
     *
     * @param floor    floor where the room is
     * @param roomType type of the room
     */
    public Room(Floor floor, RoomType roomType) {
        this.floor = floor;
        this.roomType = roomType;
    }

    /**
     * Add appliance to the room
     *
     * @param appliance appliance to be added
     */
    public void addAppliance(Appliance appliance) {
        applianceList.add(appliance);
        appliance.setRoom(this);
    }

    /**
     * Add item to the room
     *
     * @param item item to be added
     */
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
    public String accept(Visitor visitor) {
        return visitor.visitRoom(this);
    }

    @Override
    public void update() {
        for (var executor : this.executorList)
            executor.update();
        for (var appliance : this.applianceList)
            appliance.update();
    }
}
