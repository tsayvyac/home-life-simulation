package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.Home;

import java.util.List;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor(SourceType type, ApplianceType name) {
        super(type, name);
    }

    public void closeOfOpenWindows(boolean isCold) {
        List<NullableRoom> rooms = Home.getInstance().getAllRooms();
        if (isCold) {
            rooms.stream()
                    .flatMap(r -> r.getWindows().stream())
                    .forEach(window -> {
                        window.close();
                        if (window.getBlind() != null)
                            window.getBlind().close();
                    });
        } else {
            rooms.stream()
                    .flatMap(r -> r.getWindows().stream())
                    .forEach(window -> {
                        window.close();
                        if (window.getBlind() != null)
                            window.getBlind().open();
                    });
        }
    }
}
