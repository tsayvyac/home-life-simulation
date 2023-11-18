package cz.cvut.fel.omo.applianceTest;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.appliance.Sensor;
import cz.cvut.fel.omo.appliance.factory.HomeApplianceFactory;
import cz.cvut.fel.omo.appliance.state.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateTest {

    @Test
    void testApplianceSwitching() {
        Appliance fridge = HomeApplianceFactory.INSTANCE.createFridge();
        HomeAppliance mock = (HomeAppliance) HomeApplianceFactory.INSTANCE.createComputer();

        // Initial State
        State actualState = fridge.getState();
        State expectedState = new StateOff(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State On
        fridge.getState().switchOn();
        actualState = fridge.getState();
        expectedState = new StateOn(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Idle
        fridge.getState().switchIdle();
        actualState = fridge.getState();
        expectedState = new StateIdle(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Off
        fridge.getState().switchOff();
        actualState = fridge.getState();
        expectedState = new StateOff(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Broken
        fridge.getState().breakThis();
        actualState = fridge.getState();
        expectedState = new StateBroken(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // Switch after brake
        fridge.getState().switchOn();
        actualState = fridge.getState();

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());
    }

    @Test
    void testSensorSwitching() {
        Appliance flameDetector = HomeApplianceFactory.INSTANCE.createFlameDetector();
        Sensor mock = (Sensor) HomeApplianceFactory.INSTANCE.createLeakDetector();

        // Initial State
        State actualState = flameDetector.getState();
        State expectedState = new StateIdle(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State On
        flameDetector.getState().switchOn();
        actualState = flameDetector.getState();
        expectedState = new StateOn(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Idle
        flameDetector.getState().switchIdle();
        actualState = flameDetector.getState();
        expectedState = new StateIdle(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Off
        flameDetector.getState().switchOff();
        actualState = flameDetector.getState();
        expectedState = new StateOff(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // State Broken
        flameDetector.getState().breakThis();
        actualState = flameDetector.getState();
        expectedState = new StateBroken(mock);

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());

        // Switch after brake
        flameDetector.getState().switchOn();
        actualState = flameDetector.getState();

        assertEquals(actualState.getClass().getSimpleName(), expectedState.getClass().getSimpleName());
    }
}
