package cz.cvut.fel.omo.entity.living;

import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.nullable.NullableRoom;
import cz.cvut.fel.omo.smarthome.room.NullRoom;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@Setter
public abstract class Executor {
    private NullableRoom room = new NullRoom();
    private ExecutorStatus status = ExecutorStatus.FREE;
    private Queue<Activity> activityQueue = new LinkedList<>();

    protected Executor() {

    }
}
