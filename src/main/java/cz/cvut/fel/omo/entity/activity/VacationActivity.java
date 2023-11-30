package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.item.ItemType;
import cz.cvut.fel.omo.entity.living.Role;
import cz.cvut.fel.omo.smarthome.home.Home;
import cz.cvut.fel.omo.smarthome.room.RoomType;

public class VacationActivity extends Activity {

    public VacationActivity() {
        super(168, "Vacation activity", RoomType.OUTSIDE);
    }

    @Override
    protected void solve() {
        if (this.executor.getRole() == Role.FATHER) {
            Home.getInstance().getAllRooms().stream()
                    .filter(room -> room.getRoomType() == RoomType.GARAGE)
                    .findFirst()
                    .flatMap(room -> room.getItemList().stream()
                            .filter(i -> i.getType() == ItemType.CAR)
                            .findFirst())
                    .ifPresent(Item::use);
        }
    }
}
