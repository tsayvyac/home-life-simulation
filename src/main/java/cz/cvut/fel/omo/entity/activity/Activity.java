package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;
import cz.cvut.fel.omo.nullable.NullableRoom;

public abstract class Activity {
    protected NullableRoom room;
    protected int ticksToSolve;

    protected Activity() {}

    public void execute(Executor executor) {
        executor.setStatus(ExecutorStatus.BUSY);
        executor.setTicks(this.ticksToSolve);
        solve(executor);
    }

    protected abstract void solve(Executor executor);
}
