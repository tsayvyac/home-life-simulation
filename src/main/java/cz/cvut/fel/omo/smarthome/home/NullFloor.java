package cz.cvut.fel.omo.smarthome.home;

import cz.cvut.fel.omo.nullable.Nullable;

public class NullFloor implements Nullable {

    @Override
    public boolean isNull() {
        return true;
    }
}
