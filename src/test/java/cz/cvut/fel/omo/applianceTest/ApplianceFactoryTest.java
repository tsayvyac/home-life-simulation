package cz.cvut.fel.omo.applianceTest;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.Sensor;
import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.*;

class ApplianceFactoryTest {


    @Test
    void testCreateCircuitBreaker() {
        Sensor circuitBreaker = HomeApplianceFactory.INSTANCE.createCircuitBreaker();
        assertNotNull(circuitBreaker);
        assertEquals(ApplianceType.ELECTRICITY, circuitBreaker.getType());
        assertEquals("Circuit breaker", circuitBreaker.getName());
        assertEquals(SENSOR_IDLE, circuitBreaker.getConsumption());
    }

    @Test
    void testCreateLeakDetector() {
        Sensor leakDetector = HomeApplianceFactory.INSTANCE.createLeakDetector();
        assertNotNull(leakDetector);
        assertEquals(ApplianceType.ELECTRICITY, leakDetector.getType());
        assertEquals("Leak detector", leakDetector.getName());
        assertEquals(SENSOR_IDLE, leakDetector.getConsumption());
    }

    @Test
    void testCreateComputer() {
        Appliance computer = HomeApplianceFactory.INSTANCE.createComputer();
        assertNotNull(computer);
        assertEquals(ApplianceType.ELECTRICITY, computer.getType());
        assertEquals("Computer", computer.getName());
        assertEquals(APPLIANCE_OFF, computer.getConsumption());
    }

    @Test
    void testCreateDishwasher() {
        Appliance dishwasher = HomeApplianceFactory.INSTANCE.createDishwasher();
        assertNotNull(dishwasher);
        assertEquals(ApplianceType.ELECTRICITY, dishwasher.getType());
        assertEquals("Dishwasher", dishwasher.getName());
        assertEquals(APPLIANCE_OFF, dishwasher.getConsumption());
    }

    @Test
    void testCreateFridge() {
        Appliance fridge = HomeApplianceFactory.INSTANCE.createFridge();
        assertNotNull(fridge);
        assertEquals(ApplianceType.ELECTRICITY, fridge.getType());
        assertEquals("Fridge", fridge.getName());
        assertEquals(APPLIANCE_OFF, fridge.getConsumption());
    }

    @Test
    void testCreateOven() {
        Appliance oven = HomeApplianceFactory.INSTANCE.createOven();
        assertNotNull(oven);
        assertEquals(ApplianceType.ELECTRICITY, oven.getType());
        assertEquals("Oven", oven.getName());
        assertEquals(APPLIANCE_OFF, oven.getConsumption());
    }

    @Test
    void testCreateTV() {
        Appliance tv = HomeApplianceFactory.INSTANCE.createTV();
        assertNotNull(tv);
        assertEquals(ApplianceType.ELECTRICITY, tv.getType());
        assertEquals("TV", tv.getName());
        assertEquals(APPLIANCE_OFF, tv.getConsumption());
    }

    @Test
    void testCreateWashingMachine() {
        Appliance washingMachine = HomeApplianceFactory.INSTANCE.createWashingMachine();
        assertNotNull(washingMachine);
        assertEquals(ApplianceType.ELECTRICITY, washingMachine.getType());
        assertEquals("Washing machine", washingMachine.getName());
        assertEquals(APPLIANCE_OFF, washingMachine.getConsumption());
    }

    @Test
    void testCreateStove() {
        Appliance stove = HomeApplianceFactory.INSTANCE.createStove();
        assertNotNull(stove);
        assertEquals(ApplianceType.GAS, stove.getType());
        assertEquals("Stove", stove.getName());
        assertEquals(APPLIANCE_OFF, stove.getConsumption());
    }

    @Test
    void testCreateKettle() {
        Appliance kettle = HomeApplianceFactory.INSTANCE.createKettle();
        assertNotNull(kettle);
        assertEquals(ApplianceType.ELECTRICITY, kettle.getType());
        assertEquals("Kettle", kettle.getName());
        assertEquals(APPLIANCE_OFF, kettle.getConsumption());
    }

}
