package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.util.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.ACTIVITY_AND_USAGE_HEADER;

/**
 * Class that generates activity and usage report
 */
@Slf4j(topic = "Activity and usage reporter")
public class ActivityAndUsageReporter {

    /**
     * List of all activities
     */
    private static final List<String> ACTIVITIES = new ArrayList<>();

    /**
     * Map of all usages
     */
    private static final Map<KeyWrapper, Integer> USAGE = new HashMap<>();

    /**
     * Formatter for time
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm-ss.SS");

    /**
     * Private constructor for ActivityAndUsageReporter
     */
    private ActivityAndUsageReporter() {
    }

    /**
     * Adds activity to list
     *
     * @param activity activity to add
     */
    public static void add(String activity) {
        ACTIVITIES.add(activity);
    }

    /**
     * Adds usage to map
     *
     * @param keyWrapper keyWrapper to add
     */
    public static void put(KeyWrapper keyWrapper) {
        USAGE.merge(keyWrapper, 1, Integer::sum);
    }

    /**
     * Generates activity and usage report
     *
     * @throws IOException if file cannot be created
     */
    public static void generateActivityAndUsageReport() throws IOException {
        log.info("Activity and usage report is being generated...");
        StringBuilder stringBuilder = generateStatistics();
        for (var activity : ACTIVITIES) {
            stringBuilder.append(activity).append("\n");
        }
        FileManager.generateReport("activity_and_usage_report" + LocalTime.now().format(FORMATTER), stringBuilder.toString());
    }

    /**
     * Generates statistics
     *
     * @return statistics
     */
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

    /**
     * Sorts map ASC by appliance type and role
     *
     * @return sorted map
     */
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
