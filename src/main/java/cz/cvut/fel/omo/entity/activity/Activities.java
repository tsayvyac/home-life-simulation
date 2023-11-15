package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.smarthome.room.RoomType;
import lombok.Getter;

@Getter
public enum Activities {
    WORK(new WorkActivity(RoomType.OUTSIDE, 8)),
    SCHOOL(new SchoolActivity(RoomType.OUTSIDE, 8)),
    PLAY(new PlayActivity(RoomType.LIVINGROOM, 3)),
    EAT(new EatActivity(RoomType.KITCHEN, 2)),
    PLAYTOY(new PlayToyActivity(RoomType.GARAGE, 2));

    private final Activity activity;

    Activities(Activity activity) {
        this.activity = activity;
    }
}
