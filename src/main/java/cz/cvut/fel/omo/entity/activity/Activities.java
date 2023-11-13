package cz.cvut.fel.omo.entity.activity;

public class Activities {
    protected static final Activity[] list = {
            new WorkActivity(8),
            new SchoolActivity(8),
            new PlayActivity(2),
    };

    private Activities() {}
}
