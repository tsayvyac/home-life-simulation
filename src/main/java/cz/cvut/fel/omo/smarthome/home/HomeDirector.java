package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.person.Role;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.entity.living.pet.Type;
import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public final class HomeDirector {
    public static final HomeDirector INSTANCE = new HomeDirector();

    private HomeDirector() {}

    /**
     * Creates small house configuration
     * 2 floors, 6 rooms, 6 persons, 3 pets
     *
     * @param homeBuilder {@link HomeBuilder} build house for this configuration
     * @param roomBuilder {@link RoomBuilder} build rooms for this configuration
     */
    public void buildSmallHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        homeBuilder.reset().setRoomBuilderAndApplianceFactory(roomBuilder, applianceFactory)
                .addFloor(1)
                .addRoom(RoomType.KITCHEN)
                .addRoom(RoomType.GARAGE)
                .addRoom(RoomType.LIVINGROOM)
                .and()
                .addFloor(2)
                .addRoom(RoomType.BEDROOM)
                .addRoom(RoomType.CHILDRENROOM)
                .addRoom(RoomType.WORKROOM)
                .and()
                .addPerson(new Person("Marge", Role.MOTHER))
                .addPerson(new Person("Homer", Role.FATHER))
                .addPerson(new Person("Bart", Role.SON))
                .addPerson(new Person("Lisa", Role.DAUGHTER))
                .addPerson(new Person("Abraham", Role.GRANDFATHER))
                .addPerson(new Person("Mona", Role.GRANDMOTHER))
                .addPet(new Pet("Santa's Little Helper", Type.DOG))
                .addPet(new Pet("Snowball", Type.CAT))
                .addPet(new Pet("Bart Junior", Type.FROG));
    }

    /**
     * Creates big house configuration
     *
     * @param homeBuilder {@link HomeBuilder} build house for this configuration
     * @param roomBuilder {@link RoomBuilder} build rooms for this configuration
     */
    public void buildBigHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder, ApplianceFactory applianceFactory) {
        homeBuilder.reset().setRoomBuilderAndApplianceFactory(roomBuilder, applianceFactory)
                .addFloor(1)
                .addRoom(RoomType.KITCHEN)
                .addRoom(RoomType.GARAGE)
                .and()
                .addFloor(2)
                .addRoom(RoomType.WORKROOM)
                .addRoom(RoomType.BEDROOM)
                .addRoom(RoomType.LIVINGROOM)
                .addRoom(RoomType.CHILDRENROOM)
                .and()
                .addPerson(new Person("Marge", Role.MOTHER))
                .addPerson(new Person("Homer", Role.FATHER))
                .addPerson(new Person("Bart", Role.SON))
                .addPerson(new Person("Lisa", Role.DAUGHTER))
                .addPerson(new Person("Abraham", Role.GRANDFATHER))
                .addPerson(new Person("Mona", Role.GRANDMOTHER))
                .addPet(new Pet("Santa's Little Helper", Type.DOG))
                .addPet(new Pet("Snowball", Type.CAT))
                .addPet(new Pet("Bart Junior", Type.FROG));
    }
}
