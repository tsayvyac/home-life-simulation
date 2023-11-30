package cz.cvut.fel.omo.entity.item;

import lombok.Getter;

/**
 * Class representing an item
 */
public abstract class Item {

    /**
     * Boolean representing whether the item is free or not
     */
    private boolean isFree = true;

    /**
     * Type of the item
     */
    @Getter
    private final ItemType type;

    /**
     * Constructor for Item
     *
     * @param type type of the item
     */
    protected Item(ItemType type) {
        this.type = type;
    }

    /**
     * Method for using the item
     * Sets the item to be not free
     */
    public void use() {
        this.isFree = false;
    }

    /**
     * Method for setting the item to be free
     * Sets the item to be free
     */
    public void setFree() {
        this.isFree = true;
    }

    /**
     * Method for getting the status of the item
     *
     * @return true if the item is free, false otherwise
     */
    public boolean getStatus() {
        return this.isFree;
    }
}
