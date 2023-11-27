package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;

public interface Visitor {
    String visitHome(Home home);
    String visitFloor(Floor floor);
    String visitRoom(Room room);
    String visitExecutor(Executor executor);
    String visitAppliance(Appliance appliance);
}
