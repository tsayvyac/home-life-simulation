package cz.cvut.fel.omo.entity.item;

import cz.cvut.fel.omo.entity.living.Executable;

public abstract class Item implements Executable {
    private boolean isFree = true;

    protected Item() {}

    public void use() {
        this.isFree = false;
        // TODO: Logic...
    }

    public void setFree() {
        this.isFree = true;
    }

    public boolean getStatus() {
        return this.isFree;
    }
}
