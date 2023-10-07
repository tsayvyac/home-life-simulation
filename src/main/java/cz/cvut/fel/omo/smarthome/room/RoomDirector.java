package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.smarthome.Floor;

public final class RoomDirector {
    public static final RoomDirector INSTANCE = new RoomDirector();
    // applianceFactory

    private RoomDirector() {}

    public void buildRoom(RoomBuilder roomBuilder, RoomType roomType, Floor floor) {
        switch (roomType) {
            case KITCHEN -> buildKitchen(roomBuilder, floor);
            case LIVINGROOM -> buildLivingroom(roomBuilder, floor);
            case BATHROOM -> buildBathroom(roomBuilder, floor);
            case CHILDRENROOM -> buildChildrenroom(roomBuilder, floor);
            case BEDROOM -> buildBedroom(roomBuilder, floor);
            case GARAGE -> buildGarage(roomBuilder, floor);
            case WORKROOM -> buildWorkroom(roomBuilder, floor);
        }
    }

    private void buildKitchen(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildLivingroom(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildBathroom(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildChildrenroom(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildBedroom(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildGarage(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }

    private void buildWorkroom(RoomBuilder roomBuilder, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor);
    }
}
