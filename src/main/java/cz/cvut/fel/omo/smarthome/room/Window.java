package cz.cvut.fel.omo.smarthome.room;

import lombok.Getter;

@Getter
public class Window {
    private boolean isOpen;
    private Blind blind;

    Window(Blind blind) {
        this.blind = blind;
    }

    Window() {}

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public boolean hasBlind() {
        return blind != null;
    }

    public boolean isClosed() {
        return !isOpen;
    }
}
