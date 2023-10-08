package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.smarthome.room.RoomBuilder;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public final class HomeDirector {
    public static final HomeDirector INSTANCE = new HomeDirector();

    private HomeDirector() {}

    public void buildSmallHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder) {
        homeBuilder.reset().setRoomBuilder(roomBuilder)
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

    public void buildBigHouse(HomeBuilder homeBuilder, RoomBuilder roomBuilder) {
        homeBuilder.reset().setRoomBuilder(roomBuilder)
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
