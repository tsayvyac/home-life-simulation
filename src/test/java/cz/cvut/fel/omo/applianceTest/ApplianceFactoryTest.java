package cz.cvut.fel.omo.applianceTest;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.appliance.Sensor;
import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApplianceFactoryTest {

    @Test
    public void testCreateCircuitBreaker() {
        Sensor circuitBreaker = HomeApplianceFactory.INSTANCE.createCircuitBreaker();
        assertNotNull(circuitBreaker);
        assertEquals(ApplianceType.ELECTRICITY, circuitBreaker.getType());
        assertEquals("Circuit breaker", circuitBreaker.getName());
        assertEquals(2, circuitBreaker.getConsumption());
    }


    @Test
    public void testCreateLeakDetector() {
        Sensor leakDetector = HomeApplianceFactory.INSTANCE.createLeakDetector();
        assertNotNull(leakDetector);
        assertEquals(ApplianceType.ELECTRICITY, leakDetector.getType());
        assertEquals("Leak detector", leakDetector.getName());
        assertEquals(2, leakDetector.getConsumption());
    }

    @Test
    public void testCreateComputer() {
        Appliance computer = HomeApplianceFactory.INSTANCE.createComputer();
        assertNotNull(computer);
        assertEquals(ApplianceType.ELECTRICITY, computer.getType());
        assertEquals("Computer", computer.getName());
        assertEquals(15.0, computer.getConsumption());
    }

    @Test
    public void testCreateDishwasher() {
        Appliance dishwasher = HomeApplianceFactory.INSTANCE.createDishwasher();
        assertNotNull(dishwasher);
        assertEquals(ApplianceType.ELECTRICITY, dishwasher.getType());
        assertEquals("Dishwasher", dishwasher.getName());
        assertEquals(50.0, dishwasher.getConsumption());
    }

    @Test
    public void testCreateFridge() {
        Appliance fridge = HomeApplianceFactory.INSTANCE.createFridge();
        assertNotNull(fridge);
        assertEquals(ApplianceType.ELECTRICITY, fridge.getType());
        assertEquals("Fridge", fridge.getName());
        assertEquals(100.0, fridge.getConsumption());
    }

    @Test
    public void testCreateOven() {
        Appliance oven = HomeApplianceFactory.INSTANCE.createOven();
        assertNotNull(oven);
        assertEquals(ApplianceType.ELECTRICITY, oven.getType());
        assertEquals("Oven", oven.getName());
        assertEquals(200.0, oven.getConsumption());
    }

    @Test
    public void testCreateTV() {
        Appliance tv = HomeApplianceFactory.INSTANCE.createTV();
        assertNotNull(tv);
        assertEquals(ApplianceType.ELECTRICITY, tv.getType());
        assertEquals("TV", tv.getName());
        assertEquals(50.0, tv.getConsumption());
    }

    @Test
    public void testCreateWashingMachine() {
        Appliance washingMachine = HomeApplianceFactory.INSTANCE.createWashingMachine();
        assertNotNull(washingMachine);
        assertEquals(ApplianceType.ELECTRICITY, washingMachine.getType());
        assertEquals("Washing machine", washingMachine.getName());
        assertEquals(100.0, washingMachine.getConsumption());
    }

    @Test
    public void testCreateStove() {
        Appliance stove = HomeApplianceFactory.INSTANCE.createStove();
        assertNotNull(stove);
        assertEquals(ApplianceType.GAS, stove.getType());
        assertEquals("Stove", stove.getName());
        assertEquals(100.0, stove.getConsumption());
    }

    @Test
    public void testCreateKettle() {
        Appliance kettle = HomeApplianceFactory.INSTANCE.createKettle();
        assertNotNull(kettle);
        assertEquals(ApplianceType.ELECTRICITY, kettle.getType());
        assertEquals("Kettle", kettle.getName());
        assertEquals(10.0, kettle.getConsumption());
    }

}
