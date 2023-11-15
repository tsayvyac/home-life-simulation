package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.entity.living.person.Person;

public abstract class State {

    HomeAppliance appliance;

    public State(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    public abstract void switchOn(HomeAppliance appliance);
    public abstract void switchOff(HomeAppliance appliance);
    public abstract void pause(HomeAppliance appliance);
    public abstract void _break(HomeAppliance appliance);
    public abstract void repair(HomeAppliance appliance);
    public abstract void use(Person person, HomeAppliance appliance);



}
