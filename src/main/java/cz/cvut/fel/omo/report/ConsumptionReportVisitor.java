package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.appliance.Appliance;
import cz.cvut.fel.omo.appliance.SourceType;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.home.Floor;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.Room;
import cz.cvut.fel.omo.util.FileManager;
import cz.cvut.fel.omo.util.Helper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.CONSUMPTION_REPORT_HEADER;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.GAS_PRICE;
import static cz.cvut.fel.omo.util.Constant.ApplianceConstant.ELECTRICITY_PRICE;
import static cz.cvut.fel.omo.util.Constant.OutputStrings.TRIPLE_TAB;

/**
 * Class that generates consumption report
 */
@Slf4j(topic = "Consumption reporter")
public class ConsumptionReportVisitor implements Visitor {

    /**
     * Total consumption of electricity
     */
    private double totalConsumptionOfElectricity = 0;

    /**
     * Total consumption of gas
     */
    private double totalConsumptionOfGas = 0;

    /**
     *  List of floors in home
     */
    private final List<Floor> floorList = Home.getInstance().getFloorList();

    /**
     * Generate consumption report
     *
     * @throws IOException if file cannot be created
     */
    public void generateReport() throws IOException {
        log.info("Consumption report is being generated...");
        String report = CONSUMPTION_REPORT_HEADER +
                Home.getInstance().accept(this) +
                getTotalStatistic();

        FileManager.generateReport("consumption_report" + LocalDateTime.now().format(FORMATTER), report);
    }

    /**
     * Gets total statistic
     *
     * @return total statistic
     */
    private String getTotalStatistic() {
        return "\n\n::Total consumption:\n" +
                "\tTotal consumption of ELECTRICITY: " +
                Helper.round2Places(this.totalConsumptionOfElectricity) + " kWh." +
                " Price: " + Helper.round2Places(this.totalConsumptionOfElectricity * ELECTRICITY_PRICE) +
                " Kc.\n" +
                "\tTotal consumption of GAS: " +
                Helper.round2Places(this.totalConsumptionOfGas) + " m3." +
                " Price: " + Helper.round2Places(this.totalConsumptionOfGas * GAS_PRICE) +
                " Kc.";
    }

    @Override
    public String visitHome(Home home) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Home:\n");

        for (var floor : home.getFloorList())
            stringBuilder.append(floor.accept(this));

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\t\tRoom ")
                .append(room.getRoomType())
                .append(":\n");

        if (!room.getApplianceList().isEmpty()) {
            for (var appliance : room.getApplianceList())
                stringBuilder.append(appliance.accept(this));
        }

        return stringBuilder.toString();
    }

    @Override
    public String visitExecutor(Executor executor) {
        return null;
    }

    @Override
    public String visitAppliance(Appliance appliance) {
        if (appliance.getSourceType() == SourceType.ELECTRICITY)
            this.totalConsumptionOfElectricity += appliance.getTotalConsumption();
        else
            this.totalConsumptionOfGas += appliance.getTotalConsumption();

        return TRIPLE_TAB + "Appliance " + appliance.getName() +
                " has consumed: " + Helper.round2Places(appliance.getTotalConsumption()) +
                (appliance.getSourceType() == SourceType.ELECTRICITY ? " (kWh)" : " (m3)") + "\n";
    }
}
