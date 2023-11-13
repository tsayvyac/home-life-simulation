package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.activity.marker.AdultActivity;
import cz.cvut.fel.omo.entity.activity.marker.PersonActivity;
import cz.cvut.fel.omo.entity.activity.marker.KidActivity;
import cz.cvut.fel.omo.entity.activity.marker.PetActivity;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActivityGenerator {
    private static final Home home = Home.getInstance();

    private ActivityGenerator() {}

    public static void generateRandomActivity() {
        int size = home.getAllExecutors().size();
        int randIdx = Helper.getRandomInt(Activities.list.length);
        Activity activity = Activities.list[randIdx];
        if (activity instanceof AdultActivity) {
            log.info("Adult activity");
        } else if (activity instanceof KidActivity) {
            log.info("Kid activity");
        } else if (activity instanceof PetActivity) {
            log.info("Pet activity");
        } else if (activity instanceof PersonActivity) {
            log.info("All activity");
        }
    }
}
