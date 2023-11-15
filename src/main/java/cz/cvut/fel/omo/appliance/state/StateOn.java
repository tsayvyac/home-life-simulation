package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.entity.living.person.Person;

public class StateOn extends State {

    public StateOn(HomeAppliance appliance) {
        super(appliance);
    }

    @Override
    public void switchOn(HomeAppliance appliance) {
    }

    @Override
    public void switchOff(HomeAppliance appliance) {
        appliance.setState(new StateOff(appliance));
    }

    @Override
    public void pause(HomeAppliance appliance) {

    }

    @Override
    public void _break(HomeAppliance appliance) {
        appliance.setState(new BrokenState(appliance));
    }

    @Override
    public void repair(HomeAppliance appliance) {

    }

    @Override
    public void use(Person person, HomeAppliance appliance) {

    }
}

