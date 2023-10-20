package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.appliance.Sensor;

public interface ApplianceFactory {

    Sensor createCircuitBreaker();
    Sensor createFlameDetector();
    Sensor createLeakDetector();

    Appliance createComputer();
    Appliance createDishwasher();
    Appliance createFridge();
    Appliance createOven();
    Appliance createTV();
    Appliance createWashingMachine();
    Appliance createStove();
    Appliance createKettle();



}
