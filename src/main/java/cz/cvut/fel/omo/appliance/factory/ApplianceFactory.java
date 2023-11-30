package cz.cvut.fel.omo.appliance.factory;

import cz.cvut.fel.omo.appliance.Appliance;

/**
 * Interface for appliance factory
 */
public interface ApplianceFactory {

    /**
     * Creates circuit breaker
     *
     * @return circuit breaker
     */
    Appliance createCircuitBreaker();

    /**
     * Creates flame detector
     *
     * @return flame detector
     */
    Appliance createFlameDetector();

    /**
     * Creates temperature sensor
     *
     * @return temperature sensor
     */
    Appliance createTemperatureSensor();

    /**
     * Creates playstation
     *
     * @return playstation
     */
    Appliance createPlaystation();

    /**
     * Creates computer
     *
     * @return computer
     */
    Appliance createComputer();

    /**
     * Creates dishwasher
     *
     * @return dishwasher
     */
    Appliance createDishwasher();

    /**
     * Creates fridge
     *
     * @return fridge
     */
    Appliance createFridge();

    /**
     * Creates oven
     *
     * @return oven
     */
    Appliance createOven();

    /**
     * Creates TV
     *
     * @return TV
     */
    Appliance createTV();

    /**
     * Creates washing machine
     *
     * @return washing machine
     */
    Appliance createWashingMachine();

    /**
     * Creates stove
     *
     * @return stove
     */
    Appliance createStove();

    /**
     * Creates kettle
     *
     * @return kettle
     */
    Appliance createKettle();
}
