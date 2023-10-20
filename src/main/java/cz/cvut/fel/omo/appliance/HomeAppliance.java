package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.state.*;

public class HomeAppliance implements Appliance{

    protected final ApplianceType type;
    protected String name;
    protected Room room;
    protected double consumption;
    protected State state;
    protected BrokennessLevel brokennessLevel;

    public HomeAppliance(ApplianceType type, String name, double consumption, Room room) {
        this.type = type;
        this.name = name;
        this.consumption = consumption;
        this.room = room;
    }


    @Override
    public void turnOn() {
        setCurrentState(new StateON(this));
    }

    @Override
    public void turnOff() {
        setCurrentState(new StateOff(this));
    }

    @Override
    public void _break() {
        setBrokennessLevel();
        setCurrentState(new BrokenState(this));
        // TODO change consumption
    }

    @Override
    public void pause() {
        setCurrentState(new IdleState(this));
    }


    @Override
    public State getState() {
        return this.state;
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

    @Override
    public BrokennessLevel getBrokennessLevel() {
        return brokennessLevel;
    }

    @Override
    public void setBrokennessLevel() {
        BrokennessLevel[] levels = BrokennessLevel.values();
        int randomIndex = (int) (Math.random() * levels.length);
        this.brokennessLevel = levels[randomIndex];
    }

    @Override
    public void setCurrentState(State state) {
        this.state = state;
    }
}
