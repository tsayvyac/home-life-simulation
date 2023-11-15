package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActivityGenerator {
    private static final Home home = Home.getInstance();

    private ActivityGenerator() {}

    public static void generateRandomActivity() {
        int size = home.getAllExecutors().size();
        Executor executor = null;
        int count = 12;

        do {
            int randExecutorIdx = Helper.getRandomInt(size);
            if (home.getAllExecutors().get(randExecutorIdx).getStatus() == ExecutorStatus.FREE)
                executor = home.getAllExecutors().get(randExecutorIdx);
            if (count-- == 0) break;
        } while (executor == null);

        if (executor != null)
            assignActivity(executor);
    }

    private static void assignActivity(Executor executor) {
        Activity activity;
        do {
            int randIdx = Helper.getRandomInt(Activities.values().length);
            activity = Activities.values()[randIdx].getActivity();
        } while (!executor.getRole().getType().contains(activity.getActivityType()));

        activity.execute(executor);
        log.info("Activity {} is started in {} with {} ticks",
                activity.getName(), executor.getRoom().getRoomType(), activity.getTicksToSolve());
    }
}
