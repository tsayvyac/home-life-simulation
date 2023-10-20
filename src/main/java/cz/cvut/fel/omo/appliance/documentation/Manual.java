package cz.cvut.fel.omo.appliance.documentation;

import cz.cvut.fel.omo.appliance.HomeAppliance;
import cz.cvut.fel.omo.util.Constant;

import java.io.IOException;;

public class Manual {
    private HomeAppliance appliance;


    public Manual(HomeAppliance appliance) {
        this.appliance = appliance;
    }

    public void generateManual() throws IOException{
        String applianceName = appliance.getName();
        String applianceType = appliance.getType().toString();
        BrokennessLevel brokennessLevel = appliance.getBrokennessLevel();
        StringBuilder result = new StringBuilder();
        result.append(Constant.MANUAL_HEADER);
        final String message = "Documentation for the device: " + applianceName + " of type: " + applianceType + ".\n";
        switch (brokennessLevel){
            case HARDCORE -> result.append(message).append("The device is broken beyond repair. Throw it away.").append("\n");
            case MEDIUM -> result.append(message).append("The device is broken, but you can fix it. Call your grandfather and he will help you.").append("\n");
            case EASY_TO_FIX -> result.append(message).append("The device is slightly damaged. You will need to fix it for it to work.").append("\n");
        }
        String manualName = applianceName + "_manual";
        System.out.println(result.toString());
        // TODO add file manager
    }

}
