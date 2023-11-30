package cz.cvut.fel.omo.smarthome.room;

import lombok.Getter;

/**
 * Class representing window
 */
@Getter
public class Window {

    /**
     * Is window open
     */
    private boolean isOpen;

    /**
     * Blind on the window
     */
    private Blind blind;

    /**
     * Constructor for window
     *
     * @param blind blind on the window
     */
    Window(Blind blind) {
        this.blind = blind;
    }

    /**
     * Constructor for window
     */
    Window() {
    }

    /**
     * Close window
     * Set isOpen to false
     */
    public void close() {
        this.isOpen = false;
    }

    /**
     * @return true if window is closed, false otherwise
     */
    public boolean hasBlind() {
        return blind != null;
    }

}
