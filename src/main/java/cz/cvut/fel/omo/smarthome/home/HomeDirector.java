package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.Role;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomType;

/**
 * Director for building homes
 */
public final class HomeDirector {

    /**
     * Singleton instance
     */
    public static final HomeDirector INSTANCE = new HomeDirector();

    /**
     * Private constructor for director
     */
    private HomeDirector() {
    }

    /**
     * Creates small house configuration
     * 2 floors, 7 rooms, 6 persons, 3 pets
     *
     * @param homeBuilder {@link HomeBuilder} build house for this configuration
     * @param roomBuilder {@link RoomBuilder} build rooms for this configuration
     */
    public void buildSmallHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        homeBuilder.reset().setRoomBuilderAndApplianceFactory(roomBuilder, applianceFactory)
                .addFloor()
                .addRoom(RoomType.KITCHEN)
                .addRoom(RoomType.GARAGE)
                .addRoom(RoomType.LIVINGROOM)
                .addRoom(RoomType.BATHROOM)
                .and()
                .addFloor()
                .addRoom(RoomType.BEDROOM)
                .addRoom(RoomType.CHILDRENROOM)
                .addRoom(RoomType.WORKROOM)
                .and()
                .addCircuitBreaker(applianceFactory.createCircuitBreaker())
                .addTemperatureSensor(applianceFactory.createTemperatureSensor())
                .addPerson(new Person("Marge", Role.MOTHER))
                .addPerson(new Person("Homer", Role.FATHER))
                .addPerson(new Person("Bart", Role.SON))
                .addPerson(new Person("Lisa", Role.DAUGHTER))
                .addPerson(new Person("Abraham", Role.GRANDFATHER))
                .addPerson(new Person("Mona", Role.GRANDMOTHER))
                .addPet(new Pet("Santa's Little Helper", Role.DOG))
                .addPet(new Pet("Snowball", Role.CAT))
                .addPet(new Pet("Bart Junior", Role.FROG));
    }

    /**
     * Creates big house configuration
     * 3 floors, 9 rooms, 8 persons, 4 pets
     *
     * @param homeBuilder {@link HomeBuilder} build house for this configuration
     * @param roomBuilder {@link RoomBuilder} build rooms for this configuration
     */
    public void buildBigHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        homeBuilder.reset().setRoomBuilderAndApplianceFactory(roomBuilder, applianceFactory)
                .addFloor()
                .addRoom(RoomType.LIVINGROOM)
                .addRoom(RoomType.GARAGE)
                .addRoom(RoomType.KITCHEN)
                .and()
                .addFloor()
                .addRoom(RoomType.WORKROOM)
                .addRoom(RoomType.BATHROOM)
                .addRoom(RoomType.CHILDRENROOM)
                .and()
                .addFloor()
                .addRoom(RoomType.LIVINGROOM)
                .addRoom(RoomType.BATHROOM)
                .addRoom(RoomType.BEDROOM)
                .and()
                .addCircuitBreaker(applianceFactory.createCircuitBreaker())
                .addTemperatureSensor(applianceFactory.createTemperatureSensor())
                .addPerson(new Person("Marge", Role.MOTHER))
                .addPerson(new Person("Homer", Role.FATHER))
                .addPerson(new Person("Bart", Role.SON))
                .addPerson(new Person("Lisa", Role.DAUGHTER))
                .addPerson(new Person("Abraham", Role.GRANDFATHER))
                .addPerson(new Person("Mona", Role.GRANDMOTHER))
                .addPerson(new Person("Herbert", Role.UNCLE))
                .addPerson(new Person("Ling", Role.COUSIN))
                .addPet(new Pet("Santa's Little Helper", Role.DOG))
                .addPet(new Pet("Snowball", Role.CAT))
                .addPet(new Pet("Bart Junior", Role.FROG))
                .addPet(new Pet("Bongo", Role.RABBIT));
    }
}
