package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
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
                .addRoom(RoomType.WORKROOM);
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
                .addRoom(RoomType.CHILDRENROOM);
    }
}
