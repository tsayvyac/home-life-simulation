package cz.cvut.fel.omo;

import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.home.StandardHomeBuilder;
import cz.cvut.fel.omo.smarthome.room.StandardRoomBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DirectorsTest {

    @Test
    @DisplayName("Testing creation of the house")
    void creationTest() {
        InputStream stdin = System.in;
        boolean useBigConfig = true;
        System.setIn(new ByteArrayInputStream("365".getBytes()));

        new SimulationFacade(
                StandardHomeBuilder.INSTANCE,
                StandardRoomBuilder.INSTANCE,
                HomeApplianceFactory.INSTANCE
        ).simulate(useBigConfig);
        Home home = Home.getInstance();

        int expectedSizeOfFloorList = 2;
        int expectedSizeOfRoomListOnTheSecondFloor = 4;
        System.setIn(stdin);

        Assertions.assertEquals(expectedSizeOfFloorList, home.getFloorList().size());
        Assertions.assertEquals(expectedSizeOfRoomListOnTheSecondFloor, home.getFloorList().get(1).getRoomList().size());
    }
}
