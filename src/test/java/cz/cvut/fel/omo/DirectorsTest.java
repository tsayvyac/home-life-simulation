package cz.cvut.fel.omo;

import cz.cvut.fel.omo.smarthome.home.Home;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectorsTest {

    @Test
    @DisplayName("Testing creation of the house")
    void creationTest() {
        SimulationFacade.INSTANCE.simulate(true);
        Home home = Home.getInstance();

        int expectedSizeOfFloorList = 2;
        int expectedSizeOfRoomListOnTheSecondFloor = 4;

        Assertions.assertEquals(expectedSizeOfFloorList, home.getFloorList().size());
        Assertions.assertEquals(expectedSizeOfRoomListOnTheSecondFloor, home.getFloorList().get(1).getRoomList().size());
    }
}
