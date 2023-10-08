package cz.cvut.fel.omo;

import cz.cvut.fel.omo.io.UserInput;

public class Main {

    public static void main(String[] args) {
        SimulationFacade.INSTANCE.simulate(UserInput.getConfiguration());
    }
}
