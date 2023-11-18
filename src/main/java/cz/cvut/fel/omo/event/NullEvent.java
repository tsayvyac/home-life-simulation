package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.entity.Type;
import cz.cvut.fel.omo.entity.activity.Activity;
import cz.cvut.fel.omo.entity.living.Executor;
import cz.cvut.fel.omo.entity.living.Role;
import cz.cvut.fel.omo.entity.living.person.Person;
import java.util.Collections;

import java.util.List;
import static cz.cvut.fel.omo.util.Constant.NULL;

public class NullEvent extends Event {

    public NullEvent(){
        super(NULL, new Person(NULL, Role.FROG), Type.PET);
    }

    protected NullEvent(String name, Executor executor) {
        super(name, executor, Type.PET);
    }

    @Override
    protected List<Activity> init() {
        return Collections.emptyList();
    }
}
