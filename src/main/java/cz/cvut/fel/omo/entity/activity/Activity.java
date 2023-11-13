package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.ExecutorStatus;

public abstract class Activity {
    protected int ticksToSolve;

    protected Activity(int ticksToSolve) {
        this.ticksToSolve = ticksToSolve;
    }

    public void execute(Executor executor) {
        executor.setStatus(ExecutorStatus.BUSY);
        executor.setTicks(this.ticksToSolve);
        solve(executor);
    }

    protected abstract void solve(Executor executor);
}
