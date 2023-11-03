package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;

public interface HomeBuilder {
    HomeBuilder reset();
    StandardHomeBuilder.FloorBuilder addFloor(int floorNumber);
    HomeBuilder addPerson(Person person);
    HomeBuilder addPet(Pet pet);
    HomeBuilder setRoomBuilderAndApplianceFactory(RoomBuilder roomBuilder, ApplianceFactory applianceFactory);
}
