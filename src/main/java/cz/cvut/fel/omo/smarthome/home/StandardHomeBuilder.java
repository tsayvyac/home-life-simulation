package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.CircuitBreaker;
import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.exception.CreationException;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomDirector;
import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.extern.slf4j.Slf4j;

/**
 * Class is an implementation of the {@link HomeBuilder} interface. It provides methods for creating and configuring a home
 * with various floors, rooms, and inhabitants. This class follows the Singleton pattern and
 * offers a single instance.
 */
@Slf4j(topic = "Home builder")
public final class StandardHomeBuilder implements HomeBuilder {
    /**
     * The single instance of thus class.
     */
    public static final StandardHomeBuilder INSTANCE = new StandardHomeBuilder();
    /**
     * The {@link RoomDirector} instance for constructing rooms.
     */
    private static final RoomDirector ROOM_DIRECTOR = RoomDirector.INSTANCE;
    /**
     * The {@link Home} instance being constructed.
     */
    private Home home = Home.getInstance();
    /**
     * The current {@link RoomBuilder} for configuring rooms.
     */
    private RoomBuilder roomBuilder;
    /**
     * The current {@link ApplianceFactory} for configuring rooms.
     */
    private ApplianceFactory applianceFactory;

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private StandardHomeBuilder() {
    }

    @Override
    public HomeBuilder reset() {
        home = Home.getInstance();
        return this;
    }

    @Override
    public FloorBuilder addFloor(int floorNumber) {
        if (home.getFloorList().stream().anyMatch(f -> f.getFloorNumber() <= 0))
            throw new CreationException("Floor number must be greater than 0");
        if (home.getFloorList().stream().noneMatch(f -> f.getFloorNumber() == floorNumber - 1) && floorNumber != 1)
            throw new CreationException("You should create a floor number " + (floorNumber - 1));
        if (home.getFloorList().stream().anyMatch(f -> f.getFloorNumber() == floorNumber))
            throw new CreationException("Floor number " + floorNumber + " already exist.");

        Floor floor = new Floor(floorNumber);
        home.addFloor(floor);
        log.info("Floor number {} is added.", floor.getFloorNumber());
        return new FloorBuilder(floor);
    }

    @Override
    public HomeBuilder addPerson(Person person) {
        home.addExecutor(person);
        return this;
    }

    @Override
    public HomeBuilder addPet(Pet pet) {
        home.addExecutor(pet);
        return this;
    }

    @Override
    public HomeBuilder setRoomBuilderAndApplianceFactory(RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        this.roomBuilder = roomBuilder;
        this.applianceFactory = applianceFactory;
        return this;
    }

    public HomeBuilder addCircuitBreaker(Appliance circuitBreaker) {
        home.setCircuitBreaker((CircuitBreaker) circuitBreaker);
        return this;
    }

    /**
     * Class is a nested inner class of {@link StandardHomeBuilder}. It is used for
     * configuring and adding rooms to a specific floor within a home.
     */
    protected class FloorBuilder {
        /**
         * The {@link Floor} instance being configured by this class.
         */
        private final Floor floor;

        /**
         * Constructor.
         *
         * @param floor The {@link Floor} to be configured.
         */
        public FloorBuilder(Floor floor) {
            this.floor = floor;
        }

        /**
         * Add a room of the specified type to the current floor.
         *
         * @param roomType The type of room to add.
         * @return Instance of {@link FloorBuilder} for method chaining.
         */
        public FloorBuilder addRoom(RoomType roomType) {
            ROOM_DIRECTOR.buildRoom(roomBuilder, applianceFactory, roomType, floor);
            return this;
        }

        /**
         * Complete the floor configuration and return to the parent {@link StandardHomeBuilder}.
         *
         * @return The parent {@link StandardHomeBuilder} instance.
         */
        public HomeBuilder and() {
            return StandardHomeBuilder.this;
        }
    }
}
