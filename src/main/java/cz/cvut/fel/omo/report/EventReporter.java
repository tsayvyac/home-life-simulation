package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.sensor.FlameDetectorEvent;
import cz.cvut.fel.omo.event.sensor.TemperatureSensorEvent;
import cz.cvut.fel.omo.util.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.EVENT_HEADER;

/**
 * Class that generates event report
 */
@Slf4j(topic = "Event reporter")
public class EventReporter {

    /**
     * List of all events
     */
    private static final List<Event> EVENT_STORAGE = new ArrayList<>();

    /**
     * Formatter for time
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    /**
     * Private constructor for EventReporter
     */
    private EventReporter() {
    }

    /**
     * Adds event to list
     *
     * @param event event to add
     */
    public static void addEvent(Event event) {
        EVENT_STORAGE.add(event);
    }

    /**
     * Generates event report
     *
     * @throws IOException if file cannot be created
     */
    public static void generateEventReport() throws IOException {
        int count = 0;
        log.info("Event report is being generated...");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EVENT_HEADER);
        for (var event : EVENT_STORAGE) {
            stringBuilder
                    .append("[").append(++count).append("] ")
                    .append("Event ").append(event.getName());

            checkEventWithAppliance(event, stringBuilder);

            int activityCount = 0;
            for (var activity : event.getSolveChain()) {
                stringBuilder
                        .append("\t").append(++activityCount).append(". ")
                        .append(activity.getName())
                        .append(" with ticks ").append(activity.getTicksToSolve()).append(";\n");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.insert(13, " Total number of events [" + count + "]:\n\n");
        FileManager.generateReport("event_report" + LocalDateTime.now().format(FORMATTER), stringBuilder.toString());
    }

    /**
     * Checks event with appliance
     *
     * @param event         event to check
     * @param stringBuilder stringBuilder to append
     */
    private static void checkEventWithAppliance(Event event, StringBuilder stringBuilder) {
        if (event.getAppliance() != null) {
            if (!(event instanceof TemperatureSensorEvent) && !(event instanceof FlameDetectorEvent))
                stringBuilder
                        .append(" ").append(event.getAppliance().getName())
                        .append(" ").append("brokenness level is ").append(event.getAppliance().getBrokennessLevel());
            else
                stringBuilder
                        .append(" ").append(event.getAppliance().getName()).append(" is activated.\n");
        }

        if (!(event instanceof TemperatureSensorEvent) && !(event instanceof FlameDetectorEvent))
            stringBuilder
                    .append(" solved by ")
                    .append(event.getExecutorList() == null && event.getExecutor() != null ? event.getExecutor().getRole() : "ALL")
                    .append(" with activities:").append("\n");
    }
}
