package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.exception.EventErrorException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "Event Loader")
class EventLoader {

    private EventLoader() {}

    public static List<Class<? extends Event>> loadEventsFromPackage(String packageName) {
        InputStream classStream = ClassLoader
                .getSystemClassLoader()
                .getResourceAsStream(packageName.replace(".", "/"));

        if (classStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(classStream));
            return reader.lines()
                    .filter(line -> line.endsWith(".class"))
                    .map(line -> getClass(line, packageName))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    private static Class<? extends Event> getClass(String className, String packageName) {
        try {
            Class<?> clazz = Class.forName(
                    packageName + "." + className.substring(0, className.lastIndexOf('.')));
            return clazz.asSubclass(Event.class);
        } catch (Exception e) {
            throw new EventErrorException("Error in event cast. Please check event you want to add!");
        }
    }
}
