package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.util.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.ACTIVITY_AND_USAGE_HEADER;

@Slf4j(topic = "Activity and usage reporter")
public class ActivityAndUsageReporter {
    private static final List<String> ACTIVITIES = new ArrayList<>();
    private static final Map<KeyWrapper, Integer> USAGE = new HashMap<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    private ActivityAndUsageReporter() {
    }

    public static void add(String activity) {
        ACTIVITIES.add(activity);
    }

    public static void put(KeyWrapper keyWrapper) {
        USAGE.merge(keyWrapper, 1, Integer::sum);
    }

    public static void generateActivityAndUsageReport() throws IOException {
        log.info("Activity and usage report is being generated...");
        StringBuilder stringBuilder = generateStatistics();
        for (var activity : ACTIVITIES) {
            stringBuilder.append(activity).append("\n");
        }
        FileManager.generateReport("activity_and_usage_report" + LocalTime.now().format(FORMATTER), stringBuilder.toString());
    }

    private static StringBuilder generateStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ACTIVITY_AND_USAGE_HEADER);
        stringBuilder.append("STATISTICS:\n");
        sortMap().forEach((key, value) ->
            stringBuilder.append("\t").append(key.applianceType())
                    .append(" was used by ").append(key.role())
                    .append(" ").append(value).append(" times.\n")
        );
        return stringBuilder.append("\n\n");
    }

    private static Map<KeyWrapper, Integer> sortMap() {
        return USAGE.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(KeyWrapper::applianceType).thenComparing(KeyWrapper::role)))
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );
    }
}
