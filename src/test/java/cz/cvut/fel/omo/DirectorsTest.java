package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder;
import cz.cvut.fel.omo.smarthome.room.StandardRoomBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectorsTest {
    private static Home home;

    @BeforeAll
    static void setup() {
        InputStream stdin = System.in;
        boolean useBigConfig = true;
        System.setIn(new ByteArrayInputStream("365".getBytes()));

        new SimulationFacade(
                StandardHomeBuilder.INSTANCE,
                StandardRoomBuilder.INSTANCE,
                HomeApplianceFactory.INSTANCE
        ).simulate(useBigConfig);
        home = Home.getInstance();
        System.setIn(stdin);
    }

    @Test
    @DisplayName("Testing creation of the house")
    void creationTest() {
        int expectedSizeOfFloorList = 2;
        int expectedSizeOfRoomListOnTheSecondFloor = 4;

        assertEquals(expectedSizeOfFloorList, home.getFloorList().size());
        assertEquals(expectedSizeOfRoomListOnTheSecondFloor, home.getFloorList().get(1).getRoomList().size());
    }

    @Test
    @DisplayName("Headcount testing")
    void headcountTest() {
        int expectedHeads = 9;

        int actualHeads = home.getFloorList().stream()
                .flatMap(floor -> floor.getRoomList().stream())
                .flatMap(room -> room.getExecutorList().stream())
                .map(executor -> 1) // Count each executor as integer that equals to 1
                .reduce(0, Integer::sum);

        assertEquals(expectedHeads, actualHeads);
    }
}
