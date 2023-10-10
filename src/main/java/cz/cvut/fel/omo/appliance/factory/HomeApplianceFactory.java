package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.*;

public class HomeApplianceFactory implements ApplianceFactory{

    public static final HomeApplianceFactory INSTANCE = new HomeApplianceFactory();

    private HomeApplianceFactory() {
    }

    @Override
    public Sensor createCircuitBreaker() {
        return new CircuitBreaker(ApplianceType.ELECTRICITY, "Circuit breaker", 2, null);
    }

    @Override
    public Sensor createFlameDetector() {
        return new FlameDetector(ApplianceType.ELECTRICITY, "Flame detector", 2, null);
    }

    @Override
    public Sensor createLeakDetector() {
        return new LeakDetector(ApplianceType.ELECTRICITY, "Leak detector", 2, null);
    }

    @Override
    public Appliance createComputer() {
        return new Computer(ApplianceType.ELECTRICITY, "Computer", 15.0, null);
    }

    @Override
    public Appliance createDishwasher() {
        return new Dishwasher(ApplianceType.ELECTRICITY, "Dishwasher", 50.0, null);
    }

    @Override
    public HomeAppliance createFridge() {
        return new Fridge(ApplianceType.ELECTRICITY, "Fridge", 100.0, null);
    }

    @Override
    public HomeAppliance createOven() {
        return new Oven(ApplianceType.ELECTRICITY, "Oven", 200.0, null);
    }

    @Override
    public HomeAppliance createTV() {
        return new TV(ApplianceType.ELECTRICITY, "TV", 50.0, null);
    }

    @Override
    public HomeAppliance createWashingMachine() {
        return new WashingMachine(ApplianceType.ELECTRICITY, "Washing machine", 100.0, null);
    }

    @Override
    public HomeAppliance createStove() {
        return new Stove(ApplianceType.GAS, "Stove", 100.0, null);
    }

    @Override
    public HomeAppliance createKettle() {
        return new Kettle(ApplianceType.ELECTRICITY, "Kettle", 10.0, null);
    }
}
