package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.*;
import cz.cvut.fel.omo.util.Constant;

public class HomeApplianceFactory implements ApplianceFactory{

    public static final HomeApplianceFactory INSTANCE = new HomeApplianceFactory();

    private HomeApplianceFactory() {
    }

    @Override
    public Sensor createCircuitBreaker() {
        return new CircuitBreaker(ApplianceType.ELECTRICITY, "Circuit breaker", Constant.SENSOR_RUNNING, null);
    }

    @Override
    public Sensor createFlameDetector() {
        return new FlameDetector(ApplianceType.ELECTRICITY, "Flame detector", Constant.SENSOR_RUNNING, null);
    }

    @Override
    public Sensor createLeakDetector() {
        return new LeakDetector(ApplianceType.ELECTRICITY, "Leak detector", Constant.SENSOR_RUNNING, null);
    }

    @Override
    public Appliance createComputer() {
        return new Computer(ApplianceType.ELECTRICITY, "Computer", Constant.COMPUTER_RUNNING, null);
    }

    @Override
    public Appliance createDishwasher() {
        return new Dishwasher(ApplianceType.ELECTRICITY, "Dishwasher", Constant.DISHWASHER_RUNNING, null);
    }

    @Override
    public HomeAppliance createFridge() {
        return new Fridge(ApplianceType.ELECTRICITY, "Fridge", Constant.FRIDGE_RUNNING, null);
    }

    @Override
    public HomeAppliance createOven() {
        return new Oven(ApplianceType.ELECTRICITY, "Oven", Constant.OVEN_RUNNING, null);
    }

    @Override
    public HomeAppliance createTV() {
        return new TV(ApplianceType.ELECTRICITY, "TV", Constant.TV_RUNNING, null);
    }

    @Override
    public HomeAppliance createWashingMachine() {
        return new WashingMachine(ApplianceType.ELECTRICITY, "Washing machine", Constant.WASHING_MACHINE_RUNNING, null);
    }

    @Override
    public HomeAppliance createStove() {
        return new Stove(ApplianceType.GAS, "Stove", Constant.STOVE_RUNNING, null);
    }

    @Override
    public HomeAppliance createKettle() {
        return new Kettle(ApplianceType.ELECTRICITY, "Kettle", Constant.KETTLE_RUNNING, null);
    }
}
