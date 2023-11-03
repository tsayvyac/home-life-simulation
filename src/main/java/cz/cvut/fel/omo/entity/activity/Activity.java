package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.smarthome.room.Room;

public abstract class Activity {
    protected Room room;
    protected Executor executor;

    public abstract void execute();
}
