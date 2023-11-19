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

class UseSmallConfigTest {
    private static Home home;

    @BeforeAll
    static void setup() {
        InputStream stdin = System.in;
        boolean useBigConfig = false;
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
        int expectedSizeOfRoomListOnTheSecondFloor = 3;

        assertEquals(expectedSizeOfFloorList, home.getFloorList().size());
        assertEquals(expectedSizeOfRoomListOnTheSecondFloor, home.getFloorList().get(1).getRoomList().size());
    }

    @Test
    @DisplayName("Headcount testing")
    void headcountTest() {
        int expectedHeads = 9;

        int allHeadsInHomeObject = home.getAllExecutors().size();

        assertEquals(expectedHeads, allHeadsInHomeObject);
    }
}
