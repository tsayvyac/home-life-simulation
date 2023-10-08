package cz.cvut.fel.omo.util;

public class Constant {

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
