package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.util.Helper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Home {
    private static Home instance;
    private List<Floor> floorList = new ArrayList<>();
    private boolean isPowerEnable;

    private Home() {
        isPowerEnable = true;
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public <T extends Executor> void addExecutor(T o) {
        int floorIndex = Helper.getRandomInt(floorList.size());
        floorList
                .get(floorIndex)
                .getRoomList()
                .get(Helper.getRandomInt(floorList.get(floorIndex).getRoomList().size()))
                .addExecutor(o);
    }

    public static Home getInstance() {
        if (instance == null)
            instance = new Home();
        return instance;
    }
}
