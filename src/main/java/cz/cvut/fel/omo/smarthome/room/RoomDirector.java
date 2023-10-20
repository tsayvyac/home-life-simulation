package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.smarthome.Floor;

public final class RoomDirector {
    public static final RoomDirector INSTANCE = new RoomDirector();

    private RoomDirector() {}

    public void buildRoom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, RoomType roomType, Floor floor) {
        switch (roomType) {
            case KITCHEN -> buildKitchen(roomBuilder, applianceFactory, floor);
            case LIVINGROOM -> buildLivingroom(roomBuilder, applianceFactory, floor);
            case BATHROOM -> buildBathroom(roomBuilder, applianceFactory, floor);
            case CHILDRENROOM -> buildChildrenroom(roomBuilder, applianceFactory, floor);
            case BEDROOM -> buildBedroom(roomBuilder, applianceFactory, floor);
            case GARAGE -> buildGarage(roomBuilder, applianceFactory, floor);
            case WORKROOM -> buildWorkroom(roomBuilder, applianceFactory, floor);
        }
    }

    private void buildKitchen(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.KITCHEN)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createFridge())
                .addAppliance(applianceFactory.createKettle())
                .addAppliance(applianceFactory.createDishwasher())
                .addAppliance(applianceFactory.createOven())
                .addAppliance(applianceFactory.createStove());
    }

    private void buildLivingroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.LIVINGROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createCircuitBreaker())
                .addAppliance(applianceFactory.createTV())
                .addAppliance(applianceFactory.createPlaystation());
    }

    private void buildBathroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.BATHROOM)
                .addAppliance(applianceFactory.createLeakDetector())
                .addAppliance(applianceFactory.createWashingMachine());
    }

    private void buildChildrenroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.CHILDRENROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createComputer())
                .addAppliance(applianceFactory.createTV())
                .addAppliance(applianceFactory.createPlaystation());
    }

    private void buildBedroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.BEDROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createTV());
    }

    private void buildGarage(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.GARAGE)
                .addAppliance(applianceFactory.createFlameDetector());
    }

    private void buildWorkroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.WORKROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createComputer())
                .addAppliance(applianceFactory.createTV());
    }
}
