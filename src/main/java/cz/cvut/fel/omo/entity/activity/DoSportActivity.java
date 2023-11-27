package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.item.ItemType;
import cz.cvut.fel.omo.smarthome.room.RoomType;

import java.util.Optional;

public class DoSportActivity extends Activity {

    public DoSportActivity() {
        super(RoomType.GARAGE, 3, "Doing sport");
    }

    @Override
    protected void solve() {
        Optional<Item> itemOptional = executor.getRoom().getItemList().stream()
                .filter(item -> item.getType() != ItemType.CAR)
                .filter(Item::getStatus)
                .findAny();

        if (itemOptional.isPresent()) {
            executor.setItem(itemOptional.get());
            this.item = itemOptional.get();
            itemOptional.get().use();
        }
        relocateToOutside();
    }
}
