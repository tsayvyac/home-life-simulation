package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.CircuitBreaker;
import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;

/**
 * Interface defines a contract for building homes. Implementing classes
 * should provide methods for configuring and constructing homes with various floors, rooms,
 * inhabitants, and room-building components.
 */
public interface HomeBuilder {

    /**
     * Reset the builder to create a new home instance.
     *
     * @return Instance for method chaining.
     */
    HomeBuilder reset();

    /**
     * Add a floor to the home with the specified floor number.
     *
     * @param floorNumber The floor number to add.
     * @return A {@link cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder.FloorBuilder} instance for configuring the added floor and its rooms.
     */
    StandardHomeBuilder.FloorBuilder addFloor(int floorNumber);

    /**
     * Add a person as an inhabitant of the home.
     *
     * @param person The {@link Person} to add.
     * @return Instance for method chaining.
     */
    HomeBuilder addPerson(Person person);

    /**
     * Add a circuit breaker.
     *
     * @param circuitBreaker The {@link CircuitBreaker} to add.
     * @return Instance for method chaining.
     */
    HomeBuilder addCircuitBreaker(Appliance circuitBreaker);

    /**
     * Add a temperature sensor.
     *
     * @param temperatureSensor The {@link cz.cvut.fel.omo.appliance.TemperatureSensor} to add.
     * @return Instance for method chaining.
     */
    HomeBuilder addTemperatureSensor(Appliance temperatureSensor);

    /**
     * Add a pet as an inhabitant of the home.
     *
     * @param pet The {@link Pet} to add.
     * @return Instance for method chaining.
     */
    HomeBuilder addPet(Pet pet);

    /**
     * Set the current {@link RoomBuilder} and {@link ApplianceFactory} for configuring rooms.
     *
     * @param roomBuilder      The room builder to use for creating rooms.
     * @param applianceFactory The factory for creating appliances.
     * @return Instance for method chaining.
     */
    HomeBuilder setRoomBuilderAndApplianceFactory(RoomBuilder roomBuilder, ApplianceFactory applianceFactory);
}
