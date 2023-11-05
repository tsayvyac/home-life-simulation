package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActivityGenerator {
    private static final Activity[] ACTIVITIES = {
            // Insert all activities here
    };
    private static final Home home = Home.getInstance();
    private static int i = 0;

    private ActivityGenerator() {}

    public static void generateRandomActivity() {
        log.info("Random activity {} was generated!", ++i);
    }
}
