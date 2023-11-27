package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.Appliance;

public interface ApplianceFactory {

    Appliance createCircuitBreaker();

    Appliance createFlameDetector();

    Appliance createLeakDetector();

    Appliance createPlaystation();

    Appliance createComputer();

    Appliance createDishwasher();

    Appliance createFridge();

    Appliance createOven();

    Appliance createTV();

    Appliance createWashingMachine();

    Appliance createStove();

    Appliance createKettle();
}
