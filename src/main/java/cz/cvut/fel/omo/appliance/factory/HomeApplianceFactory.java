package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.*;

public class HomeApplianceFactory implements ApplianceFactory {

    public static final HomeApplianceFactory INSTANCE = new HomeApplianceFactory();

    private HomeApplianceFactory() {
    }

    @Override
    public Appliance createCircuitBreaker() {
        return new CircuitBreaker(SourceType.ELECTRICITY, ApplianceType.CIRCUIT_BREAKER);
    }

    @Override
    public Appliance createFlameDetector() {
        return new FlameDetector(SourceType.ELECTRICITY, ApplianceType.FLAME_DETECTOR);
    }

    @Override
    public Appliance createTemperatureSensor() {
        return new TemperatureSensor(SourceType.ELECTRICITY, ApplianceType.TEMPERATURE_SENSOR);
    }

    @Override
    public Appliance createPlaystation() {
        return new Playstation(SourceType.ELECTRICITY, ApplianceType.PLAYSTATION);
    }

    @Override
    public Appliance createComputer() {
        return new Computer(SourceType.ELECTRICITY, ApplianceType.COMPUTER);
    }

    @Override
    public Appliance createDishwasher() {
        return new Dishwasher(SourceType.ELECTRICITY, ApplianceType.DISHWASHER);
    }

    @Override
    public Appliance createFridge() {
        return new Fridge(SourceType.ELECTRICITY, ApplianceType.FRIDGE);
    }

    @Override
    public Appliance createOven() {
        return new Oven(SourceType.ELECTRICITY, ApplianceType.OVEN);
    }

    @Override
    public Appliance createTV() {
        return new TV(SourceType.ELECTRICITY, ApplianceType.TV);
    }

    @Override
    public Appliance createWashingMachine() {
        return new WashingMachine(SourceType.ELECTRICITY, ApplianceType.WASHING_MACHINE);
    }

    @Override
    public Appliance createStove() {
        return new Stove(SourceType.GAS, ApplianceType.STOVE);
    }

    @Override
    public Appliance createKettle() {
        return new Kettle(SourceType.ELECTRICITY, ApplianceType.KETTLE);
    }
}
