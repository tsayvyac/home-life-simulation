package cz.cvut.fel.omo.appliance;

/**
 * Class representing flame detector
 */
public class FlameDetector extends Sensor {

    /**
     * Constructor for flame detector
     *
     * @param type source type
     * @param name appliance type
     */
    public FlameDetector(SourceType type, ApplianceType name) {
        super(type, name);
    }
}
