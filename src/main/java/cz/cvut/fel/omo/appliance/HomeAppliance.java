package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.smarthome.room.Room;

public class HomeAppliance implements Appliance {

    protected final ApplianceType type;
    protected String name;
    protected Room room;
    private double consumption;

    public HomeAppliance(ApplianceType type, String name, double consumption, Room room) {
        this.type = type;
        this.name = name;
        this.consumption = consumption;
        this.room = room;
    }


    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {

    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String collectData() {
        return null;
    }

    @Override
    public double getConsumption() {
        return consumption;
    }

    @Override
    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public Room getRoom() {
        return room;
    }

    @Override
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public ApplianceType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
