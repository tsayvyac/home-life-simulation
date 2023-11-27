package cz.cvut.fel.omo.appliance.manual;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.HomeAppliance;
import lombok.extern.slf4j.Slf4j;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

@Slf4j
public class Manual {
    private final HomeAppliance appliance;

    public Manual(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    public void generateManual() {
        ApplianceType applianceName = appliance.getName();
        String applianceType = appliance.getSourceType().toString();
        BrokennessLevel brokennessLevel = appliance.getBrokennessLevel();
        final String message = "Documentation for the device: " + applianceName + " of type: " + applianceType + ".\n";

        String result = constructResultString(message, brokennessLevel);
        String manualName = applianceName + "_manual_" + appliance.getBrokennessLevel();
        log.info(result);
//        try {
//            FileManager.generateManual(manualName, result);
//        } catch (IOException e) {
//            log.error("Error while generating manual for appliance: {}", applianceName);
//        }
    }

    private String constructResultString(String message, BrokennessLevel brokennessLevel) {
        StringBuilder result = new StringBuilder();
        result.append(MANUAL_HEADER);

        switch (brokennessLevel) {
            case HARD -> result
                    .append(message)
                    .append(MANUAL_HARD)
                    .append("\n");
            case MEDIUM -> result
                    .append(message)
                    .append(MANUAL_MEDIUM)
                    .append("\n");
            case EASY -> result
                    .append(message)
                    .append(MANUAL_EASY)
                    .append("\n");
        }
        return result.toString();
    }
}
