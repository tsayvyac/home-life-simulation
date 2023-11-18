package cz.cvut.fel.omo.appliance.state;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.entity.living.person.Person;

public class BrokenState extends State {

    public BrokenState(HomeAppliance appliance) {
        super(appliance);
    }

    @Override
    public void switchOn(HomeAppliance appliance) {

    }

    @Override
    public void switchOff(HomeAppliance appliance) {

    }

    @Override
    public void pause(HomeAppliance appliance) {

    }

    @Override
    public void _break(HomeAppliance appliance) {

    }

    @Override
    public void repair(HomeAppliance appliance) {
        appliance.setState(new StateOff(appliance));
    }

    @Override
    public void use(Person person, HomeAppliance appliance) {

    }
}
