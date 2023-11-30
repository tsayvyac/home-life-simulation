package cz.cvut.fel.omo.appliance.manual;

import cz.cvut.fel.omo.appliance.ApplianceType;
import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.util.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static cz.cvut.fel.omo.util.Constant.OutputStrings.*;

/**
 * Class representing manual for appliance.
 * It is generated based on appliance type and brokenness level.
 */
@Slf4j
public class Manual {

    /**
     * Appliance for which the manual is generated.
     */
    private final HomeAppliance appliance;

    /**
     * Constructor for manual.
     *
     * @param appliance appliance for which the manual is generated
     */
    public Manual(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    /**
     * Generates manual for appliance.
     * It is generated based on appliance type and brokenness level.
     */
    public void generateManual() {
        ApplianceType applianceName = appliance.getName();
        String applianceType = appliance.getSourceType().toString();
        BrokennessLevel brokennessLevel = appliance.getBrokennessLevel();
        final String message = "Repair manual for appliance: " + applianceName + " of type: " + applianceType + ".\n";

        String result = constructResultString(message, brokennessLevel);
        String manualName = applianceName + "_manual_" + appliance.getBrokennessLevel();
        try {
            FileManager.generateManual(manualName, result);
        } catch (IOException e) {
            log.error("Error while generating manual for appliance: {}", applianceName);
        }
    }

    /**
     * Constructs result string for manual.
     *
     * @param message         message to be displayed in manual
     * @param brokennessLevel brokenness level of appliance
     * @return result string for manual
     */
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
