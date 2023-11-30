package cz.cvut.fel.omo.entity.activity;

import cz.cvut.fel.omo.entity.item.Item;
import cz.cvut.fel.omo.entity.item.ItemType;
import cz.cvut.fel.omo.report.ActivityAndUsageReporter;
import cz.cvut.fel.omo.smarthome.room.RoomType;

import java.util.Optional;

/**
 * Activity for doing sport
 */
public class DoSportActivity extends Activity {

    /**
     * Constructor for DoSportActivity
     */
    public DoSportActivity() {
        super(3, "Doing sport activity", RoomType.GARAGE);
    }

    @Override
    protected void solve() {
        Optional<Item> itemOptional = executor.getRoom().getItemList().stream()
                .filter(item -> item.getType() != ItemType.CAR)
                .filter(Item::getStatus)
                .findAny();

        relocateToOutside();
        if (itemOptional.isPresent()) {
            executor.setItem(itemOptional.get());
            this.item = itemOptional.get();
            itemOptional.get().use();
            ActivityAndUsageReporter.add(this.executor.getRole() + " is using " + itemOptional.get().getType());
        }
    }
}
