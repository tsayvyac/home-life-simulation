package cz.cvut.fel.omo.appliance;

import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.home.Home;

import java.util.List;

public class CircuitBreaker extends Sensor {
    private final List<Appliance> appliances = Home.getInstance().getAllAppliances().stream()
            .filter(appliance -> !(appliance instanceof CircuitBreaker))
            .toList();
    private final List<NullableRoom> rooms = Home.getInstance().getAllRooms();

    public CircuitBreaker(SourceType type, ApplianceType name) {
        super(type, name);
    }

    public void turnOffAll() {
        appliances.forEach(Appliance::turnOff);
        rooms.stream()
                .flatMap(r -> r.getWindows().stream())
                .forEach(window -> {
                    window.close();
                    if (window.getBlind() != null)
                        window.getBlind().close();
                });
    }

    public void toIdleSensors() {
        appliances.stream()
                .filter(Sensor.class::isInstance)
                .forEach(Appliance::idle);
    }
}
