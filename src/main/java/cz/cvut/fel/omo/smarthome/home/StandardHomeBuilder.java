package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.exception.CreationException;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomDirector;
import cz.cvut.fel.omo.smarthome.room.RoomType;


public final class StandardHomeBuilder implements HomeBuilder {
    public static final StandardHomeBuilder INSTANCE = new StandardHomeBuilder();
    private static final RoomDirector ROOM_DIRECTOR = RoomDirector.INSTANCE;
    private Home home = Home.getInstance();
    private RoomBuilder roomBuilder;
    private ApplianceFactory applianceFactory;

    private StandardHomeBuilder() {}

    @Override
    public HomeBuilder reset() {
        home = Home.getInstance();
        return this;
    }

    @Override
    public FloorBuilder addFloor(int floorNumber) {
        if (home.getFloorList().stream().anyMatch(f -> f.getFloorNumber() <= 0))
            throw new CreationException("Floor number must be greater than 0");
        if (home.getFloorList().stream().anyMatch(f -> f.getFloorNumber() != floorNumber - 1) && floorNumber != 1)
            throw new CreationException("You should create a floor number " + (floorNumber - 1));
        if (home.getFloorList().stream().anyMatch(f -> f.getFloorNumber() == floorNumber))
            throw new CreationException("Floor number " + floorNumber + " already exist.");

        Floor floor = new Floor(floorNumber);
        home.addFloor(floor);
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

    protected class FloorBuilder {
        private final Floor floor;

        public FloorBuilder(Floor floor) {
            this.floor = floor;
        }

        public FloorBuilder addRoom(RoomType roomType) {
            ROOM_DIRECTOR.buildRoom(roomBuilder, applianceFactory, roomType, floor);
            return this;
        }

        public HomeBuilder and() {
            return StandardHomeBuilder.this;
        }
    }
}
