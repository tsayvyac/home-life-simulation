package cz.cvut.fel.omo.applianceTest;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.SourceType;
import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import org.junit.jupiter.api.Test;

import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.APPLIANCE_OFF;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.SENSOR_IDLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplianceFactoryTest {


    @Test
    void testCreateCircuitBreaker() {
        Appliance circuitBreaker = HomeApplianceFactory.INSTANCE.createCircuitBreaker();
        assertNotNull(circuitBreaker);
        assertEquals(SourceType.ELECTRICITY, circuitBreaker.getSourceType());
        assertEquals(ApplianceType.CIRCUIT_BREAKER, circuitBreaker.getName());
    }

    @Test
    void testCreateFlameDetector() {
        Appliance flameDetector = HomeApplianceFactory.INSTANCE.createFlameDetector();
        assertNotNull(flameDetector);
        assertEquals(SourceType.ELECTRICITY, flameDetector.getSourceType());
        assertEquals(ApplianceType.FLAME_DETECTOR, flameDetector.getName());
    }

    @Test
    void testCreateLeakDetector() {
        Appliance leakDetector = HomeApplianceFactory.INSTANCE.createLeakDetector();
        assertNotNull(leakDetector);
        assertEquals(SourceType.ELECTRICITY, leakDetector.getSourceType());
        assertEquals(ApplianceType.LEAK_DETECTOR, leakDetector.getName());
    }

    @Test
    void testCreateComputer() {
        Appliance computer = HomeApplianceFactory.INSTANCE.createComputer();
        assertNotNull(computer);
        assertEquals(SourceType.ELECTRICITY, computer.getSourceType());
        assertEquals(ApplianceType.COMPUTER, computer.getName());
    }

    @Test
    void testCreateDishwasher() {
        Appliance dishwasher = HomeApplianceFactory.INSTANCE.createDishwasher();
        assertNotNull(dishwasher);
        assertEquals(SourceType.ELECTRICITY, dishwasher.getSourceType());
        assertEquals(ApplianceType.DISHWASHER, dishwasher.getName());
    }

    @Test
    void testCreateFridge() {
        Appliance fridge = HomeApplianceFactory.INSTANCE.createFridge();
        assertNotNull(fridge);
        assertEquals(SourceType.ELECTRICITY, fridge.getSourceType());
        assertEquals(ApplianceType.FRIDGE, fridge.getName());
    }

    @Test
    void testCreateOven() {
        Appliance oven = HomeApplianceFactory.INSTANCE.createOven();
        assertNotNull(oven);
        assertEquals(SourceType.ELECTRICITY, oven.getSourceType());
        assertEquals(ApplianceType.OVEN, oven.getName());
    }

    @Test
    void testCreateTV() {
        Appliance tv = HomeApplianceFactory.INSTANCE.createTV();
        assertNotNull(tv);
        assertEquals(SourceType.ELECTRICITY, tv.getSourceType());
        assertEquals(ApplianceType.TV, tv.getName());
    }

    @Test
    void testCreateWashingMachine() {
        Appliance washingMachine = HomeApplianceFactory.INSTANCE.createWashingMachine();
        assertNotNull(washingMachine);
        assertEquals(SourceType.ELECTRICITY, washingMachine.getSourceType());
        assertEquals(ApplianceType.WASHING_MACHINE, washingMachine.getName());
    }

    @Test
    void testCreateStove() {
        Appliance stove = HomeApplianceFactory.INSTANCE.createStove();
        assertNotNull(stove);
        assertEquals(SourceType.GAS, stove.getSourceType());
        assertEquals(ApplianceType.STOVE, stove.getName());
    }

    @Test
    void testCreateKettle() {
        Appliance kettle = HomeApplianceFactory.INSTANCE.createKettle();
        assertNotNull(kettle);
        assertEquals(SourceType.ELECTRICITY, kettle.getSourceType());
        assertEquals(ApplianceType.KETTLE, kettle.getName());
    }

}
