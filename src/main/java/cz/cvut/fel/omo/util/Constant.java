package cz.cvut.fel.omo.util;

public class Constant {

    private Constant() {
    }

    public static final int HOURS_IN_DAY = 24;
    public static final String PACKAGE_NAME_PERSON = "cz.cvut.fel.omo.event.person";
    public static final String PACKAGE_NAME_SENSOR = "cz.cvut.fel.omo.event.sensor";
    public static final String PACKAGE_NAME_PET = "cz.cvut.fel.omo.event.pet";
    public static final String PACKAGE_NAME_EMERGENCY = "cz.cvut.fel.omo.event.emergency";
    public static final String[] FOOD_ON_STOVE = {
            "Goulash with dumplings",
            "Tonkotsu Ramen",
            "Crab cake",
            "Teriyaki chicken",
            "Beef Stroganoff",
            "Chicken masala"
    };
    public static final String[] FOOD_IN_OVEN = {
            "Roasted chicken with potatoes",
            "Pizza peperoni",
            "Apple pie",
            "Cookies",
            "Lasagna"
    };

    public static class ApplianceConstant {

        private ApplianceConstant() {
        }

        /**
         * RUNNING - power consumption (kWh) of device when it is running
         */
        public static final double SENSOR_RUNNING = 1.0;
        public static final double COMPUTER_RUNNING = 19.0;
        public static final double TV_RUNNING = 10.0;
        public static final double OVEN_RUNNING = 12.0;
        public static final double WASHING_MACHINE_RUNNING = 15.0;
        public static final double FRIDGE_RUNNING = 8.0;
        public static final double DISHWASHER_RUNNING = 10.0;
        public static final double KETTLE_RUNNING = 7.0;
        public static final double STOVE_RUNNING = 1.2;
        public static final double PLAYSTATION_RUNNING = 18.3;

        /**
         * IDLE - power consumption (kWh) of device when it is idle
         */
        public static final double SENSOR_IDLE = 0.5;
        public static final double COMPUTER_IDLE = 5.0;
        public static final double TV_IDLE = 2.0;
        public static final double OVEN_IDLE = 2.3;
        public static final double WASHING_MACHINE_IDLE = 1.9;
        public static final double FRIDGE_IDLE = 4.0;
        public static final double DISHWASHER_IDLE = 3.0;
        public static final double KETTLE_IDLE = 1.2;
        public static final double STOVE_IDLE = 0.3;
        public static final double PLAYSTATION_IDLE = 1.5;

        /**
         * Durability of appliances
         */
        public static final int COMPUTER_DURABILITY = 37;
        public static final int TV_DURABILITY = 44;
        public static final int OVEN_DURABILITY = 47;
        public static final int WASHING_MACHINE_DURABILITY = 35;
        public static final int FRIDGE_DURABILITY = 54;
        public static final int DISHWASHER_DURABILITY = 40;
        public static final int KETTLE_DURABILITY = 50;
        public static final int STOVE_DURABILITY = 40;
        public static final int PLAYSTATION_DURABILITY = 45;

        /**
         * Electricity (per kWh) and gas price (per m3)
         */
        public static final double ELECTRICITY_PRICE = 0.12;
        public static final double GAS_PRICE = 6.21;
    }

    public static class OutputStrings {

        private OutputStrings() {
        }

        public static final String USER_CONFIG_CHOICE = """
                Choose a config of simulation:\s
                Big house configuration(T/t)
                Small house configuration(F/f)
                (T/F)?:
                """;

        public static final String USER_CONFIG_CHOICE_ERR =
                "You must enter (T/t) if you want to run the simulation with a large config or otherwise (F/f)";

        public static final String USER_NUMBER_OF_DAYS = "Enter the number of days for the simulation (30 - 365):";

        public static final String USER_NUMBER_OF_DAYS_ERR =
                "The number of days must be more than 29 and less than 366!";

        public static final String USER_DELETE_REPORT =
                "Do you want to delete all previous reports and manuals? (T/F):";

        public static final String USER_DELETE_REPORT_ERR =
                "You must enter (T/t) if you want to delete all previous reports and manuals, (F/f) otherwise.";

        public static final String MANUAL_HEADER = "********************\nMANUAL\n********************\n\n";

        public static final String MANUAL_HARD = "HARD DAMAGE. " +
                "Try to search for a solution on Stack Overflow. " +
                "If nothing is found, try to restart the appliance.";

        public static final String MANUAL_MEDIUM = "MEDIUM DAMAGE. " +
                "You just need to restart the appliance twice. Unplug the plug and plug it back. TWO TIMES!";

        public static final String MANUAL_EASY = "EASY DAMAGE. " +
                "You just need to restart the appliance. Unplug the plug and plug it back.";

        public static final String HOME_CONFIG_HEADER = "HOME CONFIGURATION REPORT\n\n";

        public static final String TRIPLE_TAB = "\t\t\t";

        public static final String STARRING = "\n\nSTARRING:\n";

        public static final String APPLIANCE_QUANTITY = "\n\n\nAPPLIANCE QUANTITY:\n";

        public static final String EVENT_HEADER = "EVENT REPORT.";

        public static final String ACTIVITY_AND_USAGE_HEADER = "ACTIVITY AND USAGE REPORT\n\n";

        public static final String CONSUMPTION_REPORT_HEADER = "CONSUMPTION REPORT\n\n";
    }
}
