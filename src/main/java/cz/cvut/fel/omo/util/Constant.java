package cz.cvut.fel.omo.util;

public class Constant {

    public static final int HOURS_IN_DAY = 24;


    /**
     * RUNNING - consumption of device when it is running
     */
    public static final double SENSOR_RUNNING = 1.0;
    public static final double COMPUTER_RUNNING = 19.0;
    public static final double TV_RUNNING = 10.0;
    public static final double OVEN_RUNNING = 12.0;
    public static final double WASHING_MACHINE_RUNNING = 15.0;
    public static final double FRIDGE_RUNNING = 8.0;
    public static final double DISHWASHER_RUNNING = 10.0;
    public static final double KETTLE_RUNNING = 7.0;
    public static final double STOVE_RUNNING = 20.0;

    /**
     * IDLE - consumption of device when it is idle
     */

    public static final double SENSOR_IDLE = 0.5;
    public static final double COMPUTER_IDLE = 5.0;
    public static final double TV_IDLE = 2.0;
    public static final double OVEN_IDLE = 2.3;
    public static final double WASHING_MACHINE_IDLE = 1.9;
    public static final double FRIDGE_IDLE = 4.0;
    public static final double DISHWASHER_IDLE = 3.0;
    public static final double KETTLE_IDLE = 1.2;
    public static final double STOVE_IDLE = 1.0;

    /**
     * Headers
     */
    public static final String MANUAL_HEADER = "********************\nMANUAL\n********************\n\n";


    private Constant() {}

    public static class ApplianceConstant {

        private ApplianceConstant() {}

        public static final double WASHING_E_CONSUMPTION = 10;
        public static final double WASHING_W_CONSUMPTION = 20;
    }

    public static class OutputStrings {

        private OutputStrings() {}

        public static final String USER_CONFIG_CHOICE = """
                Choose a config of simulation:\s
                Big house configuration(T/t)
                Small house configuration(F/f)
                (T/F)?:
                """;

        public static final String USER_CONFIG_CHOICE_ERR =
                "You must enter (T/t) if you want to run the simulation with a large config or otherwise (F/f)";

        public static final String USER_NUMBER_OF_DAYS = "Enter the number of days for the simulation (>6 && <1000):";

        public static final String USER_NUMBER_OF_DAYS_ERR =
                "The number of days must be more than 6 and not more than 1000!";
    }
}
