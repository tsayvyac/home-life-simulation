package cz.cvut.fel.omo.entity.item;

import cz.cvut.fel.omo.entity.living.Executable;
import lombok.Getter;

public abstract class Item implements Executable {
    private boolean isFree = true;
    @Getter
    private final ItemType type;

    protected Item(ItemType type) {
        this.type = type;
    }

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
