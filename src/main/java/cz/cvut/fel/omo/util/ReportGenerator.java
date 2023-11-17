package cz.cvut.fel.omo.util;

import cz.cvut.fel.omo.smarthome.home.Home;
import lombok.extern.slf4j.Slf4j;

import static cz.cvut.fel.omo.util.Constant.NULL;

@Slf4j(topic = "Event Report Generator")
public class ReportGenerator {
    private final Home home = Home.getInstance();

    public void generate() {
        log.info("--------------------------------------------------------------------------------------------" +
                "----------------------------------------------");
        home.getEvents().stream()
                .filter(event -> !event.getName().equals(NULL))
                .forEach(event -> {
                    log.info("Event {}:", event.getName());
                    event.getSolveChain().forEach(
                            activity -> log.info("\t{} is added to {} activity queue.",
                                    activity.getName(), event.getExecutor().getRole())
                    );
                });
    }
}
