package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;

import java.time.format.DateTimeFormatter;

public interface Visitor {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    String visitHome(Home home);
    String visitFloor(Floor floor);
    String visitRoom(Room room);
    String visitExecutor(Executor executor);
    String visitAppliance(Appliance appliance);
}
