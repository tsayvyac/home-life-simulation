package cz.cvut.fel.omo.smarthome.room;

/**
 * Class representing blind
 */
public class Blind {

    /**
     * Is blind open
     */
    private boolean isOpen;

    /**
     * Constructor for blind
     */
    Blind() {
    }

    /**
     * Open blind
     * Set isOpen to true
     */
    public void open() {
        this.isOpen = true;
    }

    /**
     * Close blind
     * Set isOpen to false
     */
    public void close() {
        this.isOpen = false;
    }

    /**
     * Is blind open
     *
     * @return true if blind is open, false otherwise
     */
    public boolean isClosed() {
        return !isOpen;
    }
}
