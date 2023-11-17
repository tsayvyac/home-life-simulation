package cz.cvut.fel.omo.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_APPLIANCE;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PERSON;
import static cz.cvut.fel.omo.util.Constant.PACKAGE_NAME_PET;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventLoaderTest {

    @Test
    @DisplayName("Event loader test")
    void eventLoaderTest() {
        List<Class<? extends Event>> events = Stream.of(
                        EventLoader.loadEventsFromPackage(PACKAGE_NAME_APPLIANCE),
                        EventLoader.loadEventsFromPackage(PACKAGE_NAME_PERSON),
                        EventLoader.loadEventsFromPackage(PACKAGE_NAME_PET))
                .flatMap(Collection::stream)
                .toList();

        int actualNumberOfEvents = 6;

        assertEquals(actualNumberOfEvents, events.size());
    }

}
