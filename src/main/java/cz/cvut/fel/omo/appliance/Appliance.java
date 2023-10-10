package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.room.Room;

public interface Appliance {

    void turnOn();
    void turnOff();
    String getState();
    String collectData();
    double getConsumption();
    void setConsumption(double consumption);
    Room getRoom();
    void setRoom(Room room);
    ApplianceType getType();
    String getName();






}
