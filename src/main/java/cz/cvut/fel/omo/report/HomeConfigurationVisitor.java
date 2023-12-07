package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.component.Component;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.person.Person;
import cz.cvut.fel.omo.entity.living.pet.Pet;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.util.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

/**
 * Class that generates home configuration report
 */
@Slf4j(topic = "Home configuration report generator")
public class HomeConfigurationVisitor implements Visitor {

    /**
     * Map of all appliances and their quantity
     */
    private final Map<Class<? extends Component>, Integer> quantity = new HashMap<>();

    /**
     * List of floors in home
     */
    private final List<Floor> floorList = Home.getInstance().getFloorList();

    /**
     * Generate home configuration report
     *
     * @throws IOException if file cannot be created
     */
    public void generateReport() throws IOException {
        log.info("Home configuration report is being generated...");
        String report = HOME_CONFIG_HEADER +
                Home.getInstance().accept(this) +
                getApplianceQuantity();

        FileManager.generateReport("home_config_report" + LocalDateTime.now().format(FORMATTER), report);
    }

    /**
     * Gets appliance quantity
     *
     * @return appliance quantity
     */
    private String getApplianceQuantity() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(APPLIANCE_QUANTITY);
        quantity.forEach((key, value) ->
                stringBuilder
                        .append("\tNumber of appliance ")
                        .append(key.getSimpleName())
                        .append(" is ").append(value).append("\n")
        );
        stringBuilder
                .append("::Total number of appliances: ")
                .append(quantity.values().stream().reduce(0, Integer::sum));

        return stringBuilder.toString();
    }

    /**
     * Checks map if map contains component
     * If it does, it increments its value
     *
     * @param component component to check
     */
    private void checkMap(Component component) {
        Integer count = quantity.get(component.getClass());
        if (count == null) count = 1;
        else count++;

        quantity.put(component.getClass(), count);
    }

    @Override
    public String visitHome(Home home) {
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Home:\n");

        for (var floor : home.getFloorList())
            stringBuilder.append(floor.accept(this));

        stringBuilder.append(STARRING);
        for (var executor : home.getAllExecutors()) {
            counter++;
            stringBuilder.append(executor.accept(this));
        }
        stringBuilder.append("::Total number of executors: ").append(counter);

        visitAppliance(home.getTemperatureSensor());
        visitAppliance(home.getCircuitBreaker());

        return stringBuilder.toString();
    }

    @Override
    public String visitFloor(Floor floor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\tFloor ")
                .append(floorList.indexOf(floor))
                .append(":\n");

        for (var room : floor.getRoomList())
            stringBuilder.append(room.accept(this));

        return stringBuilder.toString();
    }

    @Override
    public String visitRoom(Room room) {
        AtomicInteger counter = new AtomicInteger();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\t\tRoom ")
                .append(room.getRoomType())
                .append(":\n");

        if (!room.getWindows().isEmpty()) {
            for (var window : room.getWindows())
                stringBuilder
                        .append(TRIPLE_TAB)
                        .append(counter.incrementAndGet())
                        .append(". window ")
                        .append(window.hasBlind() ? "has blinds\n" : "has NO blinds\n");
        }

        if (!room.getItemList().isEmpty()) {
            for (var item : room.getItemList())
                stringBuilder
                        .append(TRIPLE_TAB)
                        .append("Item ")
                        .append(item.getType())
                        .append("\n");
        }

        if (!room.getApplianceList().isEmpty()) {
            for (var appliance : room.getApplianceList())
                stringBuilder.append(appliance.accept(this));
        }

        return stringBuilder.toString();
    }

    @Override
    public String visitExecutor(Executor executor) {
        String personOrPet = (executor instanceof Person) ? "\tPerson " : "\tPet ";
        return personOrPet + executor.getRole() + " with name " +
                ((executor instanceof Person person) ? person.getName() : ((Pet) executor).getName()) + "\n";
    }

    @Override
    public String visitAppliance(Appliance appliance) {
        checkMap(appliance);

        return TRIPLE_TAB + "Appliance " + appliance.getName() + "\n";
    }
}
