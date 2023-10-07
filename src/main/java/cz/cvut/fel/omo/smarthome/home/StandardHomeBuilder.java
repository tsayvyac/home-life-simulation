package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.smarthome.Floor;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomDirector;
import cz.cvut.fel.omo.smarthome.room.RoomType;


public final class StandardHomeBuilder implements HomeBuilder {
    public static final StandardHomeBuilder INSTANCE = new StandardHomeBuilder();
    private RoomBuilder roomBuilder;
    private final RoomDirector roomDirector = RoomDirector.INSTANCE;
    private Home home = Home.getInstance();

    private StandardHomeBuilder() {}

    @Override
    public HomeBuilder reset() {
        home = Home.getInstance();
        return this;
    }

    @Override
    public FloorBuilder addFloor(int floorNumber) {
        // TODO: check IF exist the first floor in house ELSE throw BuildException
        Floor floor = new Floor(floorNumber);
        home.addFloor(floor);
        return new FloorBuilder(floor);
    }

    @Override
    public HomeBuilder addPerson(Person person) {
        home.addPerson(person);
        return this;
    }

    @Override
    public HomeBuilder addPet(Pet pet) {
        home.addPet(pet);
        return this;
    }

    @Override
    public HomeBuilder setRoomBuilder(RoomBuilder roomBuilder) {
        this.roomBuilder = roomBuilder;
        return this;
    }

    protected class FloorBuilder {
        private final Floor floor;
        private final RoomBuilder roomBuilder = StandardHomeBuilder.this.roomBuilder;

        public FloorBuilder(Floor floor) {
            this.floor = floor;
        }

        public FloorBuilder addRoom(RoomType roomType) {
            StandardHomeBuilder.this.roomDirector.buildRoom(roomBuilder, roomType, floor);
            return this;
        }

        public HomeBuilder and() {
            return StandardHomeBuilder.this;
        }
    }
}
