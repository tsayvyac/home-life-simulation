package cz.cvut.fel.omo.smarthome.room;

public class Blind {
    private boolean isOpen;

    Blind() {
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public boolean isClosed() {
        return !isOpen;
    }
}
