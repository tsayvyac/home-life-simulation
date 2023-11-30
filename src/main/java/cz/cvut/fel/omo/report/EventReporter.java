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

@Slf4j(topic = "Event reporter")
public class EventReporter {
    private static final List<Event> EVENT_STORAGE = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    private EventReporter() {
    }

    public static void addEvent(Event event) {
        EVENT_STORAGE.add(event);
    }

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
