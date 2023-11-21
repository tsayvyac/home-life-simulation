package cz.cvut.fel.omo.util;

public class Constant {

    private Constant() {}

    public static final int HOURS_IN_DAY = 24;
    public static final String NULL = "null";
    public static final String PACKAGE_NAME_PERSON = "cz.cvut.fel.omo.event.person";
    public static final String PACKAGE_NAME_APPLIANCE = "cz.cvut.fel.omo.event.appliance";
    public static final String PACKAGE_NAME_PET = "cz.cvut.fel.omo.event.pet";
    public static final String PACKAGE_NAME_EMERGENCY = "cz.cvut.fel.omo.event.emergency";

    public static class ApplianceConstant {

        private ApplianceConstant() {}

        public static final double APPLIANCE_OFF = 0.0f;

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
        public static final double PLAYSTATION_RUNNING = 18.3;

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
        public static final double PLAYSTATION_IDLE = 1.5;

        /**
         * Durability of appliances
         */
        public static final int COMPUTER_DURABILITY = 19;
        public static final int TV_DURABILITY = 16;
        public static final int OVEN_DURABILITY = 17;
        public static final int WASHING_MACHINE_DURABILITY = 11;
        public static final int FRIDGE_DURABILITY = 10;
        public static final int DISHWASHER_DURABILITY = 14;
        public static final int KETTLE_DURABILITY = 20;
        public static final int STOVE_DURABILITY = 21;
        public static final int PLAYSTATION_DURABILITY = 23;
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

        public static final String USER_NUMBER_OF_DAYS = "Enter the number of days for the simulation (>29 && <366):";

        public static final String USER_NUMBER_OF_DAYS_ERR =
                "The number of days must be more than 29 and less than 366!";

        public static final String MANUAL_HEADER = "********************\nMANUAL\n********************\n\n";

        public static final String MANUAL_HARD = "HARD DAMAGE. " +
                "Try to search for a solution on Stack Overflow. " +
                "If nothing is found, try to restart the appliance.";

        public static final String MANUAL_MEDIUM = "MEDIUM DAMAGE. " +
                "You just need to restart the appliance twice. Unplug the plug and plug it back. TWO TIMES!";

        public static final String MANUAL_EASY = "EASY DAMAGE. " +
                "You just need to restart the appliance. Unplug the plug and plug it back.";
    }
}
