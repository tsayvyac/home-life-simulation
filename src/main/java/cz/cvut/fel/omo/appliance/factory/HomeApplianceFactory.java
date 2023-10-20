package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.*;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.APPLIANCE_OFF;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_IDLE;

public class HomeApplianceFactory implements ApplianceFactory {

    public static final HomeApplianceFactory INSTANCE = new HomeApplianceFactory();

    private HomeApplianceFactory() {
    }

    @Override
    public Sensor createCircuitBreaker() {
        return new CircuitBreaker(ApplianceType.ELECTRICITY, "Circuit breaker", SENSOR_IDLE, null);
    }

    @Override
    public Sensor createFlameDetector() {
        return new FlameDetector(ApplianceType.ELECTRICITY, "Flame detector", SENSOR_IDLE, null);
    }

    @Override
    public Sensor createLeakDetector() {
        return new LeakDetector(ApplianceType.ELECTRICITY, "Leak detector", SENSOR_IDLE, null);
    }

    @Override
    public Appliance createPlaystation() {
        return new Playstation(ApplianceType.ELECTRICITY, "Playstation 5", APPLIANCE_OFF, null);
    }

    @Override
    public Appliance createComputer() {
        return new Computer(ApplianceType.ELECTRICITY, "Computer", APPLIANCE_OFF, null);
    }

    @Override
    public Appliance createDishwasher() {
        return new Dishwasher(ApplianceType.ELECTRICITY, "Dishwasher", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createFridge() {
        return new Fridge(ApplianceType.ELECTRICITY, "Fridge", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createOven() {
        return new Oven(ApplianceType.ELECTRICITY, "Oven", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createTV() {
        return new TV(ApplianceType.ELECTRICITY, "TV", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createWashingMachine() {
        return new WashingMachine(ApplianceType.ELECTRICITY, "Washing machine", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createStove() {
        return new Stove(ApplianceType.GAS, "Stove", APPLIANCE_OFF, null);
    }

    @Override
    public HomeAppliance createKettle() {
        return new Kettle(ApplianceType.ELECTRICITY, "Kettle", APPLIANCE_OFF, null);
    }
}
