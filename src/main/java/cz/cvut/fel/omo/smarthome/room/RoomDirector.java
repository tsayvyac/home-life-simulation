package cz.cvut.fel.omo.smarthome.room;

import cz.cvut.fel.omo.appliance.factory.ApplianceFactory;
import cz.cvut.fel.omo.entity.item.*;
import cz.cvut.fel.omo.smarthome.home.Floor;
import lombok.extern.slf4j.Slf4j;

/**
 * Class is responsible for directing the construction of rooms using
 * a {@link RoomBuilder} and various other components. It follows the Singleton pattern and provides
 * a single instance for coordinating the building process of different room types.
 * This class abstracts the construction details and allows for the creation of rooms with
 * specific characteristics based on their types.
 */
@Slf4j(topic = "Room director")
public final class RoomDirector {
    /**
     * The single instance of this class.
     */
    public static final RoomDirector INSTANCE = new RoomDirector();

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private RoomDirector() {}

    /**
     * Build a room with the specified characteristics using a {@link RoomBuilder}, {@link ApplianceFactory},
     * {@link RoomType}, and {@link Floor}.
     *
     * @param roomBuilder      The room builder used to construct the room.
     * @param applianceFactory The factory for creating appliances.
     * @param roomType         The type of room to be constructed.
     * @param floor            The floor on which the room is located.
     */
    public void buildRoom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, RoomType roomType, Floor floor) {
        switch (roomType) {
            case KITCHEN -> buildKitchen(roomBuilder, applianceFactory, floor);
            case LIVINGROOM -> buildLivingRoom(roomBuilder, applianceFactory, floor);
            case BATHROOM -> buildBathroom(roomBuilder, applianceFactory, floor);
            case CHILDRENROOM -> buildChildrenRoom(roomBuilder, applianceFactory, floor);
            case BEDROOM -> buildBedroom(roomBuilder, applianceFactory, floor);
            case GARAGE -> buildGarage(roomBuilder, applianceFactory, floor);
            case WORKROOM -> buildWorkroom(roomBuilder, applianceFactory, floor);
            default -> log.warn("That type of room cannot be created.");
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
                .addAppliance(applianceFactory.createStove())
                .addWindow(new Window(new Blind()))
                .addWindow(new Window(new Blind()));
        log.info("Room Kitchen is built.");
    }

    private void buildLivingRoom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.LIVINGROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createCircuitBreaker())
                .addAppliance(applianceFactory.createTV())
                .addAppliance(applianceFactory.createPlaystation())
                .addItem(new PetToy())
                .addWindow(new Window(new Blind()));
        log.info("Room LivingRoom is built.");
    }

    private void buildBathroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.BATHROOM)
                .addAppliance(applianceFactory.createLeakDetector())
                .addAppliance(applianceFactory.createWashingMachine());
        log.info("Room Bathroom is built.");
    }

    private void buildChildrenRoom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.CHILDRENROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createComputer())
                .addAppliance(applianceFactory.createTV())
                .addAppliance(applianceFactory.createPlaystation())
                .addItem(new PetToy())
                .addWindow(new Window(new Blind()));
        log.info("Room ChildrenRoom is built.");
    }

    private void buildBedroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.BEDROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createTV())
                .addWindow(new Window(new Blind()));
        log.info("Room Bedroom is built.");
    }

    private void buildGarage(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.GARAGE)
                .addAppliance(applianceFactory.createFlameDetector())
                .addItem(new Car())
                .addItem(new Bicycle())
                .addItem(new Snowboard())
                .addItem(new Skateboard())
                .addItem(new RollerSkates())
                .addWindow(new Window())
                .addWindow(new Window());
        log.info("Room Garage is built.");
    }

    private void buildWorkroom(RoomBuilder roomBuilder, ApplianceFactory applianceFactory, Floor floor) {
        roomBuilder.reset()
                .setFloor(floor)
                .setRoomType(RoomType.WORKROOM)
                .addAppliance(applianceFactory.createFlameDetector())
                .addAppliance(applianceFactory.createComputer())
                .addAppliance(applianceFactory.createTV())
                .addWindow(new Window(new Blind()));
        log.info("Room Workroom is built.");
    }
}
