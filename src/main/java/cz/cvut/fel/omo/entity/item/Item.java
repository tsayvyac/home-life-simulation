package cz.cvut.fel.omo.entity.item;

import lombok.Getter;

public abstract class Item {
    private boolean isFree = true;
    @Getter private final ItemType type;

    protected Item(ItemType type) {
        this.type = type;
    }

    public void use() {
        this.isFree = false;
    }

    public void setFree() {
        this.isFree = true;
    }

    public boolean getStatus() {
        return this.isFree;
    }
}
