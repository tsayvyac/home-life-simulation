package cz.cvut.fel.omo.appliance;

import com.sun.nio.sctp.MessageInfo;
import cz.cvut.fel.omo.appliance.documentation.BrokennessLevel;
import cz.cvut.fel.omo.appliance.state.*;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Random;

@Getter
@Setter
public class HomeAppliance implements Appliance {
    protected final ApplianceType type;
    protected String name;
    protected Room room;
    protected double consumption;
    protected State state;
    protected BrokennessLevel brokennessLevel;

    private final Random random = new Random();

    public HomeAppliance(ApplianceType type, String name, double consumption, Room room) {
        this.type = type;
        this.name = name;
        this.consumption = consumption;
        this.room = room;
    }

    @Override
    public void turnOn() {
        setState(new StateOn(this));
    }

    @Override
    public void turnOff() {
        setState(new StateOff(this));
    }

    @Override
    public void breakThis() {
        setBrokennessLevel();
        setState(new BrokenState(this));
        // TODO change consumption
    }

    @Override
    public void pause() {
        setState(new IdleState(this));
    }


    @Override
    public String collectData() {
        return null;
    }

    @Override
    public void use(Executor executor) {

    }

    @Override
    public void setBrokennessLevel() {
        BrokennessLevel[] levels = BrokennessLevel.values();
        int randomIndex = random.nextInt(levels.length);
        this.brokennessLevel = levels[randomIndex];
    }

}
